<%-- 
    Document   : reporteExcel
    Created on : 30 may 2024, 11:05:21
    Author     : mikel
--%>
<!--Importar clases java -->
<%@page errorPage="/WEB-INF/manejoErrores.jsp"%>
<%@page import="utilerias.Conversiones, java.util.Date" %>
<%@page contentType="application/vnd.ms-excel" %>

<%
    String nombreArchivo = "reporte.xls";
    response.setHeader("Content-Disposition", "inline;filename="+nombreArchivo);
%>

<%--
    Esto solo es un reporte basico.
    Si se quiere realizar el concepto de excel mejor, 
    se utilizan las librerias como la libreria de apache point 
    que es una libreria profesional para generar, leer contenido... reportes Excel.
--%>

<!DOCTYPE html>
<html>
    <head>
        <title>Reporte de Excel</title>
    </head>
    <body>
        <h1>Reporte de Excel</h1>
        <br/>
        <table border="1">
            <tr>
                <td>Curso</td>
                <td>Descripcion</td>
                <td>Fecha</td>
            </tr>
            <tr>
                <td>1. Fundamentos de Java</td>
                <td>Aprenderemos la sintaxis basica de Java</td>
                <td><%= Conversiones.format(new Date())%></td>
                <%--<td><%= Conversiones.format("500")%></td>--%>
            </tr>
            <tr>
                <td>2. Programación con Java</td>
                <td>Pondremos en practica conceptos de la progamación orientada a objetos</td>
                <td><%= Conversiones.format(new Date())%></td>
            </tr>
        </table>
    </body>
</html>
