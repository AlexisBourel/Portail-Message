package co.simplon.portail.message.controller;

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

import co.simplon.portail.message.model.Adress;
import co.simplon.portail.message.service.AdressService;



@RestController
@RequestMapping("/adress")
public class AdressController {

	/* 
	 * Classe qui gére les intéractions avec le front et les services	 *  
	 * */

	@Autowired
	AdressService adressService;

	@GetMapping
	public ResponseEntity<List<Adress>> getAll() {
		return ResponseEntity.ok().body(adressService.getAll());
	}
	
	@GetMapping("/{id}") 
	public ResponseEntity<?> getOneById(@PathVariable(value="id") Long id) {
		return ResponseEntity.ok().body(adressService.getOneById(id));
	}

	@PostMapping
	public ResponseEntity<?> create(@Valid @RequestBody Adress adress) { 
	    return ResponseEntity.ok().body(adressService.create(adress));
	}   
   
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable(value ="id") Long id, @Valid @RequestBody Adress adressForm) {
		Adress adressToUpdate = adressService.getOneById(id);
		adressToUpdate.setNumero(adressForm.getNumero());
		adressToUpdate.setRue(adressForm.getRue());
		adressToUpdate.setCp(adressForm.getCp());
		adressToUpdate.setVille(adressForm.getVille());
		return ResponseEntity.ok().body(adressService.update(adressToUpdate));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable(value="id") Long id) {
		Adress adressToDelete = adressService.getOneById(id);
		adressService.delete(adressToDelete);
		return ResponseEntity.ok().build();
	}
	
}
