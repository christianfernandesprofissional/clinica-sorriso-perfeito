package com.sorrisoperfeito.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sorrisoperfeito.exceptions.CadastroException;
import com.sorrisoperfeito.model.Consulta;
import com.sorrisoperfeito.model.Paciente;
import com.sorrisoperfeito.repository.ConsultaRepository;

@Service
public class ConsultaService {

	@Autowired
	private ConsultaRepository consultaRepository; 
	
	public List<Consulta> findAll(){
		List<Consulta> consultas = consultaRepository.findAll();
		
		
		return consultas;
	}
	
	public Optional<Consulta> findById(Integer id) {
		return consultaRepository.findById(id);
	}
	
	public List<Consulta> findByPaciente(Paciente paciente){
		return consultaRepository.findByPaciente(paciente);
	}
	
	public Boolean existsById(Integer id) {
		return consultaRepository.existsById(id);
	}
	
	public Consulta createConsulta(Consulta consulta) throws CadastroException{
		if(consulta.getIdConsulta() != null) {
			throw new CadastroException("O Id da consulta precisa ser nulo!");
		}	
		return consultaRepository.save(consulta);
	}
	
	
	public Boolean updateConsulta(Integer id, Consulta consulta) {
		if(!consultaRepository.existsById(id)) {
			return false;
		}
		consulta.setIdConsulta(id);
		consultaRepository.save(consulta);
		return true;
	}
	
	public Boolean deleteConsulta(Integer id) {
		if(!consultaRepository.existsById(id)) {
			return false;
		}
		
		consultaRepository.deleteById(id);
		return true;
	}
	
}
