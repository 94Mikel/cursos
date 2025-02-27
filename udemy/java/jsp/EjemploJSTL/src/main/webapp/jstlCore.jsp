<%-- 
    Document   : jstlCore
    Created on : 31 may 2024, 16:58:11
    Author     : mikel
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSTL Core</title>
    </head>
    <body>
        <h1>JSTL Core (JSP Standard Tag Library)</h1>
        <!-- Manipulaciono de Variables -->
        <!-- Definimos la Variable -->
        <c:set var="nombre" value="Ernesto" />
        <!-- Desplegamos el valor de la variable -->
        Variable nombre: <c:out value="${nombre}"/>
        <br/>
        <br/>
        Variable con codigo html:
        <c:out value="<h4>Hola</h4>" escapeXml="false"/>
        <!-- Codigo condicionado, uso de if -->
        <c:set var="bandera" value="true"/>
        
        <c:if test="${bandera}">
            La bandera es verdadera
        </c:if>
        <!-- Codigo condicionado, uso de switch -->    
        <c:if test="${param.opcion != null}">
            <c:choose>
                <c:when test="${param.opcion == 1}">
                    <br/>
                    Opcion 1 seleccionado
                </c:when>
                <c:when test="${param.opcion == 2}">
                    <br/>
                    Opcion 2 seleccionado
                </c:when>
                <c:otherwise>
                    <br/>
                    Opcion proporcionada desconocida: ${param.opcion}
                </c:otherwise>
            </c:choose>
        </c:if>
        <!-- Iteracion de arreglo -->
        <%
            String nombres[] = {"Claudia","Pedro","Juan"};
            request.setAttribute("nombres",nombres);
        %>
        
        <br/>
        Lista de Nombres:
        <br/>
        <ul>
            <c:forEach var="persona" items="${nombres}">
                <li>${persona}</li>
            </c:forEach>
        </ul>

        <br/>
        <a href="index.jsp">Regresar al inicio</a>
            
    </body>
</html>
