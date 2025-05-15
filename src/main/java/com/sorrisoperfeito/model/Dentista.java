package com.sorrisoperfeito.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
@Table(name = "dentistas")
public class Dentista {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idDentista; 
	private String nome; 
	private String especialidade;
	
	@Setter(value = AccessLevel.NONE)
	@OneToMany(mappedBy = "dentista", cascade = CascadeType.ALL)
	private List<Consulta> consultas;
	
	
	
}
