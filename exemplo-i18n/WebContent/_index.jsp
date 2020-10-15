<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="f" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<div>
	<a href="change">LINK_TO_SERVLET</a>
</div>

<c:set var="saudacao" scope="request" value="BEM VINDO"/>
<h1><c:out value="${saudacao}"/></h1>

<c:set var="valor" scope="request" value="10"/>
<h2>Valor:<f:formatNumber value="${valor}" type="currency" currencySymbol="$"/></h2>


	<table border="1">
		<tr>
			<th>ID</th>
			<th>Nome</th>
		</tr>
		<c:forEach var="n" items="${lista}" varStatus="id">
			<tr bgcolor="${id.count % 2 == 0 ? '#ff0000':'#0000ff'}">
				<td>${id.count}</td>
				<td>${n}</td>
			</tr>
		</c:forEach>
	</table>


</body>
</html>