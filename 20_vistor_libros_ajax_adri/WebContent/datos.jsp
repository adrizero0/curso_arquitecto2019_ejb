<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<title>Insert title here</title>
<<<<<<< HEAD
	<script type="text/javascript">	
=======
<meta http-equiv="Content-Type" content="text/html;  charset=ISO-8859-1" >

	<script type="text/javascript">
>>>>>>> branch 'master' of https://github.com/adrizero0/curso_arquitecto2019_ejb.git

	//BUSCAR LIBRO POR TEMA
	function lanzarPeticion(idTema){
		var url="Controller?op=doLibros&idTema="+idTema;
		$.get(url,function(data,status){
			procesarRespuesta(data);
		})
	}

	//PARSEAR LA CADENA DE TEXTO A JSON
	function procesarRespuesta(data){
		var json=JSON.parse(data);
		var tabla="<table border='1'><tr><th>Título</th><th>Autor</th><th>Precio</th>";
		for (var i=0;i<json.length;i++){
			tabla+="<tr><td>"+json[i].titulo+"</td><td>"+json[i].autor+"</td><td>"+json[i].precio+"</td>"
		}
		tabla+="</table>";
		$("#tabla").html(tabla);
	}
	
	</script>
</head>
<body>
     
    <div>
        <h1>Seleccione Tema</h1>
        <br/><br/>    
		<select name="tema" onchange="lanzarPeticion(this.value);">
			<option value="0">Selecciona tema</option>
			<option value="0">Todos</option>
			<c:forEach var="t" items="${requestScope.temas}">
				<option value="${t.idTema}">${t.tema}</option>				
			</c:forEach>
		</select>
		<br/><br/>	
    </div>
        
	<br/><br/>
	<div id="tabla"></div>


</body>
</html>