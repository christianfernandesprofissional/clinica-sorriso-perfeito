package com.sorrisoperfeito.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sorrisoperfeito.model.Dentista;
import com.sorrisoperfeito.repository.DentistaRepository;

@Service
public class DentistaService {

	@Autowired
	private DentistaRepository repository; 
	
	public List<Dentista> findAll(){
		return repository.findAll();
	}
	
	public Dentista findById(Integer id) {
		return repository.findById(id).get();
	}
}
