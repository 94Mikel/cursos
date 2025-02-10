package gm.rh.servicio;

import gm.rh.modelo.Empleado;
import gm.rh.repositorio.EmpleadoRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service//para indicar que es un bean de spring
public class EmpleadoServicio implements IEmpleadoServicio{
    
    @Autowired
    private EmpleadoRepositorio empleadoRespositorio;

    @Override
    public List<Empleado> listarEmpleados() {
        return empleadoRespositorio.findAll();
    }

    @Override
    public Empleado buscarEmpleadoPorId(Integer idEmpleado) {
        //orElse => si no se encuentra el registro devuelve un null
        return empleadoRespositorio.findById(idEmpleado).orElse(null);
    }

    @Override
    public Empleado guardarEmpleado(Empleado empleado) {
        //también devuelve el objeto que se a guardado en la db
        return empleadoRespositorio.save(empleado);
    }

    @Override
    public void eliminarEmpleado(Empleado empleado) {
        empleadoRespositorio.delete(empleado);
    }
    
}
