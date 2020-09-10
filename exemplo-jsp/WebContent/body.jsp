	<%-- COMENTÁRIO DE SCRIPTLETS  IGNORADO PELO SERVER --%>
	<!--  É APRESENTADO PARA O CLIENTE-->
	<div>
		<ul>
		<% 
		for(int x = 0; x < 10 ; x++){%>
			
			<li>Valor da variável X = <%=x%></li>
		
		<%}%>	
		</ul>
	</div>