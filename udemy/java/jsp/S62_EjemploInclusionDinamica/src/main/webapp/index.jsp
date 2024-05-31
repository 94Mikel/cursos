<%-- 
    Document   : index
    Created on : 30 may 2024, 13:41:34
    Author     : mikel
--%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ejemplo Inclusion Dinámica</title>
    </head>
    <body>
        <h1>Ejemplo Inclusion Dinámica</h1>
        <br/>
        <jsp:include page="paginas/recursoPublico.jsp"/>
        <br/>
        <jsp:include page="WEB-INF/recursoPrivado.jsp">
            <jsp:param name="colorFondo" value="yellow"/>
        </jsp:include>
    </body>
</html>
