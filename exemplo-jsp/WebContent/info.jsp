<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<%@ include file="imports.jsp"%>
<title>INFO</title>
</head>
<body>

	<%-- RECEPCIONAR O PARÂMETRO VINDO DA PÁGINA INDEX.JSP COM EL--%>
	<div>
	
	<c:choose>
		<c:when test="${param.imgUrl != ''}">

			<figure>
				<img alt="" src="${param.imgUrl}">
			</figure>
				
		</c:when>
		<c:when test="${param.imgUrl == ''}">

			<jsp:forward page="no-img.html"/>
			
		</c:when>
	</c:choose>
		
	</div>
	<a href="index.jsp">INÍCIO</a>

	<%@ include file="rodape.jsp"%>
</body>
</html>