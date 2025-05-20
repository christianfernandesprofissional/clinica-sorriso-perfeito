package com.sorrisoperfeito.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sorrisoperfeito.model.Endereco;
import com.sorrisoperfeito.repository.EnderecoRepository;

@Service
public class EnderecoService {

	@Autowired
	private EnderecoRepository enderecoRepository;
	
	public List<Endereco> findAll(){
		return enderecoRepository.findAll();
	}
	
	public Optional<Endereco> findById(Integer id){
		return enderecoRepository.findById(id);
	}
	
	public Endereco createEndereco(Endereco endereco) {
		return enderecoRepository.save(endereco);
	}
}
