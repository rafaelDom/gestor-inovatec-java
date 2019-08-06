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

function excluirVenda() {
	if (id == "") {
		alert('Favor selecionar uma venda para excluir.');
	} else {
		var boxConfirmar = confirm("Deseja excluir a venda " + id + "-"
				+ razaoSocial + "?");
		if (boxConfirmar == true) {
			window.location.href = 'excluir-venda-bd?id=' + id;
		} else {

		}
	}
}

function alterarVenda() {
	if (id == "") {
		alert('Favor selecionar uma venda para alterar.');
	} else {
		var boxConfirmar = confirm("Deseja alterar a venda do cliente " + id + "-"
				+ razaoSocial + "?");
		if (boxConfirmar == true) {
			window.location.href = 'listar-venda-alterar?id=' + id;
		} else {

		}
	}
}

function listarCnpjCpf() {
	let cnpj_cpf = document.getElementById("pesquisar_cnpj_cpf").value;

	window.location.href = 'pesquisar-venda-cnpj-cpf?cnpj_cpf=' + cnpj_cpf;

}
