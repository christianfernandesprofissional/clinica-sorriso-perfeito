package com.sorrisoperfeito.model;

import com.sorrisoperfeito.cepapi.EnderecoDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "enderecos")
public class Endereco {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String logradouro;
	private String complemento;
	private String bairro;
	private String estado;
	private String uf;
	private String cidade;
	private String regiao;
	private String cep;
	
	
	public Endereco(EnderecoDTO enderecoDto) {
		this.logradouro = enderecoDto.getLogradouro();
		this.complemento = enderecoDto.getComplemento();
		this.bairro = enderecoDto.getBairro();
		this.estado = enderecoDto.getEstado();
		this.uf = enderecoDto.getUf();
		this.cidade = enderecoDto.getCidade();
		this.regiao = enderecoDto.getRegiao(); 
		this.cep = enderecoDto.getCep();
	}

}
