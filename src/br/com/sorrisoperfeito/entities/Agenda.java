package br.com.sorrisoperfeito.entities;

import java.util.List;

public class Agenda {

	private Integer ano;
	
	private List<Horario> horario;

	
	public Agenda(Integer ano, List<Horario> horario) {
		this.ano = ano;
		this.horario = horario;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public List<Horario> getHorario() {
		return horario;
	}

	public void setHorario(List<Horario> horario) {
		this.horario = horario;
	}
	
	
	
	
	
}
