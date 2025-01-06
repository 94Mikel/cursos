package mx.com.gm.web;

//CAPA WEB
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import mx.com.gm.domain.Persona;
import mx.com.gm.servicio.ServicioPersonas;

@WebServlet("/ServletControlador")//path que vamos a utilizar con la anotacion de webservelt
public class ServletControlador extends HttpServlet {//extender de HttpServelet para que sea convierta en un servlet
    
    //sobrescribir el metodo doGet
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response){
        ServicioPersonas servicioPersonas = new ServicioPersonas();
        
        //Con patron de diseño mvc => modelo, vista, controlador
        //Solicitamos la lista de personas
        List<Persona> personas = servicioPersonas.listarPersonas();
        
        //Seleccionamos un alcance. En este caso request
        request.setAttribute("personas", personas);
        
        try {
            request.getRequestDispatcher("/WEB-INF/listado.jsp").forward(request, response);
        } catch (ServletException ex) {
            ex.printStackTrace(System.out);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
        
        
        
    }
    
    
}
