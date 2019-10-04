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
	<div class="container">
	<c:set var="p" value="${requestScope.pedido}"/>
		<h1>Editar pedido</h1>
		<form action="Controller?op=doModificar&id=${p.idPedido}" method="post">
			<div class="form-group">
				<label>Producto:</label><input type="text" name="producto" required class="form-control" style="width:30%" value="${p.producto}" autocomplete="name" required/>
			</div>
			<div class="form-group">
				<label>Precio:</label><input type="number" name="precio" required class="form-control" style="width:30%" value="${p.precio}" required/>
			</div>
			  <div class="form-group">
			    <label>Categoría:</label><input type="text" name="categoria" required class="form-control" style="width:30%" value="${p.categoria}" required/>
			  </div>			 
			
			<button type="submit" class="btn btn-default">Guardar</button>
			
		</form>
	</div>

</body>
</html>