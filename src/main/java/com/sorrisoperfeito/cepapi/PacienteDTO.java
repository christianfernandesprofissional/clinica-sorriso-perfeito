package com.sorrisoperfeito.cepapi;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PacienteDTO {
	private String nome;
	private String documento; 
	private String telefone; 
	private LocalDate nascimento; 
	private String profissao; 
	private String cep;
}
