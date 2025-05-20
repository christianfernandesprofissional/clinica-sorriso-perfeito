package com.sorrisoperfeito.model;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sorrisoperfeito.cepapi.PacienteDTO;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "pacientes")
public class Paciente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idPaciente; 
	
	private String nome;
	private String documento; 
	private String telefone; 
	private LocalDate nascimento; 
	private String profissao; 
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idEndereco")
	private Endereco endereco;
	
	@Setter(value = AccessLevel.NONE)
	@JsonIgnore
	@OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL)
	private List<Consulta> consultas;
	
	public Paciente(PacienteDTO pacienteDto, Endereco endereco) {
		this.nome = pacienteDto.getNome();
		this.documento = pacienteDto.getDocumento();
		this.telefone = pacienteDto.getTelefone();
		this.nascimento = pacienteDto.getNascimento(); 
		this.profissao = pacienteDto.getProfissao();
		this.endereco = endereco;
	}
	
}
