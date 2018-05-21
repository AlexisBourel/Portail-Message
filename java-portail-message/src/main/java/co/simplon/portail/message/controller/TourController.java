package co.simplon.portail.message.controller;

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

import co.simplon.portail.message.model.Tour;
import co.simplon.portail.message.service.impl.TourServiceImpl;

@RestController
@RequestMapping("/tour")
public class TourController {

	@Autowired
	TourServiceImpl tourService;
	
	// Récupèrer tous les messages
	@CrossOrigin
	@GetMapping
	public List<Tour> getAll() {
		return tourService.getAll();
	}
	
	// Récupèrer les messages d'une tournée
	@CrossOrigin
	@GetMapping("/{id}")
	public Tour getOneById(@PathVariable(value="id") long id) {
		return tourService.getOneById(id);	
	}
	
	@CrossOrigin
	@PutMapping("/{id}")
	public Tour update(@PathVariable(value="id") long id, @Valid @RequestBody Tour tourForm) {		
		Tour tourToUpdate = tourService.getOneById(id);
		if (tourToUpdate.getAgent() == null) { //un seul facteur par jour, 
			tourToUpdate.setAgent(tourForm.getAgent());
			return tourService.update(tourToUpdate);
		}
		else return tourService.update(tourForm);
	}
	
}
