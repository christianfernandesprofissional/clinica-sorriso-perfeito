package com.sorrisoperfeito.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sorrisoperfeito.exceptions.CadastroException;
import com.sorrisoperfeito.model.Servico;
import com.sorrisoperfeito.repository.ServicoRepository;

@Service
public class ServicoService {

	@Autowired
	private ServicoRepository servicoRepository; 
	
	public List<Servico> findAll(){
		return servicoRepository.findAll();
	}
	
	public Optional<Servico> findById(Integer id) {
		return servicoRepository.findById(id);
	}
	

	public Boolean existsById(Integer id) {
		return servicoRepository.existsById(id);
	}
	
	public Servico createServico(Servico servico) throws CadastroException{
		if(servico.getIdServico() != null) {
			throw new CadastroException("O Id do serviço precisa ser nulo!");
		}	
		return servicoRepository.save(servico);
	}
	
	
	public Boolean updateServico(Integer id, Servico servico) {
		if(!servicoRepository.existsById(id)) {
			return false;
		}
		servico.setIdServico(id);
		servicoRepository.save(servico);	
		return true;
	}
	
	public Boolean deleteServico(Integer id) {
		if(!servicoRepository.existsById(id)) {
			return false;
		}
		
		servicoRepository.deleteById(id);
		return true;
	}
}
