<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="br.com.inovatec.gestor.modelo.ClienteModel"%>
<%@ page import="br.com.inovatec.gestor.dao.ClienteDAO"%>
<%@ page import="java.util.List"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Venda</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" media="screen"
	href="resources/css/venda.css">
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
			</a> GESTOR INOVATEC - VENDA
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
				<a href="incluir-venda"> <i class="fas fa-user-plus fa-2x"></i>
					Incluir Venda
				</a>
			</div>
			<div class="funcao">
				<button onclick="excluirVenda()">
					<i class="fas fa-user-times fa-2x"></i> Excluir Venda
				</button>
			</div>
			<div class="funcao">
				<button onclick="alterarVenda()">
					<i class="fas fa-user-edit fa-2x"></i> Alterar Venda
				</button>
			</div>
		</div>
	</section>

	<div>
		<table id="tabela-vendas">
			<tr>
				<th>Razão Social</th>
				<th>Nome Fantasia</th>
				<th>CNPJ/CPF</th>
				<th>Data Venda</th>
				<th>Produto(s)</th>
			</tr>
			<c:forEach var="venda" items="${venda}">
				<tr class="linha-table">
					<td id="id-table">${venda.venda_id}</td>
					<td>${venda.cliente.razaoSocial}</td>
					<td>${venda.cliente.nomeFantasia}</td>
					<td>${venda.cliente.cnpj_cpf}</td>
					<td>${venda.data_venda}</td>
					<td>${venda.produto}</td>
				</tr>
			</c:forEach>
		</table>
	</div>



	<script src="resources/js/venda.js"></script>
</body>

</html>