package web;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author mikel
 */

@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
        //Leer los parametros del formulario html
        String usuario = request.getParameter("usuario");
        String password = request.getParameter("password");
        
        System.out.println("usuario = " + usuario);
        System.out.println("password = " + password);
        
        PrintWriter out = response.getWriter();
        
        //Se debe realizar con JSP pero es para hacer la prueba con servlet
        out.print("<html>");
        out.print("<body>");
        out.print("El parametro usuario es: "+usuario);
        out.print("<br/>");
        out.print("El parametro password es: "+password);
        out.print("</body>");
        out.print("</html>");
        
    }
}
