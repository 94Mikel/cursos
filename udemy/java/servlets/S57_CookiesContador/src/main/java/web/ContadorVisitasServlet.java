package web;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author mikel
 */
@WebServlet("/ContadorVisitasServlet")
public class ContadorVisitasServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        //Declaramos la variable contador
        int contador = 0;
        
        //Revisamos si existe la cookie contadorVisitas
        Cookie[] cookies = request.getCookies();
        if(cookies != null){
            for (Cookie cooky : cookies) {
                if(cooky.getName().equals("contadorVisitas")){
                    contador = Integer.parseInt(cooky.getValue());
                }
            }
        }
        
        //Incrementar el contador
        contador++;
        
        //Agregamos la respuesta al navegador.
        Cookie c = new Cookie("contadorVisitas", Integer.toString(contador));
        //La cookie se almacenara en el cliente por 1 hora (3600 segundos)
        c.setMaxAge(3600);
        //Añadir el cookie al cliente
        response.addCookie(c);
        
        //Mandamos el mensaje al navegador
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.print("Contador de visitas de cada cliente: "+contador);
        
    }
}
