<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Ordem de Serviço</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" media="screen"
	href="resources/css/os.css">
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
			</a> GESTOR INOVATEC - O.S
		</div>
	</header>
	<section>
		<div id="pesquisar">
			<label for="pesquisar">CNPJ/CPF:</label> <input type="text"
				id="pesquisar_cnpj_cpf" name="pesquisar">
			<button onclick="listarOs()">
				<i class="fas fa-search fa-2x"></i>
			</button>
		</div>

		<div id="funcoes-os">
			<div class="funcao">
				<a href="incluir-os"> <i class="fas fa-user-plus fa-2x"></i>
					Incluir O.S
				</a>
			</div>
			<div class="funcao">
				<button onclick="excluirOs()">
					<i class="fas fa-user-times fa-2x"></i> Excluir O.S
				</button>
			</div>
			<div class="funcao">
				<button onclick="alterarOs()">
					<i class="fas fa-user-edit fa-2x"></i> Alterar O.S
				</button>
			</div>
			<div class="funcao">
				<button onclick="imprimirOs()">
					<i class="fas fa-print fa-2x"></i> Imprimir O.S
				</button>
			</div>
		</div>
	</section>
	<div>
		<table id="tabela-clientes">
			<tr>
				<th>N° O.S</th>
				<th>CNPJ/CPF</th>
				<th>Razão Social</th>
				<th>Nome Fantasia</th>
				<th>Data Abertura</th>
			</tr>
			<c:forEach var="os" items="${os}">
				<tr class="linha-table">
					<td id="id-table">${os.os_id}</td>
					<td>${os.cliente.cnpj_cpf}</td>
					<td>${os.cliente.razaoSocial}</td>
					<td>${os.cliente.nomeFantasia}</td>
					<td>${os.data_abertura_os}</td>
				</tr>
			</c:forEach>
		</table>
	</div>


	<script src="resources/js/os.js"></script>
</body>

</html>