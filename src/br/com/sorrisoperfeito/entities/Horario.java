package br.com.sorrisoperfeito.entities;

import java.time.LocalDateTime;

public class Horario {

	private LocalDateTime dataHora;

	public Horario(LocalDateTime dataHora) {
		this.dataHora = dataHora;
	}

	public LocalDateTime getDataHora() {
		return dataHora;
	}

	public void setDataHora(LocalDateTime dataHora) {
		this.dataHora = dataHora;
	}
	
	
}
