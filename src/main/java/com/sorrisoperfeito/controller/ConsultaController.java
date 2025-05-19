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

import com.sorrisoperfeito.model.Consulta;
import com.sorrisoperfeito.model.Servico;
import com.sorrisoperfeito.repository.ConsultaRepository;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {

	@Autowired
	private ConsultaRepository consultaRepository;
	
	@GetMapping
	public ResponseEntity<List<Consulta>> findAll(){
		List<Consulta> consultas = consultaRepository.findAll();
		
		return ResponseEntity.ok(consultas);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Consulta> findById(@PathVariable Integer id){
		Optional<Consulta> consulta = consultaRepository.findById(id);
		
		if(!consulta.isPresent()) {
			return ResponseEntity.notFound().build();
		}else {
			return ResponseEntity.ok(consulta.get());
		}
	}
	
	@PostMapping("/")
	public ResponseEntity<Consulta> createServico(@RequestBody Consulta consulta){
		Consulta consultaCriada = consultaRepository.save(consulta);
		URI uri = URI.create("/consultas/" + consultaCriada.getIdConsulta());
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Servico> updateServico(@PathVariable Integer id, @RequestBody Consulta consulta){
		if(!consultaRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		
		consultaRepository.save(consulta);
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Servico> deleteById(@PathVariable Integer id){
		if(!consultaRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		
		consultaRepository.deleteById(id);
		return ResponseEntity.ok().build();
			
	}
}
