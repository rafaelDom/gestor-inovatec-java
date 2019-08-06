function btnCancelar() {
	window.location.href = 'os';
}
function listarCnpjCpf() {
	let cnpj_cpf = document.getElementById("pesquisar_cnpj_cpf").value;
	
	if (!cnpj_cpf ==""){
		window.location.href = 'pesquisar-cliente-os-cnpj-cpf?cnpj_cpf=' + cnpj_cpf;
	}else{
		alert('Favor preencher CNPJ ou CPF!')
	}
}