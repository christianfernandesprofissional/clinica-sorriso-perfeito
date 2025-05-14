package com.sorrisoperfeito.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sorrisoperfeito.model.Paciente;
import com.sorrisoperfeito.repository.PacienteRepository;

@Service
public class PacienteService {

	@Autowired
	private PacienteRepository repository; 
	
	public List<Paciente> findAll(){
		return repository.findAll();
	}
	
	public Paciente findById(Integer id) {
		return repository.findById(id).get();
	}
}
