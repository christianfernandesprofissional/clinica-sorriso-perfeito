package br.com.sorrisoperfeito.entities;

public class Servico {

	private String descricao;
	private Double preco;
	
	public Servico(String descricao, Double preco) {
		this.descricao = descricao;
		this.preco = preco;
	}

	public String getDescricao() {
		return descricao;
	}

	public Double getPreco() {
		return preco;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
	
	
}
