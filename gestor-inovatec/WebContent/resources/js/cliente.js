var id = "";
var razaoSocial = "";
$(document).ready(function() {
	$('.linha-table').click(function() {
		$('.linha-table').removeClass('checked');
		$(this).addClass('checked');
		id = $(this.children[0]).text();
		razaoSocial = $(this.children[2]).text();
	});
});

function excluirCliente() {
	if (id == "") {
		alert('Favor selecionar um cliente para excluir.');
	} else {
		var boxConfirmar = confirm("Deseja excluir o cliente " + id + "-"
				+ razaoSocial + "?");
		if (boxConfirmar == true) {
			window.location.href = 'excluir-cliente-bd?id=' + id;
		} else {

		}
	}
}

function alterarCliente() {
	if (id == "") {
		alert('Favor selecionar um cliente para alterar.');
	} else {
		var boxConfirmar = confirm("Deseja alterar o cliente " + id + "-"
				+ razaoSocial + "?");
		if (boxConfirmar == true) {
			window.location.href = 'listar-cliente-alterar?id=' + id;
		} else {

		}
	}
}

function listarCnpjCpf() {
	let cnpj_cpf = document.getElementById("pesquisar_cnpj_cpf").value;

	window.location.href = 'pesquisar-cliente-cnpj-cpf?cnpj_cpf=' + cnpj_cpf;

}
