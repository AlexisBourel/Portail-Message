package co.simplon.portail.message.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.simplon.portail.message.exception.ResourceNotFoundException;
import co.simplon.portail.message.model.Message;
import co.simplon.portail.message.repository.MessageRepository;
import co.simplon.portail.message.service.MessageService;
import co.simplon.portail.message.service.TourService;
import co.simplon.portail.message.service.UserService;

@Service
public class MessageServiceImpl implements MessageService {
	/*
	 * Service qui va gérer les opération sur les messages, le coeur de
	 * l'application
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
		return repository.findAll();
	}

	/*
	 * récupère tous les messages d'une tournée
	 */
	@Override
	public List<Message> getAllTourMessages(long id) {
		return repository.findTourMessages(id);

	}

	/*
	 * récupère un message avec l'id du message en paramètre
	 */
	@Override
	public Message getOneById(long id) {
		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Message", "id", id));
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

	@Override
	public Message findByTitle(String title) {
		List<Message> messages = getAll();
		for (Message message : messages) {
			if (message.getTitle().equals(title)) {
				return message;
			}
		}
		return null;
	}

	@Override
    public boolean exists(Message message) {
        return findByTitle(message.getTitle()) != null;
    }

}
