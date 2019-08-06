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
<title>Alterar Venda</title>
<link rel="stylesheet" type="text/css" media="screen"
	href="resources/css/incluir-venda.css">
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
			</a> GESTOR INOVATEC - VENDA - ALTERAR
		</div>
	</header>
	<section>

		<form action="alterar-venda-bd" method="post">
			<br> <input type="hidden" id="venda_id" name="venda_id" required="required"
				value="${venda[0].venda_id}"> <input type="hidden" id="id"
				name="id" required="required" value="${venda[0].cliente.id}">
			<label for="razaoSocial">Razão Social:</label> <input type="text"
				id="razaoSocial" name="razaoSocial" required="required"
				value="${venda[0].cliente.razaoSocial}" readonly="readonly">
			<label for="nome-fantasia">Nome Fantasia:</label> <input type="text"
				id="nomeFantasia" name="nomeFantasia" required="required"
				value="${venda[0].cliente.nomeFantasia}" readonly="readonly">
			<label for="cnpj-cpf">CNPJ/CPF:</label> <input type="number"
				id="cnpj_cpf" name="cnpj_cpf" required="required"
				value="${venda[0].cliente.cnpj_cpf}" readonly="readonly"> <label
				for="endereco">Endereço:</label> <input type="text" id="endereco"
				name="endereco" required="required"
				value="${venda[0].cliente.endereco}" readonly="readonly"> <label
				for="cidade">Cidade:</label> <input type="text" id="cidade"
				name="cidade" required="required" value="${venda[0].cliente.cidade}"
				readonly="readonly"> <label for="estado">Estado:</label> <input
				type="text" id="estado" name="estado" required="required"
				value="${venda[0].cliente.estado}" readonly="readonly"> <label
				for="cep">CEP:</label> <input type="text" id="cep" name="cep"
				required="required" value="${venda[0].cliente.cep}"
				readonly="readonly"> <label for="telefone">Telefone:</label>
			<input type="text" id="telefone" name="telefone" required="required"
				value="${venda[0].cliente.telefone}" readonly="readonly"> <label
				for="email">E-mail:</label> <input type="email" name="email"
				id="email" required="required" value="${venda[0].cliente.email}"
				readonly="readonly"> <label for="contrato">Contrato:</label>
			<input type="text" name="contrato" id="contrato" required="required"
				value="${venda[0].cliente.contrato}" readonly="readonly"> <label
				for="contrato">Data Venda:</label> <input type="text"
				name="data_venda" id="data_venda" required="required"
				value="${venda[0].data_venda}"
				pattern="[0-9]{2}\/[0-9]{2}\/[0-9]{4}$" placeholder="XX/XX/XXXX">
			<label for="produtos">Produto(s):</label>
			<textarea name="produto" id="produto" cols="30" rows="10"
				required="required">${venda[0].produto}</textarea>

			<label for="valor">Valor:</label> <input type="text" name="valor"
				id="valor" required="required" value="${venda[0].valor}"
				pattern="([0-9]{1,3}\.)?[0-9]{1,3},[0-9]{2}$"> <label
				for="garantia">Garantia:</label> <input type="text" name="garantia"
				id="garantia" required="required" value="${venda[0].garantia}">

			<label for="produtos">Observações:</label>
			<textarea name="observacoes" id="observacoes" cols="30" rows="10">${venda[0].observacoes}</textarea>

			<div id="botoes">
				<button type="button" onclick="btnCancelar()">Cancelar</button>
				<button type="submit">Concluir</button>
			</div>
		</form>
	</section>

	<script src="resources/js/incluir-venda.js"></script>
</body>

</html>