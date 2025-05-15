package com.sorrisoperfeito.controller;

import java.net.URI;
import java.util.List;

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

import com.sorrisoperfeito.model.Dentista;
import com.sorrisoperfeito.repository.DentistaRepository;

@RestController
@RequestMapping("/clinica")
public class DentistaController {

	@Autowired
	private DentistaRepository dentistaRepository;
	
	@GetMapping("/dentistas")
	public ResponseEntity<List<Dentista>> findAll(){
		List<Dentista> dentistas = dentistaRepository.findAll();
		return ResponseEntity.ok(dentistas);
	}
	
	@PostMapping("/dentista")
	public ResponseEntity<Dentista> createDentista(@RequestBody Dentista dentista) {
		 Dentista dentistaSalvo = dentistaRepository.save(dentista);
		 URI location = URI.create("/dentista/" + dentistaSalvo.getIdDentista());
		 return ResponseEntity.created(location).body(dentistaSalvo);
	}
	
	@PutMapping("/dentista/{id}")
	public ResponseEntity<Dentista> updateDentista(@PathVariable Integer id, @RequestBody Dentista dentista){
		if(!dentistaRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		
		dentista.setIdDentista(id);
		dentistaRepository.save(dentista);
		return ResponseEntity.ok().build();		
		
	}
	
	@DeleteMapping("/dentista/{id}")
	public ResponseEntity<Dentista> deleteDentista(@PathVariable Integer id){
		
		if(!dentistaRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}else {
			dentistaRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		
	}
}
