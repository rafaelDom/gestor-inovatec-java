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
<title>Alterar O.S</title>
<link rel="stylesheet" type="text/css" media="screen"
	href="resources/css/incluir-os.css">
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
			</a> GESTOR INOVATEC - O.S - ALTERAR
		</div>
	</header>
	<section>

		<form action="alterar-os-bd" method="post">
			<br> <br> <input type="hidden" id="id" name="id"
				required="required" value="${os[0].cliente.id}"> <input
				type="hidden" id="os_id" name="os_id" required="required"
				value="${os[0].os_id}"> <input type="hidden"
				id="data_abertura_os" name="data_abertura_os" required="required"
				value="${os[0].data_abertura_os}"> <label for="razaoSocial">Razão
				Social:</label> <input type="text" id="razaoSocial" name="razaoSocial"
				required="required" value="${os[0].cliente.razaoSocial}"
				readonly="readonly"> <label for="nome-fantasia">Nome
				Fantasia:</label> <input type="text" id="nomeFantasia" name="nomeFantasia"
				required="required" value="${os[0].cliente.nomeFantasia}"
				readonly="readonly"> <label for="cnpj-cpf">CNPJ/CPF:</label>
			<input type="number" id="cnpj_cpf" name="cnpj_cpf"
				required="required" value="${os[0].cliente.cnpj_cpf}"
				readonly="readonly"> <label for="endereco">Endereço:</label>
			<input type="text" id="endereco" name="endereco" required="required"
				value="${os[0].cliente.endereco}" readonly="readonly"> <label
				for="cidade">Cidade:</label> <input type="text" id="cidade"
				name="cidade" required="required" value="${os[0].cliente.cidade}"
				readonly="readonly"> <label for="estado">Estado:</label> <input
				type="text" id="estado" name="estado" required="required"
				value="${os[0].cliente.estado}" readonly="readonly"> <label
				for="cep">CEP:</label> <input type="text" id="cep" name="cep"
				required="required" value="${os[0].cliente.cep}" readonly="readonly">
			<label for="telefone">Telefone:</label> <input type="text"
				id="telefone" name="telefone" required="required"
				value="${os[0].cliente.telefone}" readonly="readonly"> <label
				for="email">E-mail:</label> <input type="email" name="email"
				id="email" required="required" value="${os[0].cliente.email}"
				readonly="readonly"> <label for="contrato">Contrato:</label>
			<input type="text" name="contrato" id="contrato" required="required"
				value="${os[0].cliente.contrato}" readonly="readonly"> <label
				for="valor">Valor:</label> <input type="text" name="valor"
				id="valor" required="required" value="${os[0].valor}"> <label
				for="valor">Valor Hora:</label> <input type="text" name="valor_hora"
				id="valor_hora" required="required" value="${os[0].valor_hora}">
			<label>SITUAÇÃO O.S:</label> 
			<input type="hidden" id="situacao" value="${os[0].situacao}">
			<select name="situacao" id="select_situacao">
				<option value="ABERTA">ABERTA</option>
				<option value="FINALIZADA">FINALIZADA</option>
			</select> <label for="motivo">Motivo/Observações:</label>
			<textarea rows="10" cols="5" required="required" id="motivo"
				name="motivo">${os[0].motivo}</textarea>


			<label for="servico_executado">Serviço executado:</label>
			<textarea rows="10" cols="5" id="servico_executado"
				name="servico_executado">${os[0].servico_executado}</textarea>

			<div id="botoes">
				<button type="button" onclick="btnCancelar()">Cancelar</button>
				<button type="submit">Concluir</button>
			</div>
		</form>
	</section>

	<script src="resources/js/alterar-os.js"></script>
</body>

</html>