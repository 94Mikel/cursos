package gm.rh.controlador;

import gm.rh.servicio.EmpleadoServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    
    
}
