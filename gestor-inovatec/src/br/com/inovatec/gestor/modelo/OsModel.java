package br.com.inovatec.gestor.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class OsModel {
	@Id
	@GeneratedValue
	private Long os_id;

	private String motivo;
	private String data_abertura_os;
	private String valor;
	private String Valor_hora;
	private String situacao;
	private String servico_executado;

	@OneToOne
	private ClienteModel cliente;

	public Long getOs_id() {
		return os_id;
	}

	public void setOs_id(Long os_id) {
		this.os_id = os_id;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public ClienteModel getCliente() {
		return cliente;
	}

	public void setCliente(ClienteModel cliente) {
		this.cliente = cliente;
	}

	public String getData_abertura_os() {
		return data_abertura_os;
	}

	public void setData_abertura_os(String data_abertura_os) {
		this.data_abertura_os = data_abertura_os;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getValor_hora() {
		return Valor_hora;
	}

	public void setValor_hora(String valor_hora) {
		Valor_hora = valor_hora;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public String getServico_executado() {
		return servico_executado;
	}

	public void setServico_executado(String servico_executado) {
		this.servico_executado = servico_executado;
	}

}
