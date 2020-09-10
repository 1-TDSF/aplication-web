<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
 
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	
	<%@ include file="imports.jsp"%>
	
	
<title>INÍCIO</title>
</head>
<body>
	
	<header>
	<nav class="nav">
		<ul class="nav">
			<%-- Criando uma QueryString para enviar o parâmetro para info.--%>
			<li class="nav-item"><a href="info.jsp?imgUrl=./img/jsp-1.png">IMG-1</a></li>
			<li class="nav-item"><a href="info.jsp?imgUrl=./img/jsp-2.jpg">IMG-2</a></li>
			<li class="nav-item"><a href="info.jsp?imgUrl=./img/jsp-3.png">IMG-3</a></li>
		</ul>
	</nav>

	</header>
	
	<%@ include file="rodape.jsp"%>
</body>
</html>