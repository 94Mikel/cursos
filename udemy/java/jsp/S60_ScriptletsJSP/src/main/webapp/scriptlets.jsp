<%-- 
    Document   : scriptlets
    Created on : 30 may 2024, 8:59:35
    Author     : mikel
--%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP con Scriptlets</title>
    </head>
    <body>
        <h1>JSP con Scriptlets</h1>
        <br>
        <%-- Scriptlet para enviar informacion al navegador--%>
        <%
            out.print("Saludios desde un scriptlet");
        %>

        <%-- Scriptlet para manipular los objetos inplicitos --%>
        <%
            String nombreAplicacion = request.getContextPath();
            out.print("nombre de la aplicacion: "+nombreAplicacion);
        %>
        <br>
        <%-- Scriptlet con codigo condicionado (no es recomendable, se debe hacer con mvc) --%>

        <%
            if(session != null && session.isNew()){
        %>
        la sesion SI en nueva
        <%
            } else if(session != null) {
        %>
        la sesion NO es nueva 
        <% } %>

        <br>
        <a href="index.html">Regresar al inicio</a>

    </body>
</html>
