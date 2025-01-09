package mx.com.gm.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import mx.com.gm.domain.Alumno;
import mx.com.gm.service.ServicioAlumno;

@WebServlet("/ServletControlador")
public class ServletControlador extends HttpServlet {
    
    //Peticion inicial para empezar nuestr applicacion web
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        ServicioAlumno servicioAlumno = new ServicioAlumno();
        
        List<Alumno> alumnos = servicioAlumno.listarAlumnos();
        
        //Enviar la información para que pueda leer el JSP
        request.setAttribute("alumnos", alumnos);
        
        try {
            //redirijir a una vista
            request.getRequestDispatcher("/WEB-INF/listarAlumnos.jsp").forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        } 
        
    }
}
