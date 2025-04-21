package br.com.sorrisoperfeito.entities;

public class LimpezaRestauracao extends Servico{

	private String materialUsado;
	private String denteTratado;

	
	public LimpezaRestauracao(String descricao, Double preco) {
		super(descricao, preco);
	}


	public LimpezaRestauracao(String descricao, Double preco, String materialUsado, String denteTratado) {
		super(descricao, preco);
		this.materialUsado = materialUsado;
		this.denteTratado = denteTratado;
	}


	public String getMaterialUsado() {
		return materialUsado;
	}


	public String getDenteTratado() {
		return denteTratado;
	}


	public void setMaterialUsado(String materialUsado) {
		this.materialUsado = materialUsado;
	}


	public void setDenteTratado(String denteTratado) {
		this.denteTratado = denteTratado;
	}

	
}
