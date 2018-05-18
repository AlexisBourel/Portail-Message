package co.simplon.portail.messages.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.portail.messages.model.Tournee;
import co.simplon.portail.messages.service.impl.TourneeServiceImpl;

@RestController
@RequestMapping("/tournee")
public class Tourneecontroller {

	@Autowired
	TourneeServiceImpl tourneeService;
	
	// Récupèrer tous les messages
	@CrossOrigin
	@GetMapping
	public List<Tournee> getAll() {
		return tourneeService.getAll();
	}
	
	// Récupèrer les messages d'une tournée
	@CrossOrigin
	@GetMapping("/{id}")
	public Tournee getOneById(@PathVariable(value="id") long id) {
		return tourneeService.getOneById(id);	
	}
	
	@CrossOrigin
	@PutMapping("/{id}")
	public Tournee updateTournee(@PathVariable(value="id") long id, @Valid @RequestBody Tournee tourneeForm) {		
		Tournee tourneeToUpdate = tourneeService.getOneById(id);
		if (tourneeToUpdate.getAgent() == null) { //un seul facteur par jour, 
			tourneeToUpdate.setAgent(tourneeForm.getAgent());
			return tourneeService.update(tourneeToUpdate);
		}
		else return tourneeService.update(tourneeForm);
	}
	
}
