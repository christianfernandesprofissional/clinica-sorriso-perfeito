package br.com.sorrisoperfeito.entities;

public class Exame extends Servico{

	private String medidaPreventiva;
	private  String tipoDeExame;
	
	public Exame(String descricao, Double preco) {
		super(descricao, preco);
	}

	public Exame(String descricao, Double preco, String medidaPreventiva, String tipoDeExame) {
		super(descricao, preco);
		this.medidaPreventiva = medidaPreventiva;
		this.tipoDeExame = tipoDeExame;
	}

	public String getMedidaPreventiva() {
		return medidaPreventiva;
	}

	public String getTipoDeExame() {
		return tipoDeExame;
	}

	public void setMedidaPreventiva(String medidaPreventiva) {
		this.medidaPreventiva = medidaPreventiva;
	}

	public void setTipoDeExame(String tipoDeExame) {
		this.tipoDeExame = tipoDeExame;
	}
	
	
	

	
	
}
