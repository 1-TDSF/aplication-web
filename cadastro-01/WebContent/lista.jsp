<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width,initial-scale=1">
<link rel="stylesheet" href="./css/bootstrap.css" type="text/css">

<title>LISTAGEM</title>
</head>
<body>

	<header>
		<nav></nav>
	</header>
	<div></div>
	<section>
	
		<table border="1">
			<tr>
				<th>ID</th>
				<th>Nome</th>
				<th>Dt Nasc</th>
				<th>Gênero</th>
				<th>Tel</th>
				<th>Editar</th>
			</tr>

			<tr>
				<td>ID</td>
				<td>${listaCliente[0].nome} ${listaCliente[0].sobrenome}</td>
				<td>${listaCliente[0].dataNasc}</td>
				<td>${listaCliente[0].genero}</td>
				<td>${listaCliente[0].telefone }</td>
				<td>Editar</td>
			</tr>
					
			
		</table>
		
		
	</section>
	<footer></footer>

	<script type="text/javascript" src="./js/jquery-3.5.1.min.js"></script>
	<script type="text/javascript" src="./js/bootstrap.js"></script>
</body>
</html>