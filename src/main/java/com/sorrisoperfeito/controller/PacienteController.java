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

import com.sorrisoperfeito.model.Paciente;
import com.sorrisoperfeito.repository.PacienteRepository;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

	@Autowired
	private PacienteRepository pacienteRepository;	
	
	
	@GetMapping
	public ResponseEntity<List<Paciente>> findAll(){
		List<Paciente> pacientes = pacienteRepository.findAll();
		return ResponseEntity.ok(pacientes);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Paciente> findById(@PathVariable Integer id){
		Optional<Paciente> paciente = pacienteRepository.findById(id);
		
		if(paciente.isPresent()) {
			return ResponseEntity.ok(paciente.get());
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping("/")
	public ResponseEntity<Paciente> addPaciente(@RequestBody Paciente paciente){
		Paciente p = pacienteRepository.save(paciente);
		URI uri = URI.create("/pacientes/" + p.getIdPaciente());
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Paciente> updatePaciente(@PathVariable Integer id, @RequestBody Paciente paciente){
		if(!pacienteRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		paciente.setIdPaciente(id);
		pacienteRepository.save(paciente);
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Paciente> updatePaciente(@PathVariable Integer id){
		if(!pacienteRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		pacienteRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}
}
