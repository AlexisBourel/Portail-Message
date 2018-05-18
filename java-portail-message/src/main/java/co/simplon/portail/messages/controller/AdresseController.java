package co.simplon.portail.messages.controller;

import java.util.List;

import javax.validation.Valid;

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

import co.simplon.portail.messages.model.Adresse;
import co.simplon.portail.messages.service.AdresseService;



@RestController
@RequestMapping("/adresse")
public class AdresseController {

	/* 
	 * Classe qui gére les intéractions avec le front et les services	 *  
	 * */

	@Autowired
	AdresseService adresseService;

	@GetMapping
	public ResponseEntity<List<Adresse>> getAll() {
		return ResponseEntity.ok().body(adresseService.getAll());
	}
	
	@GetMapping("/{id}") 
	public ResponseEntity<?> getOneById(@PathVariable(value="id") Long id) {
		return ResponseEntity.ok().body(adresseService.getOneById(id));
	}

	@PostMapping
	public ResponseEntity<?> create(@Valid @RequestBody Adresse adresse) { 
	    return ResponseEntity.ok().body(adresseService.create(adresse));
	}   
   
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable(value ="id") Long id, @Valid @RequestBody Adresse adresseForm) {
		Adresse adresseToUpdate = adresseService.getOneById(id);
		adresseToUpdate.setNumero(adresseForm.getNumero());
		adresseToUpdate.setRue(adresseForm.getRue());
		adresseToUpdate.setCp(adresseForm.getCp());
		adresseToUpdate.setVille(adresseForm.getVille());
		return ResponseEntity.ok().body(adresseService.update(adresseToUpdate));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable(value="id") Long id) {
		Adresse adresseToDelete = adresseService.getOneById(id);
		adresseService.delete(adresseToDelete);
		return ResponseEntity.ok().build();
	}
	
}
