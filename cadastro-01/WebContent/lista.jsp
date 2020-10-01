<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="f"%>

	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1">
<link rel="stylesheet" href="./css/bootstrap.css" type="text/css">

<title>LISTAGEM</title>
</head>
<body>

<%@ include file="menu-header.html"%>


	<div></div>
	<section>
	
		<table class="table table-hover">
			<tr>
				<th>ID</th>
				<th>Nome</th>
				<th>Dt Nasc</th>
				<th>Gênero</th>
				<th>Tel</th>
				<th colspan="2">Editar</th>
			</tr>

		<c:forEach var="cli" items="${listaCliente}" varStatus="id">
			<tr>
				<td>${id.count}</td>
				<td>${cli.nome} ${cli.sobrenome}</td>
				<td><f:formatDate value="${cli.dataNasc}" pattern="dd/mm/yyyy"/></td>
				
				<c:choose>
					<c:when test="${cli.genero eq 'm'}">
						<td>Masculino</td>
					</c:when>
					<c:when test="${cli.genero eq 'f'}">
						<td>Feminino</td>
					</c:when>
					<c:otherwise>
						<td>Outros</td>
					</c:otherwise>
				</c:choose>
				
				<td>${cli.telefone }</td>
				<td><a href="list-cli?id-cli=${id.count}">Atualizar</a></td>
				<td><a href="del-cli?id-cli=${id.count}">Excluir</a></td>
			</tr>
		</c:forEach>
			
		</table>
		
		
	</section>
	<footer></footer>

	<script type="text/javascript" src="./js/jquery-3.5.1.min.js"></script>
	<script type="text/javascript" src="./js/bootstrap.js"></script>
</body>
</html>










