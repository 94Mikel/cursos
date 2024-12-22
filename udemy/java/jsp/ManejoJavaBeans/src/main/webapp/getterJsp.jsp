<%-- 
    Document   : getterJsp
    Created on : 31 may 2024, 10:08:07
    Author     : mikel
--%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP que lee los valores de JavaBean</title>
    </head>
    <body>
        <h1>JSP que lee los valores de JavaBean</h1>
        <jsp:useBean id="rectangulo" class="beans.Rectangulo" scope="session" />
        <br/>
        Valor base: <jsp:getProperty name="rectangulo" property="base" />
        <br/>
        Valor altura: <jsp:getProperty name="rectangulo" property="altura" />
        <br/>
        <!-- Se le llama al metodo getArea -->
        Valor area: <jsp:getProperty name="rectangulo" property="area" />
        <br/>
        <br/>
        <a href="index.jsp">Regresar al inicio</a>
    </body>
</html>
