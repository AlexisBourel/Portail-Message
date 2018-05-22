package co.simplon.portail.message.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.portail.message.model.Message;
import co.simplon.portail.message.service.MessageService;
import co.simplon.portail.message.service.MockService;

@CrossOrigin
@RestController
@RequestMapping("/message")
public class MessageController {
	/*
	 * Classe qui gére les intéractions avec le front et les services *
	 */

	@Autowired
	MessageService messageService;
	@Autowired
	MockService mockService;

	@GetMapping
	public ResponseEntity<List<Message>> getAll() {
		List<Message> result = messageService.getAll();
		if (result.isEmpty()) {
			mockService.populateDbWithMockedData();
			result = messageService.getAll();
		}
		return ResponseEntity.ok().body(result);
	}

	@GetMapping("/tour/{id}")
	public ResponseEntity<?> getAllMessageForTourById(@PathVariable(value = "id") long id) {
		return ResponseEntity.ok().body(messageService.getAllTourMessages(id));
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getOneById(@PathVariable(value = "id") long id) {
		return ResponseEntity.ok().body(messageService.getOneById(id));
	}

	@PostMapping
	public ResponseEntity<?> create(@Valid @RequestBody Message message) {
		return ResponseEntity.ok().body(messageService.create(message));
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable(value = "id") long id, @Valid @RequestBody Message messageForm) {
		Message messageToUpdate = messageService.getOneById(id);
		messageToUpdate.setContent(messageForm.getContent());
		messageToUpdate.setTitle(messageForm.getTitle());
		messageToUpdate.setTour(messageForm.getTour());
		messageToUpdate.setUpdateBy(messageForm.getUpdateBy());
		messageToUpdate.setType(messageForm.getType());
		if (messageForm.getExpiryDate() != null) {
			messageToUpdate.setExpiryDate(messageForm.getExpiryDate());
		}
		return ResponseEntity.ok().body(messageService.update(messageToUpdate));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
		Message messageToDelete = messageService.getOneById(id);
		messageService.delete(messageToDelete);
		return ResponseEntity.ok().build();
	}

}
