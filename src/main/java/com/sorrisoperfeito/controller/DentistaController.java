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
import com.sorrisoperfeito.model.Dentista;
import com.sorrisoperfeito.service.DentistaService;

@RestController
@RequestMapping("/dentistas")
public class DentistaController {

	@Autowired
	private DentistaService dentistaService;
	
	@GetMapping
	public ResponseEntity<List<Dentista>> findAll(){
		List<Dentista> dentistas = dentistaService.findAll();
		return ResponseEntity.ok(dentistas);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Dentista> findById(@PathVariable Integer id){
		Optional<Dentista> dentista = dentistaService.findById(id);
		if(dentista.isPresent()) {
			return ResponseEntity.ok(dentista.get());
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping("/")
	public ResponseEntity<Dentista> createDentista(@RequestBody Dentista dentista) {
		try {
		 Dentista dentistaSalvo = dentistaService.createDentista(dentista);
		 URI location = URI.create("/dentistas/" + dentistaSalvo.getIdDentista());
		 return ResponseEntity.created(location).body(dentistaSalvo);
		}catch(CadastroException e) {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Dentista> updateDentista(@PathVariable Integer id, @RequestBody Dentista dentista){
		if(!dentistaService.updateDentista(id, dentista)) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().build();		
		
	}
	
	@DeleteMapping("/del/{id}")
	public ResponseEntity<Dentista> deleteDentista(@PathVariable Integer id){
		
		if(!dentistaService.deleteDentista(id)) {
			return ResponseEntity.notFound().build();
		}else {
			return ResponseEntity.ok().build();
		}
		
	}
}
