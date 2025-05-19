package com.sorrisoperfeito.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "consultas")
public class Consulta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idConsulta;  
	private LocalDate dataHora; 

	@ManyToOne
	@JoinColumn(name = "idPaciente")
	private Paciente paciente;
	
	@ManyToOne
	@JoinColumn(name = "idDentista")
	private Dentista dentista;
	
	@ManyToMany
	@JoinTable(name = "consultas_servicos",
			   joinColumns = @JoinColumn(name = "idConsulta"),
			   inverseJoinColumns = @JoinColumn(name = "idServico"))
	private Set<Servico> servicos = new HashSet<>();
}
