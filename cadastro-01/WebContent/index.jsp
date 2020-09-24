<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width,initial-scale=1">
<link rel="stylesheet" href="./css/bootstrap.css" type="text/css">
<title>CADASTRO</title>
</head>
<body>

	<header>
		<nav></nav>
	</header>
	<div>
		<h2>${param.msgStatus}</h2>
	</div>
	<section>
		<form action="cliente" method="post">
			<fieldset>
				<legend>Cadastro de Clientes</legend>
				
				<div class="form-group">
					<label class="control-label col-sm-2" for="idNm">Nome</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" name="txtNm" id="idNm" placeholder="Digite seu nome" required="required">
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-sm-2" for="idSnm">Sobrenome</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" name="txtSnm" id="idSnm" placeholder="Digite seu sobrenome" required="required">
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-sm-2" for="idDtNasc">Data Nascimento</label>
					<div class="col-sm-10">
						<input type="date" class="form-control" name="txtDtNasc" id="idDtNasc" required="required">
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-sm-2" for="idGen">Gênero</label>
					<div class="col-sm-10">
						<select class="form-control" name="txtGen" id="idGen" required="required">
							<option value="0" selected="selected">Selecione uma Opção</option>
							<option value="m">Masculino</option>
							<option value="f">Feminino</option>
							<option value="o">Outros</option>
						</select>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-sm-2" for="idTel">Telefone</label>
					<div class="col-sm-10">
						<input type="tel" class="form-control" name="txtTel" id="idTel" placeholder="Digite seu telefone" required="required">
					</div>
				</div>

				<div class="form-group">
					<div class="col-sm-offset-10 col-sm-10">
						<button type="submit" class="btn btn-success btn-lg">Cadastrar</button>	
					</div>
				</div>
				
			</fieldset>
		</form>
	</section>
	<footer></footer>

<script type="text/javascript" src="./js/jquery-3.5.1.min.js"></script>
<script type="text/javascript" src="./js/bootstrap.js"></script>
</body>
</html>