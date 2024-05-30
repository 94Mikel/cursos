<%-- 
    Document   : manejoErrores
    Created on : 30 may 2024, 11:34:45
    Author     : mikel
--%>

<%--
Indicamos que es una pagina de error.
Si no se indica que la pagina es de manejo de error,
no podriamos acceder al objeto exception
--%>
<%@page isErrorPage="true" %>
<%@page import="java.io.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manejo de Errores</title>
    </head>
    <body>
        <h1>Manejo de Errores</h1>
        <br/>
        Ocurrio una excepcion: <%= exception.getMessage() %>
        <br/>
        <textarea name="name" rows="5" cols="30">
            <% exception.printStackTrace(new PrintWriter(out)); %>
        </textarea>

    </body>
</html>
