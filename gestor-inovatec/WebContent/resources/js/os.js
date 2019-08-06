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

function excluirOs() {
	if (id == "") {
		alert('Favor selecionar uma o.s para excluir.');
	} else {
		var boxConfirmar = confirm("Deseja excluir a o.s " + id + "-"
				+ razaoSocial + "?");
		if (boxConfirmar == true) {
			window.location.href = 'excluir-os-bd?id=' + id;
		} else {

		}
	}
}

function alterarOs() {
	if (id == "") {
		alert('Favor selecionar uma o.s para alterar.');
	} else {
		var boxConfirmar = confirm("Deseja alterar a o.s " + id + "-"
				+ razaoSocial + "?");
		if (boxConfirmar == true) {
			window.location.href = 'listar-os-alterar?id=' + id;
		} else {

		}
	}
}

function listarOs() {
	let cnpj_cpf = document.getElementById("pesquisar_cnpj_cpf").value;

	window.location.href = 'pesquisar-os-cnpj-cpf?cnpj_cpf=' + cnpj_cpf;

}
function imprimirOs() {
	if (id == "") {
		alert('Favor selecionar uma o.s para imprimir.');
	} else {
		var boxConfirmar = confirm("Deseja imprimir a o.s " + id + "-"
				+ razaoSocial + "?");
		if (boxConfirmar == true) {
			window.location.href = 'imprimir-os?id=' + id;
		} else {

		}
	}
}
