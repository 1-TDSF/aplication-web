<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="../snippet/imports/libs-head.jsp"%>
<title>404</title>
</head>
<body>
		<%@ include file="../snippet/menus/menu-header.html"%>
	
	<div class="jumbotron">
		<h1 class="display-4">A página : ${param.nome-pagina}</h1>
		<h2 class="display-3">Msg : ${param.msgStatus}</h2>
		
		<hr class="my-4">
		<p>Contate o admin.</p>
		<p><a href="mailto:ale@fiap.com">ADMIN</a></p>
	</div>
	
	<%@ include file="../snippet/imports/libs-footer.jsp"%>
</body>
</html>