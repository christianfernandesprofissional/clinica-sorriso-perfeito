package br.com.sorrisoperfeito.entities;

import java.time.LocalDate;

public class Paciente {

	private String nome; 
	private String rg; 
	private String telefone; 
	private LocalDate dataNascimento;	
	private String profissao;
	
	private Agenda agenda;
	
	public Paciente() {}
	
	public Paciente(String nome, String rg, String telefone, LocalDate dataNascimento, String profissao) {
		this.nome = nome;
		this.rg = rg;
		this.telefone = telefone;
		this.dataNascimento = dataNascimento;
		this.profissao = profissao;
	}
	

	public String getNome() {
		return nome;
	}

	public String getRg() {
		return rg;
	}

	public String getTelefone() {
		return telefone;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public String getProfissao() {
		return profissao;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}

	public Agenda getAgenda() {
		return agenda;
	}

	public void setAgenda(Agenda agenda) {
		this.agenda = agenda;
	}
	
	
	
	
}
