<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<jsp:include page="imports1.jsp"/>
<title>EXEMPLO-SNIPPETS</title>
</head>
<body>
	<%-- Adicionando o include para os snippets --%>
		<jsp:include page="cabecalho.html"/>
		<jsp:include page="conteudo.html"/>
		<jsp:include page="rodape.html"/>
	<%-- Adicionando o include para os snippets --%>

	<jsp:include page="imports2.jsp"/>
</body>
</html>