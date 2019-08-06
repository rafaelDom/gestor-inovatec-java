window.onload = function() {
	let situacao = document.getElementById('situacao').value;

	if (situacao == 'ABERTA') {
		document.getElementById('select_situacao').options[0].selected = true;
	} else {
		document.getElementById('select_situacao').options[1].selected = true;
	}

}

function btnCancelar() {
	window.location.href = 'os';
}
