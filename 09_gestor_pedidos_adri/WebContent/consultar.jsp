<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<center>
		<div class="container">		
			  <table class="table table-striped">
			    <thead>
			      <tr>
			        <th>ID</th>
			        <th>Producto</th>
			        <th>Precio</th>
			        <th>Categoría</th>
			        <th></th>
			        <th></th>
			      </tr>
			    </thead>
			    <tbody>    
			    	<c:forEach var="pedido" items="${requestScope.pedidos}">    
				      <tr>
				        <td>${pedido.idPedido}</td>
				        <td>${pedido.producto}</td>
				        <td>${pedido.precio}</td>
				        <td>${pedido.categoria}</td>
				        <td><a href="Controller?op=doEliminar&id=${pedido.idPedido}">Eliminar</a></td>
				        <td><a href="Controller?op=doEditar&id=${pedido.idPedido}">Editar</a></td>
				      </tr>
			      </c:forEach>
			    </tbody>
			  </table>
			
		 <div class="col-sm-10">		
				<a type="button" href='Controller?op=toVolver' class="btn btn-default">Volver</a>
			</div>
		</div>
	</center>

</body>
</html>