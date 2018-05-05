package co.simplon.portail.messages.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.portail.messages.model.Message;
import co.simplon.portail.messages.service.MessageService;

@RestController
@RequestMapping("/api")
public class MessageController {
	/* 
	 * Classe qui gére les intéractions avec le front et les services	 *  
	 * */

	@Autowired
	MessageService messageService;
	
	// Récupèrer tous les messages
	@GetMapping("/messages")//répond à la requête /messages avec la méthode "Get" 
	public List<Message> getAllMessages() {
		return messageService.getAllMessages();
	}
	
	// Récupèrer un message avec l'id indiqué dans la requète
	@GetMapping("/message/{id}")//répond à la la requête /message/id, id étant une variable avec la méthode "Get"   
	public Message getMessageById(@PathVariable(value="id") Long id) {
		return messageService.getMessageById(id);
	}
	
    // Créer un nouveau message
	@PostMapping("/message")// répond à la la requête /message avec méthode "Post"
	public Message createMessage(@Valid @RequestBody Message message) { //vérifie aussi que le message contient les informations nécéssaire
	    return messageService.createMessage(message);
	}   
    // Modifier un message
	@PutMapping("/message/{id}")//répond à la requête /message/id avec la méthode "Put"
	public Message updateMessage(@PathVariable(value ="id") Long id, @Valid @RequestBody Message message) {
		return messageService.updateNote(id, message);
	}
	
    // Supprimer un message
	@DeleteMapping("/messsage/{id}")// répond à la requête /message/id avec la méthode "Delete"
	public void deleteMessageById(@PathVariable(value="id") Long id) {
		messageService.deleteMessage(id);
	}
	
}
