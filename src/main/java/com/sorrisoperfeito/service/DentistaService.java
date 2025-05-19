package com.sorrisoperfeito.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sorrisoperfeito.exceptions.CadastroException;
import com.sorrisoperfeito.model.Dentista;
import com.sorrisoperfeito.repository.DentistaRepository;

@Service
public class DentistaService {

	@Autowired
	private DentistaRepository dentistaRepository; 
	
	public List<Dentista> findAll(){
		return dentistaRepository.findAll();
	}
	
	public Optional<Dentista> findById(Integer id) {
		return dentistaRepository.findById(id);
	}
	
	public Boolean existsById(Integer id) {
		return dentistaRepository.existsById(id);
	}
	
	public Dentista createDentista(Dentista dentista) throws CadastroException{
		if(dentista.getIdDentista() != null) {
			throw new CadastroException("O Id do dentista precisa ser nulo!");
		}	
		return dentistaRepository.save(dentista);
	}
	
	
	public Boolean updateDentista(Integer id, Dentista dentista) {
		if(!dentistaRepository.existsById(id)) {
			return false;
		}
		dentista.setIdDentista(id);
		dentistaRepository.save(dentista);
		return true;
	}
	
	public Boolean deleteDentista(Integer id) {
		if(!dentistaRepository.existsById(id)) {
			return false;
		}
		
		dentistaRepository.deleteById(id);
		return true;
	}
}
