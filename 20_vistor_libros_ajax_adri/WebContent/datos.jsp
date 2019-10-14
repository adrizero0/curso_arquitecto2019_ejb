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
	
	//BUSCAR LA LISTA DE TEMAS
	function loadTemas(){
		var url="Controller?op=doTemas";
		$.get(url,function(data,status){
			procesarRespuestaTema(data);
		})
	}
	
	//PARSEAR LA CADENA DE TEXTO A JSON
	function procesarRespuestaTema(data){
		var json=JSON.parse(data);
		console.log(json[0].tema);
		var tema;
		for (var i=0;i<json.length;i++){
			console.log(json[i].tema);
			console.log(json[i].idTema);
		}
		$("#tema").html(tema)
		console.log("entramos a procesarRespuestaTema");
	}

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
<body onload="loadTemas()">
     
    <div >
        <h1>Seleccione Tema</h1>
        <br/><br/>		
		<select name="tema" id="tema" onchange="lanzarPeticion(this.value);">
			<option value="0">Selecciona tema</option>
			<option value="0">Todos</option>
			<option value="1">El 1</option>
		</select>
		<br/><br/>	
    </div>
        
	<br/><br/>
	<div id="tabla"></div>


</body>
</html>