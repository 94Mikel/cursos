<%-- 
    Document   : alcanceVariables
    Created on : 1 jun 2024, 12:11:09
    Author     : mikel
--%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alcance de Variables</title>
    </head>
    <body>
        <h1>Alcance de Variables</h1>
        <br/>
        variable request:
        Base: ${rectanguloRequest.base}
        altura: ${rectanguloRequest.altura}
        area: ${rectanguloRequest.area}
                <br/>
        <br/>
        variable sesion
        Base: ${rectanguloSesion.base}
        altura: ${rectanguloSesion.altura}
        area: ${rectanguloSesion.area}
                <br/>
        <br/>
        variable aplicacion:
        Base: ${rectanguloAplicacion.base}
        altura: ${rectanguloAplicacion.altura}
        area: ${rectanguloAplicacion.area}
                <br/>
        <br/>
        <a href="${pageContext.request.contextPath}/index.jsp">
            Regresar al inicio
        </a>
    </body>
</html>
