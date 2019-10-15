<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<meta charset="ISO-8859-1">
<meta http-equiv="Content-Type" content="text/html;  charset=ISO-8859-1" >
<title>Insert title here</title>
	<script type="text/javascript">	
	
	//LOAD TEMAS
// 	function loadTemas(){
// 		var url="Controller?op=doTemas";
// 	}

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
<body >
 
        <h1>Seleccione Tema</h1>
        <br/><br/>		
		<select name="tema" onchange="lanzarPeticion(this.value);">
			<option value="40">Selecciona tema</option>
			<option value="0">Todos</option>
			<c:forEach var="t" items="${requestScope.temas}">
				<option value="${t.idTema}">${t.tema}</option>				
			</c:forEach>
		</select>
		<br/><br/>	
 
        
	<br/><br/>
	<div id="tabla"></div>


</body>
</html>