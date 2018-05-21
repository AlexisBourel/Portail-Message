package co.simplon.portail.message.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.javafaker.Faker;

import co.simplon.portail.message.exception.ResourceNotFoundException;
import co.simplon.portail.message.model.Message;
import co.simplon.portail.message.model.Tour;
import co.simplon.portail.message.model.User;
import co.simplon.portail.message.repository.MessageRepository;
import co.simplon.portail.message.service.MessageService;
import co.simplon.portail.message.service.TourService;
import co.simplon.portail.message.service.UserService;

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
	TourService tourService;
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
	public List<Message> getAllTourMessages(String id){
		return repository.findTourMessages(id);
		
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
	
	private Message mockMessage(String titre, String type) {
		Faker faker = new Faker();
		List<User> users = userService.getAll();
		List<Tour> tours = tourService.getAll();
		Message message = new Message();
		message.setTitle(titre);
		message.setAutor(users.get(new Random().nextInt(users.size())));
		message.setTour(tours.get(new Random().nextInt(tours.size())));
		message.setContent(faker.lorem().toString());	
		message.setType(type);
		return message;
	}
	
	private void populateDbWithMockedMessages() {
		List<Message> mockedMessages = new ArrayList<>();
		mockedMessages.add(mockMessage("Message Test", "Test"));
		mockedMessages.add(mockMessage("Commande Mme Dupont", "Commande"));
		mockedMessages.add(mockMessage("Travaux rue du Séminaire", "Travaux"));
		mockedMessages.add(mockMessage("Entreprise X fermée", "Fermeture"));
		mockedMessages.add(mockMessage("Incident sur la tournée", "Incident"));
		mockedMessages.add(mockMessage("Accès Vigik en panne", "Incident"));
		mockedMessages.add(mockMessage("Gardien en vacance", "Fermeture"));
		mockedMessages.add(mockMessage("Message fake 1", "message"));
		mockedMessages.add(mockMessage("Message fake 2", "message"));
		mockedMessages.add(mockMessage("Message fake 3", "message"));
		mockedMessages.add(mockMessage("Message fake 4", "message"));
		mockedMessages.add(mockMessage("Message fake 5", "message"));
		mockedMessages.add(mockMessage("Message fake 6", "message"));
		mockedMessages.add(mockMessage("Message fake 7", "message"));
		mockedMessages.add(mockMessage("Message fake 8", "message"));
		mockedMessages.add(mockMessage("Message fake 9", "message"));
		mockedMessages.add(mockMessage("Message fake 10", "message"));
		repository.saveAll(mockedMessages);
	}

}
