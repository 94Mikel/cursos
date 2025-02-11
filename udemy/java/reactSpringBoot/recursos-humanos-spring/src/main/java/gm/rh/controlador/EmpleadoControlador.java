package gm.rh.controlador;

import gm.rh.excepcion.RecursoNoEncontradoExcepcion;
import gm.rh.modelo.Empleado;
import gm.rh.servicio.EmpleadoServicio;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/*
RestController => para utilizar este controlador dentro de la fabrica de spring. 
Con esto podemos realizar y recibir peticiones de tipo REST.

RequestMapping => ContextPath de nuestra aplicación o el contexto de ruta de la aplicación
Especificamos a nivel de clase. Hay que especificar el nombre.
Todos los url que vamos a utilizar tendrán la siguiente forma:
    - http://localhost:8080/rh-app/empleados/1 ....

CrossOrigin => Para realizar peticiones desde nuestra aplicación frontEnd.
El front estara en el puerto 3000 y el back en 8080 con esta anotación indicamos que vamos a recibir peticiones del puerto 3000
La aplicación de react se ejecuta en el puerto 3000 por defecto.
Si no se pone esta anotación todas las peticiones seran rechazadas.

*/


@RestController
@RequestMapping("rh-app")
@CrossOrigin(value = "http://localhost:3000")
public class EmpleadoControlador {
    
    private static final Logger logger = 
            LoggerFactory.getLogger(EmpleadoControlador.class);
    
    //Porque tenemos la anotación de RestControler y entra dentro de spring.
    //Spring realiza la instacia de EmpleadoServicio por nosotros.
    @Autowired
    private EmpleadoServicio empleadoServicio;
    
    //http://localhost:8080/rh-app/empleados
    @GetMapping("/empleados")
    public List<Empleado> obtenerEmpleados(){
        List<Empleado> empleados = empleadoServicio.listarEmpleados();
        empleados.forEach((empleado) -> logger.info(empleado.toString()));
        return empleados;
    }
    
    @PostMapping("/empleados")
    public Empleado agregarEmpleado(@RequestBody Empleado empleado){
        logger.info("Empleado a agregar: "+empleado.toString());
        return empleadoServicio.guardarEmpleado(empleado);
    }
    
    @GetMapping("/empleados/{id}")
    public ResponseEntity<Empleado> obtenerEmpleadoPorId(@PathVariable Integer id){
        Empleado empleado = empleadoServicio.buscarEmpleadoPorId(id);
        if(empleado == null){
            throw new RecursoNoEncontradoExcepcion("No se encontro el id: "+id);
        }
        return ResponseEntity.ok(empleado);
    }
    
    @PutMapping("/empleados/{id}")
    public ResponseEntity<Empleado> actualizarEmpleado(@PathVariable Integer id, @RequestBody Empleado empleadoRecibido){
        Empleado empleado = empleadoServicio.buscarEmpleadoPorId(id);
        if(empleado == null){
            throw new RecursoNoEncontradoExcepcion("El id recibido no existe: "+id);
        }
        
        empleado.setNombre(empleadoRecibido.getNombre());
        empleado.setDepartamento(empleadoRecibido.getDepartamento());
        empleado.setSueldo(empleadoRecibido.getSueldo());
        
        empleadoServicio.guardarEmpleado(empleado);
        return ResponseEntity.ok(empleado);
    }
    
    @DeleteMapping("/empleados/{id}")
    public ResponseEntity<Map<String, Boolean>> eliminarEmpleado(@PathVariable Integer id){
        Empleado empleado = empleadoServicio.buscarEmpleadoPorId(id);
        if(empleado == null){
            throw new RecursoNoEncontradoExcepcion("No se encontro el id: "+id);
        }
        empleadoServicio.eliminarEmpleado(empleado);
        //JSON {"eliminado":"true"}
        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("eliminado", Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }
    
}
