<%-- 
    Document   : fondoColor
    Created on : 30 may 2024, 8:59:00
    Author     : mikel
--%>

<%--Recuperamos parametro "color de fondo"--%>

<%
    String fondo = request.getParameter("colorFondo");
    if(fondo == null || fondo.trim().equals("")){
        fondo = "white";
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP cambio de color</title>
    </head>
    <body bgcolor="<%= fondo%>">
        <h1>JSP cambio de color</h1>
        <br>
        Color de fondo aplicado: <%=fondo%>
        <br>
        <a href="index.html">Regresar al inicio</a>
    </body>
</html>
