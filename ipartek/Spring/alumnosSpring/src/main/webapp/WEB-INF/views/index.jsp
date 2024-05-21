<%@ page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<body>
	<h2>Crear nuevo cd TOP</h2>
		<form:form method="post" action="alumnos" modelAttribute="alumno">
			<form:input path="nombre" placeholder="Nombre"/>
			<form:input path="apellidos" placeholder="Apellidos"/>
			<form:input path="direccion" placeholder="Direccion"/>
			<form:input path="telefono" placeholder="Telefono"/>
			<form:button>Enviar</form:button>
		</form:form>
	<hr>
	<h2>Top Cds Vendidos</h2>
	
	<table style="width:100%">
	  <tr>
	    <th>Nombre</th>
	    <th>Apellidos</th>
	    <th>Direccion</th>
	    <th>Telefono</th>
	  </tr>
	  <c:forEach items="${alumnos}" var="alumno">
	  	<tr>
		    <td><center>${alumno.nombre}</center></td>
		    <td><center>${alumno.apellidos}</center> </td>
		    <td><center>${alumno.direccion}</center></td>
		    <td><center>${alumno.telefono}</center></td>
	   </tr>
	 </c:forEach>
	</table>
	
</body>
</html>
