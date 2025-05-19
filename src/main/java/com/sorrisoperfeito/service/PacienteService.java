package com.sorrisoperfeito.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sorrisoperfeito.exceptions.CadastroException;
import com.sorrisoperfeito.model.Paciente;
import com.sorrisoperfeito.repository.PacienteRepository;

@Service
public class PacienteService {

	@Autowired
	private PacienteRepository pacienteRepository; 
	
	//@Autowired
	//private ConsultaRepository consultaRepository;
	
	public List<Paciente> findAll(){
		return pacienteRepository.findAll();
	}
	
	public Optional<Paciente> findById(Integer id) {
		return pacienteRepository.findById(id);
	}
	
	
	public Boolean existsById(Integer id) {
		return pacienteRepository.existsById(id);
	}
	
	public Paciente createPaciente(Paciente paciente) throws CadastroException{
		if(paciente.getIdPaciente() != null) {
			throw new CadastroException("O Id do paciente precisa ser nulo!");
		}	
		return pacienteRepository.save(paciente);
	}
	
	
	public Boolean updatePaciente(Integer id, Paciente paciente) {
		if(!pacienteRepository.existsById(id)) {
			return false;
		}
		paciente.setIdPaciente(id);
		pacienteRepository.save(paciente);	
		return true;
	}
	
	public Boolean deletePaciente(Integer id) {
		if(!pacienteRepository.existsById(id)) {
			return false;
		}
		
		pacienteRepository.deleteById(id);
		return true;
	}
}
