package web;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 *
 * @author mikel
 */
@WebServlet("/ServletHeaders")
public class Servlet extends HttpServlet{
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String metodoHttp = request.getMethod();
        out.print("<html>");
        out.print("<head>");
        out.print("<title>Headers HTTP</title>");
        out.print("</head>");
        out.print("<body>");
        out.print("<h1>Headers HTTP</h1>");
        out.print("Metodo HTTP: "+metodoHttp);
        
        String uri = request.getRequestURI();
        out.print("<br>");
        out.print("Uri solicitada: "+uri);
        
        out.print("<br>");
        out.print("<br>");
        //Imprimimos todos los cabeceros disponibles
        Enumeration cabeceros = request.getHeaderNames();
        while(cabeceros.hasMoreElements()){
            String nombreCabecero = cabeceros.nextElement().toString();
            out.print("<b>"+nombreCabecero+"</b>:");
            out.print(request.getHeader(nombreCabecero));
            out.print("<br>");
        }
        
        out.print("</body>");
        out.print("</html>");
        out.close();
        
        
    }
}
