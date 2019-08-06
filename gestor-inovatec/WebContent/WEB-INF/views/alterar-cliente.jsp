<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="br.com.inovatec.gestor.modelo.ClienteModel"%>
<%@ page import="br.com.inovatec.gestor.dao.ClienteDAO"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Alterar Cliente</title>
<link rel="stylesheet" type="text/css" media="screen"
	href="resources/css/incluir-cliente.css">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.7.2/css/all.css">
<link
	href="https://fonts.googleapis.com/css?family=Chau+Philomene+One|Luckiest+Guy|Hind"
	rel="stylesheet">

</head>

<body>

	<header>
		<div id="logo">
			<a href="index"> <img src="resources/img/logo.png"
				alt="logo inovatec">
			</a> GESTOR INOVATEC - CLIENTE - ALTERAR
		</div>
	</header>
	<section>

		<form action="alterar-cliente-bd" method="post">
			<c:forEach var="cliente" items="${cliente}">
				<label for="id">ID:</label>
				<input type="text" id="id" name="id" required="required"
					value="${cliente.id}" readonly="readonly">
				<label for="razaoSocial">Razão Social:</label>
				<input type="text" id="razaoSocial" name="razaoSocial"
					required="required" value="${cliente.razaoSocial}">
				<label for="nome-fantasia">Nome Fantasia:</label>
				<input type="text" id="nomeFantasia" name="nomeFantasia"
					required="required" value="${cliente.nomeFantasia}">
				<label for="cnpj-cpf">CNPJ/CPF:</label>
				<input type="number" id="cnpj_cpf" name="cnpj_cpf"
					required="required" value="${cliente.cnpj_cpf}" readonly="readonly">
				<label for="endereco">Endereço:</label>
				<input type="text" id="endereco" name="endereco" required="required"
					value="${cliente.endereco}">
				<label for="cidade">Cidade:</label>
				<input type="text" id="cidade" name="cidade" required="required"
					value="${cliente.cidade}">
				<label for="estado">Estado:</label>
				<input type="text" id="estado" name="estado" required="required"
					value="${cliente.estado}">
				<label for="cep">CEP:</label>
				<input type="text" id="cep" name="cep" required="required"
					value="${cliente.cep}">
				<label for="telefone">Telefone:</label>
				<input type="text" id="telefone" name="telefone" required="required"
					value="${cliente.telefone}">
				<label for="email">E-mail:</label>
				<input type="text" name="email" id="email" required="required"
					value="${cliente.email}">
				<label for="contrato">Contrato:</label>
				<input type="text" name="contrato" id="contrato" required="required"
					value="${cliente.contrato}">
				<label for="observacoes">Observação:</label>
				<textarea name="observacao" id="observacao" cols="30" rows="10">${cliente.observacao}</textarea>

				<div id="botoes">
					<button type="button" onclick="btnCancelar()">Cancelar</button>
					<button type="submit">Concluir</button>
				</div>
			</c:forEach>
		</form>
	</section>

	<script src="resources/js/alterar-cliente.js"></script>
</body>

</html>