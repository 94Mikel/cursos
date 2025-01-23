<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<!-- s => prefijo struts uri => que esta configurada dentro del jar de struts (dentro de las librerias) -->
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Saludos desde Struts 2</title>
    </head>
    <body>
        <h1><s:property value="saludosAtr"></s:property></h1><!-- Se manda al metodo getSaludosAtr -->
    </body>
</html>
