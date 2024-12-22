package web;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author mikel
 */
@WebServlet("/CookiesServlet")
public class CookiesServlet extends HttpServlet{
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        
        //Suponemos que el usuario visita por primara vez nuestro sitio
        boolean nuevoUsuario = true;
        
        //Obtenemos el arreglo de cookies
        Cookie[] cookies = request.getCookies();
        
        //Buscamos si ya existe una cookie creada con aterioridad
        //llamada visitanteRecurrente
        
        if(cookies != null){
            for (Cookie cooky : cookies) {
                if(cooky.getName().equals("visitanteRecurrente") && cooky.getValue().equals("si")){
                    //Si ya existe la cookie es un usuario recurrente
                    nuevoUsuario = false;
                    break;
                }
            }
        }
        
        String mensaje = null;
        if(nuevoUsuario){
            Cookie visitanteCookie = new Cookie("visitanteRecurrente","si");
            response.addCookie(visitanteCookie);
            mensaje = "Gracias por visitar nuestro sitio por primera vez";
        }else{
            mensaje = "Gracias por visitar nuevamente nuestro sitio";
        }
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.print("Mensaje: "+mensaje);
        out.close();
        
    }
}
