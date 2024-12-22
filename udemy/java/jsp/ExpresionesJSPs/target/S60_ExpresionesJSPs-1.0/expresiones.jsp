<%-- 
    Document   : expresiones
    Created on : 29 may 2024, 17:02:09
    Author     : mikel
--%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP con expresiones</title>
    </head>
    <body>
        <h1>JSP con Expresiones</h1>
        Concatenacion: <%= "Saludos"+ " "+ "JSP" %>
        <br>
        Operacion Matematica <%= 2 * 3 / 2 %>
        <br>
        Session id: <%= session.getId() %>
        <br>
        <br>
        <a href="index.html"> Regresar al inicio </a>
    </body>
</html>
