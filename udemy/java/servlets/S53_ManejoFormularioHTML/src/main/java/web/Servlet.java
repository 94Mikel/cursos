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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String usuario = request.getParameter("usuario");
        String password = request.getParameter("password");
        String tecnologias[] = request.getParameterValues("tecnologia");
        String genero = request.getParameter("genero");
        String ocupacion = request.getParameter("ocupacion");
        String musica[] = request.getParameterValues("musica");
        String comentarios = request.getParameter("comentarios");

        out.print("<html>");
        out.print("<head>");
        out.print("<title>Resultado Servlet</title>");
        out.print("</head>");
        out.print("<body>");
        out.print("<h1>Parametros procesados por el Servlet:</h1>");
        out.print("<table border='1'>");

        //usuario
        out.print("<tr>");
        out.print("<td>");
        out.print("Usuario");
        out.print("</td>");
        out.print("<td>");
        out.print(usuario);
        out.print("</td>");
        out.print("</tr>");

        //password
        out.print("<tr>");
        out.print("<td>");
        out.print("Password");
        out.print("</td>");
        out.print("<td>");
        out.print(password);
        out.print("</td>");
        out.print("</tr>");

        //tecnologias
        out.print("<tr>");
        out.print("<td>");
        out.print("Tecnologias");
        out.print("</td>");
        for (String tecnologia : tecnologias) {
            out.print("<td>");
            out.print(tecnologia);
            out.print("</td>");
        }
        out.print("</tr>");

        //genero
        out.print("<tr>");
        out.print("<td>");
        out.print("Genero");
        out.print("</td>");
        out.print("<td>");
        out.print(genero);
        out.print("</td>");
        out.print("</tr>");

        //ocupacion
        out.print("<tr>");
        out.print("<td>");
        out.print("Ocupación");
        out.print("</td>");
        out.print("<td>");
        out.print(ocupacion);
        out.print("</td>");
        out.print("</tr>");

        //musica
        out.print("<tr>");
        out.print("<td>");
        out.print("Música");
        out.print("</td>");
        if (musica != null) {
            for (String mus : musica) {
                out.print("<td>");
                out.print(mus);
                out.print("</td>");
            }
        } else {
            out.print("<td>");
            out.print("</td>");
        }

        out.print("</tr>");

        //comentario
        out.print("<tr>");
        out.print("<td>");
        out.print("Comentario");
        out.print("</td>");
        out.print("<td>");
        out.print(comentarios != null ? comentarios : "");
        out.print("</td>");
        out.print("</tr>");

        out.print("</table>");
        out.print("</body>");
        out.print("</html>");

    }

}
