package com.sorrisoperfeito.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sorrisoperfeito.exceptions.CadastroException;
import com.sorrisoperfeito.model.Servico;
import com.sorrisoperfeito.service.ServicoService;

@RestController
@RequestMapping("/servicos")
public class ServicoController {

	@Autowired
	private ServicoService servicoService;
	
	@GetMapping
	public ResponseEntity<List<Servico>> findAll(){
		List<Servico> servicos = servicoService.findAll();
		
		return ResponseEntity.ok(servicos);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Servico> findById(@PathVariable Integer id){
		Optional<Servico> servico = servicoService.findById(id);
		
		if(!servico.isPresent()) {
			return ResponseEntity.notFound().build();
		}else {
			return ResponseEntity.ok(servico.get());
		}
	}
	

	@PostMapping("/")
	public ResponseEntity<Servico> createServico(@RequestBody Servico servico) {
		try {
		 Servico servicoSalvo = servicoService.createServico(servico);
		 URI location = URI.create("/servicos/" + servicoSalvo.getIdServico());
		 return ResponseEntity.created(location).body(servicoSalvo);
		}catch(CadastroException e) {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Servico> updateServico(@PathVariable Integer id, @RequestBody Servico servico){
		if(!servicoService.updateServico(id, servico)) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().build();		
		
	}
	
	@DeleteMapping("/del/{id}")
	public ResponseEntity<Servico> deleteServico(@PathVariable Integer id){
		
		if(!servicoService.deleteServico(id)) {
			return ResponseEntity.notFound().build();
		}else {
			return ResponseEntity.ok().build();
		}
		
	}
	
}
