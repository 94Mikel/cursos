package web;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/GeneracionExcelServlet")
public class GeneracionExcelServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        //indicamos el tipo de respuesta al navegador
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment;filename=excelEjemplo.xls");
        //Para un uso mas profesional de excel poi.apache.org
        
        //indicar al navegador que no guarde cache
        response.setHeader("pragma", "no-cache");
        response.setHeader("Cache-Control", "no-store");
        response.setDateHeader("Expires",-1);
        
        //desplegar la informacion al cliente
        PrintWriter out = response.getWriter();
        out.println("\tValores");
        out.println("\t1");
        out.println("\t2");
        out.println("\t3");
        out.println("Total\t=SUMA(b2:b3)");
        out.close();
        
    }
}
