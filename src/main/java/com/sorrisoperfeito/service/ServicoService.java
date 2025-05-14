package com.sorrisoperfeito.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sorrisoperfeito.model.Servico;
import com.sorrisoperfeito.repository.ServicoRepository;

@Service
public class ServicoService {

	@Autowired
	private ServicoRepository repository; 
	
	public List<Servico> findAll(){
		return repository.findAll();
	}
	
	public Servico findById(Integer id) {
		return repository.findById(id).get();
	}
}
