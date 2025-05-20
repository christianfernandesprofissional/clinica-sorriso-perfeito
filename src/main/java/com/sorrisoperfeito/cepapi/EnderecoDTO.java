package com.sorrisoperfeito.cepapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class EnderecoDTO {

	private String logradouro;
	private String complemento;
	private String bairro;
	private String estado;
	private String uf;
	@JsonProperty("localidade")
	private String cidade;
	private String regiao;
	private String cep;

}
