<%@page import="br.com.fiap.bean.ClienteBEAN"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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

	<% 
		//Recepcionar o atributo que está no request. Que é a lista.
		//Utilizando o método getAttribute(nomeDoAtributo)
		List<ClienteBEAN> listagem = (List<ClienteBEAN>)request.getAttribute("listaCliente");
		int count = 1;	
	
		for(ClienteBEAN cli : listagem){
			out.println("<tr>");
			out.println("<td>"+ count +"</td>");
			out.println("<td>"+ cli.getNome() + " " + cli.getSobrenome() +"</td>");
			out.println("<td>"+ cli.getDataNasc() +"</td>");
			//Determinando o Gênero - INÍCIO
			if(cli.getGenero().equals("m")){
				out.println("<td>Masculino</td>");	
			}else if(cli.getGenero().equals("f")){
				out.println("<td>Feminino</td>");	
			}else if(cli.getGenero().equals("o")){
				out.println("<td>Outros</td>");	
			}
			//Determinando o Gênero - FIM
			out.println("<td>"+ cli.getTelefone() +"</td>");
			out.println("<td><a href=listagem?id-cli="+ count +">Editar</a></td>");
			out.println("</tr>");
			count++;
		}
	
	%>			
			
		</table>
		
		
	</section>
	<footer></footer>

	<script type="text/javascript" src="./js/jquery-3.5.1.min.js"></script>
	<script type="text/javascript" src="./js/bootstrap.js"></script>
</body>
</html>