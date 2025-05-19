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
import com.sorrisoperfeito.model.Paciente;
import com.sorrisoperfeito.service.PacienteService;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

	@Autowired
	private PacienteService pacienteService;	
	
	
	@GetMapping
	public ResponseEntity<List<Paciente>> findAll(){
		List<Paciente> pacientes = pacienteService.findAll();
		return ResponseEntity.ok(pacientes);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Paciente> findById(@PathVariable Integer id){
		Optional<Paciente> paciente = pacienteService.findById(id);
		if(paciente.isPresent()) {
			return ResponseEntity.ok(paciente.get());
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping("/")
	public ResponseEntity<Paciente> createPaciente(@RequestBody Paciente paciente) {
		try {
		 Paciente pacienteSalvo = pacienteService.createPaciente(paciente);
		 URI location = URI.create("/pacientes/" + pacienteSalvo.getIdPaciente());
		 return ResponseEntity.created(location).body(pacienteSalvo);
		}catch(CadastroException e) {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Paciente> updatePaciente(@PathVariable Integer id, @RequestBody Paciente paciente){
		if(!pacienteService.updatePaciente(id, paciente)) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().build();		
		
	}
	
	@DeleteMapping("/del/{id}")
	public ResponseEntity<Paciente> deletePaciente(@PathVariable Integer id){
		
		if(!pacienteService.deletePaciente(id)) {
			return ResponseEntity.notFound().build();
		}else {
			return ResponseEntity.ok().build();
		}
		
	}
}
