<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EXEMPLO-INTEGRAÇÃO</title>
</head>
<body>
	
	<h1>EXEMPLO DE JSP INTEGRANDO COM SERVLET</h1>
	
	<div>
		<h2>RECEBENDO ATRIBUTOS DA SERVLET</h2>
		<p>Nome : ${attrNome}</p>
		<p>Nome : ${attrUser}</p>
	</div>
	
	<div>
		<h2>RECEBENDO O ATRIBUTO DO CONTEXTO DA SERVLET/APLICAÇÃO</h2>
		<p>Local Date : ${ctxLocalDate}</p>
	</div>

	<div>
		<h2>RECEBENDO O ATRIBUTO DO CONTEXTO DA SESSÃO</h2>
		<p>Login : ${login}</p>
		<p>Session ID : ${idSession}</p>
	</div>
	
	<div>
		<a href="inicio.html">LINK-TO-HTML</a>
	</div>
	
</body>
</html>