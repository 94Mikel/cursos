package mx.com.gm.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import mx.com.gm.domain.Alumno;
import mx.com.gm.domain.Contacto;
import mx.com.gm.domain.Domicilio;
import mx.com.gm.service.ServicioAlumno;

@WebServlet("/ServletAgregar")
public class ServletAgregar extends HttpServlet{
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        //Alumno
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        
        //Domicilio
        String calle = request.getParameter("calle");
        String noCalle = request.getParameter("noCalle");
        String pais = request.getParameter("pais");
        
        //Contacto
        String email = request.getParameter("email");
        String telefono = request.getParameter("telefono");
        
        Domicilio domicilio = new Domicilio();
        domicilio.setCalle(calle);
        domicilio.setNoCalle(noCalle);
        domicilio.setPais(pais);
        
        Contacto contacto = new Contacto();
        contacto.setEmail(email);
        contacto.setTelefono(telefono);
        
        Alumno alumno = new Alumno();
        alumno.setNombre(nombre);
        alumno.setApellido(apellido);
        alumno.setDomicilio(domicilio);
        alumno.setContacto(contacto);
        //Se guardara de forma automatica el domicilio y el contacto ya que tenemo la persistencia en cascada
        
        //Creamos la instacia de ServicioAlumno para guardar el alumno. 
        //Este servicio se comunicara con la capa de datos para insertar los datos en la base de datos
        ServicioAlumno servicioAlumno = new ServicioAlumno();
        servicioAlumno.guardarAlumno(alumno);
        
        //redireccionamos a la pagina principal index
        request.getRequestDispatcher("/index.jsp").forward(request, response);
        
    }
    
}
