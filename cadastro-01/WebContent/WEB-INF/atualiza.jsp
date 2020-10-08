<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1">
<link rel="stylesheet" href="./css/bootstrap.css" type="text/css">
<title>ATUALIZA CADASTRO</title>
</head>
<body>

<%@ include file="./snippet/menus/menu-header.html"%>
	
	<section>
		<form action="update" method="post">
			<input type="hidden" name="txtIdCli" value="${objIdCli}">
			<fieldset>
				<legend>Atualização de Dados Cadastrais</legend>
				
				<div class="form-group">
					<label class="control-label col-sm-2" for="idNm">Nome</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" name="txtNm" id="idNm" placeholder="Digite seu nome"
						 required="required" value="${objCli.nome}">
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-sm-2" for="idSnm">Sobrenome</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" name="txtSnm" id="idSnm" placeholder="Digite seu sobrenome" 
						required="required" value="${objCli.sobrenome}">
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-sm-2" for="idDtNasc">Data Nascimento</label>
					<div class="col-sm-10">
						<input type="date" class="form-control" name="txtDtNasc" id="idDtNasc" 
						required="required" value='<f:formatDate value="${objCli.dataNasc}" pattern="yyyy-MM-dd"/>'> 
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-sm-2" for="idGen">Gênero</label>
					<div class="col-sm-10">
						<select class="form-control" name="txtGen" id="idGen" required="required">
							
							<c:choose>
								<c:when test="${cli.genero eq 'm'}">
									<option value="0">Selecione uma Opção</option>
									<option value="m" selected="selected">Masculino</option>
									<option value="f">Feminino</option>
									<option value="o">Outros</option>
								</c:when>
								<c:when test="${cli.genero eq 'f'}">
									<option value="0">Selecione uma Opção</option>
									<option value="m">Masculino</option>
									<option value="f" selected="selected">Feminino</option>
									<option value="o">Outros</option>
								</c:when>
								<c:otherwise>
									<option value="0">Selecione uma Opção</option>
									<option value="m">Masculino</option>
									<option value="f">Feminino</option>
									<option value="o"  selected="selected">Outros</option>
								</c:otherwise>
							</c:choose>
							
						</select>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-sm-2" for="idTel">Telefone</label>
					<div class="col-sm-10">
						<input type="tel" class="form-control" name="txtTel" id="idTel" placeholder="Digite seu telefone" 
						required="required" value="${objCli.telefone}">
					</div>
				</div>
				<fieldset>
				
				</fieldset>
				<div class="form-group">
					<div class="col-sm-offset-10 col-sm-10">
						<button type="submit" class="btn btn-info btn-lg">Atualizar</button>	
					</div>
				</div>
				
			</fieldset>
		</form>
	</section>
	<footer>
	
	</footer>

<script type="text/javascript" src="./js/jquery-3.5.1.min.js"></script>
<script type="text/javascript" src="./js/bootstrap.js"></script>
</body>
</html>