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
import com.sorrisoperfeito.model.Consulta;
import com.sorrisoperfeito.service.ConsultaService;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {

	@Autowired
	private ConsultaService consultaService;
	
	@GetMapping
	public ResponseEntity<List<Consulta>> findAll(){
		List<Consulta> consultas = consultaService.findAll();
		
		return ResponseEntity.ok(consultas);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Consulta> findById(@PathVariable Integer id){
		Optional<Consulta> consulta = consultaService.findById(id);
		
		if(!consulta.isPresent()) {
			return ResponseEntity.notFound().build();
		}else {
			return ResponseEntity.ok(consulta.get());
		}
	}
	
	@PostMapping("/")
	public ResponseEntity<Consulta> createConsulta(@RequestBody Consulta consulta) {
		try {
		 Consulta consultaSalva = consultaService.createConsulta(consulta);
		 URI location = URI.create("/consultas/" + consultaSalva.getIdConsulta());
		 return ResponseEntity.created(location).body(consultaSalva);
		}catch(CadastroException e) {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Consulta> updateConsulta(@PathVariable Integer id, @RequestBody Consulta consulta){
		if(!consultaService.updateConsulta(id, consulta)) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().build();		
		
	}
	
	@DeleteMapping("/del/{id}")
	public ResponseEntity<Consulta> deleteConsulta(@PathVariable Integer id){
		
		if(!consultaService.deleteConsulta(id)) {
			return ResponseEntity.notFound().build();
		}else {
			return ResponseEntity.ok().build();
		}
		
	}
}
