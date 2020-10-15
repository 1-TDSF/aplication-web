<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="f" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><f:message key="site.titulo"/></title>
</head>
<body>
   
   <h1><f:message key="site.msg.saudacao"/> </h1>
   
   <div>
   	<form action="">
   		<fieldset>
   			<legend><f:message key="site.form1.legenda"/></legend>
   			<div>
   				<div>
   					<label><f:message key="site.form1.campo.nome"/></label>
   				</div>
   				<div>
   					<input type="text" name="txtNm">
   				</div>
   			</div>
   			<div>
   				<div>
   					<label><f:message key="site.form1.campo.email"/></label>
   				</div>
   				<div>
   					<input type="email" name="txtEmail">
   				</div>
   			</div>
   			<div>
   				<div>
   					<label><f:message key="site.form1.campo.rua"/></label>
   				</div>
   				<div>
   					<input type="text" name="txtRua">
   				</div>
   			</div>
   			<div>
   				<div>
   					<label><f:message key="site.form1.campo.cidade"/></label>
   				</div>
   				<div>
   					<input type="text" name="txtCidade">
   				</div>
   			</div>
			<div>
				<button type="submit"><f:message key="site.form1.botao.enviar"/></button>
			</div>
			<div>
				<button type="reset"><f:message key="site.form1.botao.cancelar"/></button>
			</div>
   		</fieldset>
   	</form>
   </div>
   
</body>
</html>














