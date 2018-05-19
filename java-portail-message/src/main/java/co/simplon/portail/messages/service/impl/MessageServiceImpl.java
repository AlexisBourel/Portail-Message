package co.simplon.portail.messages.service.impl;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.javafaker.Faker;
import co.simplon.portail.messages.exception.ResourceNotFoundException;
import co.simplon.portail.messages.model.Message;
import co.simplon.portail.messages.model.Tournee;
import co.simplon.portail.messages.model.User;
import co.simplon.portail.messages.repository.MessageRepository;
import co.simplon.portail.messages.service.MessageService;
import co.simplon.portail.messages.service.TourneeService;
import co.simplon.portail.messages.service.UserService;

@Service
public class MessageServiceImpl implements MessageService{
	/*
	 * Service qui va gérer les opération sur les messages, le coeur de l'application
	 */

	@Autowired
	MessageRepository repository;
	@Autowired
	UserService userService;
	@Autowired
	TourneeService tourneeService;
	/*
	 * récupère tous les messages de la base de données
	 */
	@Override
	public List<Message> getAll() {
		if(repository.findAll().isEmpty()) {
			populateDbWithMockedMessages();
		}
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
	
	private Message mockMessage(String titre) {
		Faker faker = new Faker();
		List<User> users = userService.getAll();
		List<Tournee> tournees = tourneeService.getAll();
		Message message = new Message();
		message.setTitre(titre);
		message.setAuteur(users.get(new Random().nextInt(users.size())));
		message.setTournee(tournees.get(new Random().nextInt(tournees.size())));
		message.setContenu(faker.lorem().toString());		
		message.setDate( Date.valueOf(LocalDate.now()));
		return message;
	}
	
	private void populateDbWithMockedMessages() {
		List<Message> mockedMessages = new ArrayList<>();
		mockedMessages.add(mockMessage("Message Test"));
		mockedMessages.add(mockMessage("Commande Mme Dupont"));
		mockedMessages.add(mockMessage("Travaux rue du Séminaire"));
		mockedMessages.add(mockMessage("Entreprise X fermée"));
		mockedMessages.add(mockMessage("Incident sur la tournée"));
		mockedMessages.add(mockMessage("Accès Vigik en panne"));
		mockedMessages.add(mockMessage("Gardien en vacance"));
		mockedMessages.add(mockMessage("Message fake 1"));
		mockedMessages.add(mockMessage("Message fake 2"));
		mockedMessages.add(mockMessage("Message fake 3"));
		mockedMessages.add(mockMessage("Message fake 4"));
		mockedMessages.add(mockMessage("Message fake 5"));
		mockedMessages.add(mockMessage("Message fake 6"));
		mockedMessages.add(mockMessage("Message fake 7"));
		mockedMessages.add(mockMessage("Message fake 8"));
		mockedMessages.add(mockMessage("Message fake 9"));
		mockedMessages.add(mockMessage("Message fake 10"));
		repository.saveAll(mockedMessages);
	}

}
