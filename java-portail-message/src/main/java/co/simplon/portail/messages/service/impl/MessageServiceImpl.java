package co.simplon.portail.messages.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.simplon.portail.messages.exception.ResourceNotFoundException;
import co.simplon.portail.messages.model.Message;
import co.simplon.portail.messages.repository.MessageRepository;
import co.simplon.portail.messages.service.MessageService;

@Service
public class MessageServiceImpl implements MessageService{
	/*
	 * Service qui va gérer les opération sur les messages, le coeur de l'application
	 */

	@Autowired
	MessageRepository repository;
	/*
	 * récupère tous les messages de la base de données
	 */
	@Override
	public List<Message> getAll() {
		return repository.findAll();
	}
	/*
	 * récupère tous les messages d'une tournée
	 */
	@Override
	public List<Message> getAllMessagesForTournee(String idTournee){
		return repository.findMeessagesFromTournee(idTournee);
		
	}
	/*
	 * récupère un message avec l'id du message en paramètre
	 */
	@Override
	public Message getOneById(long id) {
		return repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Message", "id", id));
	}
	/*
	 * Crée un nouveau message a stocker dans la base de données
	 */
	@Override
	public Message create(Message message) {
		return repository.save(message);
	}
	/*
	 * Modifie / met à jour un message
	 */
	@Override
	public Message update(Message message) {
		return repository.save(message);
	}	
	/*
	 * Supprimer un message
	 */
	@Override
	public void delete(Message message) {		
		repository.delete(message);
	}

}
