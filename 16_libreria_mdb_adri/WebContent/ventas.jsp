<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:set var="ventas" value="${requestScope.ventas}"/>   
	<c:choose>
		<c:when test="${!empty ventas}">
	
			<table border="1">
			    <tr><th>Título</th><th>Fecha</th><th>Precio</th></tr>		    	
			    	<c:forEach var="ven" items="${ventas}">
			    		<tr>
			    			<td>${ven.libro.titulo}</td>
							<td>${ven.fecha}</td>
							<td>${ven.libro.precio}</td>
						</tr>		    	
			    	</c:forEach>
			</table>
		</c:when>
		<c:otherwise>
			<h2>No hay ventas</h2>
		</c:otherwise>
	</c:choose>
	<br/><br/>
	<a href="Controller?op=doTemas">Otro tema</a>

</body>
</html>