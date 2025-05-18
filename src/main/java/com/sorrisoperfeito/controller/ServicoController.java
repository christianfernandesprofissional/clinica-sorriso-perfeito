package com.sorrisoperfeito.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sorrisoperfeito.model.Servico;
import com.sorrisoperfeito.repository.ServicoRepository;

@RestController
@RequestMapping("/servicos")
public class ServicoController {

	private ServicoRepository servicoRepository;
	
	@GetMapping
	public ResponseEntity<List<Servico>> findAll(){
		List<Servico> servicos = servicoRepository.findAll();
		
		return ResponseEntity.ok(servicos);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Servico> findById(@PathVariable Integer id){
		Optional<Servico> servico = servicoRepository.findById(id);
		
		if(!servico.isPresent()) {
			return ResponseEntity.notFound().build();
		}else {
			return ResponseEntity.ok(servico.get());
		}
	}
	
	@PostMapping("/")
	public ResponseEntity<Servico> createServico(@RequestBody Servico servico){
		Servico servicoCriado = servicoRepository.save(servico);
		URI uri = URI.create("/servicos/" + servicoCriado.getIdServico());
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Servico> updateServico(@PathVariable Integer id, @RequestBody Servico servico){
		if(!servicoRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		
		servicoRepository.save(servico);
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Servico> deleteById(@PathVariable Integer id){
		if(!servicoRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		
		servicoRepository.deleteById(id);
		return ResponseEntity.ok().build();
			
	}
	
}
