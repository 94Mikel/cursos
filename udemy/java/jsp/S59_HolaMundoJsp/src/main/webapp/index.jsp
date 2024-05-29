<%-- 
    Document   : index
    Created on : 29 may 2024, 10:45:30
    Author     : mikel
    Definicion : JSP basicamente es componente en el lado del servidor que insertar codigo java en un html 
    Opciones   : 
    scriplets => <%  
    expresion declarar variables => <%!
    comentario => <%--
    expresion para imprimir => <%=
--%>

<%-- Declarar uso de la libreria --%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>HolaMundo JSPs</title>
    </head>
    <body>
        <h1>HolaMundo JSPs</h1>
        <ul>
            <li> <% out.print("Hola mundo con Scriplets"); %> </li>
            <li> ${"HolaMundo con Expression Language (EL)"}</li>
            <li><%= "HolaMundo con expresiones" %></li>
            <li> <c:out value="HolaMundo con JSTL"/></li>
        </ul>

    </body>
</html>
