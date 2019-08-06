<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="br.com.inovatec.gestor.modelo.ClienteModel"%>
<%@ page import="br.com.inovatec.gestor.dao.ClienteDAO"%>
<%@ page import="java.util.List"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Cliente</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" media="screen"
	href="resources/css/cliente.css">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.7.2/css/all.css">
<link
	href="https://fonts.googleapis.com/css?family=Chau+Philomene+One|Luckiest+Guy|Hind"
	rel="stylesheet">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
</head>

<body>
	<header>
		<div id="logo">
			<a href="index"> <img src="resources/img/logo.png"
				alt="logo inovatec">
			</a> GESTOR INOVATEC - CLIENTE
		</div>
	</header>
	<section>
		<div id="pesquisar">
			<label for="pesquisar">CNPJ/CPF:</label> <input type="text"
				id="pesquisar_cnpj_cpf" name="pesquisar">
			<button onclick="listarCnpjCpf()">
				<i class="fas fa-search fa-2x"></i>
			</button>
		</div>

		<div id="funcoes-cliente">
			<div class="funcao">
				<a href="incluir-cliente"> <i class="fas fa-user-plus fa-2x"></i>
					Incluir Cliente
				</a>
			</div>
			<div class="funcao">
				<button onclick="excluirCliente()">
					<i class="fas fa-user-times fa-2x"></i> Excluir Cliente
				</button>
			</div>
			<div class="funcao">
				<button onclick="alterarCliente()">
					<i class="fas fa-user-edit fa-2x"></i> Alterar Cliente
				</button>
			</div>
		</div>
	</section>

	<div>
		<!-- receber a mensagem aqui -->
		<div id="erro-excluir-cliente">${msg}</div>
		<table id="tabela-clientes">
			<tr>
				<th>Contrato</th>
				<th>Razão Social</th>
				<th>Nome Fantasia</th>
				<th>CNPJ/CPF</th>
				<th>Endereço</th>
			</tr>
			<c:forEach var="cliente" items="${cliente}">
				<tr class="linha-table">
					<td id="id-table">${cliente.id}</td>
					<td>${cliente.contrato}</td>
					<td>${cliente.razaoSocial}</td>
					<td>${cliente.nomeFantasia}</td>
					<td>${cliente.cnpj_cpf}</td>
					<td>${cliente.endereco}</td>
				</tr>
			</c:forEach>
		</table>
	</div>



	<script src="resources/js/cliente.js"></script>
</body>

</html>