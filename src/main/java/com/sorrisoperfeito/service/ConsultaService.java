package com.sorrisoperfeito.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sorrisoperfeito.model.Consulta;
import com.sorrisoperfeito.repository.ConsultaRepository;

@Service
public class ConsultaService {

	@Autowired
	private ConsultaRepository repository; 
	
	public List<Consulta> findAll(){
		return repository.findAll();
	}
	
	public Consulta findById(Integer id) {
		return repository.findById(id).get();
	}
}
