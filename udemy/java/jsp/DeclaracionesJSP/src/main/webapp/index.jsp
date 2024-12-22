<%-- 
    Document   : index
    Created on : 30 may 2024, 9:38:10
    Author     : mikel
--%>

<%-- Agregamos una declaracion con JSP --%>
<%!
    
/*    
Si no se declara con modificadores de acceso, 
las variables NO son parte de la definicion de la clase.
*/

//Declaramos una variable con su metodo get
private String usuario = "Alberto";

public String getUsuario(){
    return this.usuario;
}

//Declaramos un contador de visitas
private int contadorVisitas = 1;
    
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Uso de Declaraciones con JSPs</title>
    </head>
    <body>
        <h1>Uso de Declaraciones con JSPs</h1>
        Valor usuario por medio del atributo: <%= this.usuario %>
        <br>
        Valor usuario por medio del metodo: <%= this.getUsuario()%>
        <br>
        Contador de Visitas: <%= this.contadorVisitas++%>
    </body>
</html>
