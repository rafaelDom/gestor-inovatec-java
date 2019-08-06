<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>login</title>
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.7.1/css/all.css">
<link rel="stylesheet" href="resources/css/login.css">

<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.7.2/css/all.css">
<link
	href="https://fonts.googleapis.com/css?family=Chau+Philomene+One|Luckiest+Guy|Hind"
	rel="stylesheet">
</head>
<body>
	<header>
		<div id="logo">
			<a href="#"> <img src="resources/img/logo.png"
				alt="logo inovatec">
			</a> GESTOR INOVATEC - LOGIN
		</div>
	</header>
			<!-- receber a mensagem aqui -->
			<div id="erro-usuario">${msg}</div>
	<form action="efetuaLogin" method="post">
		<h1>Log in</h1>
		<div>
			<i class="far fa-user"></i> <input type="text" id="usuario" name="usuario"
				placeholder="usuário">
		</div>
		<div>
			<i class="fas fa-lock"></i> <input type="password" id="senha"
				name="senha" placeholder="senha">
		</div>
		<button>Log in</button>
	</form>
</body>
</html>