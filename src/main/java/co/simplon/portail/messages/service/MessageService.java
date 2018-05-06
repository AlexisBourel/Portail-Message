package co.simplon.portail.messages.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.simplon.portail.messages.exception.ResourceNotFoundException;
import co.simplon.portail.messages.model.Message;
import co.simplon.portail.messages.repository.MessageRepository;

@Service
public class MessageService {
	/*
	 * Service qui va gérer les opération sur les messages
	 */

	@Autowired
	MessageRepository repo; // importe les méthodes pour intéragir avec la base de données

	/*
	 * récupère tous les messages de la base de données
	 */
	public List<Message> getAllMessages() {
		return repo.findAll();
	}

	/*
	 * récupère un message avec l'id du message en paramètre
	 */
	public Message getMessageById(Long id) {
		return repo.findById(id) // retourne le message en question
				// ou renvois une erreur qui indique que le message portant cette id n'éxiste
				// pas
				.orElseThrow(() -> new ResourceNotFoundException("Message", "id", id));
	}

	/*
	 * Crée un nouveau message a stocker dans la base de données
	 */
	public Message createMessage(Message message) {
		message.setDate(LocalDate.now());// on ajoute auomatiquement la date de maintenant au message
		return repo.save(message);
	}

	/*
	 * Modifie / met à jour un message
	 */
	public Message updateNote(Long id, Message messageToUpdate) {

		Message updateMessage = repo.findById(id) // récupère le message à modifier
				.orElseThrow(() -> new ResourceNotFoundException("Note", "id", id));

		//redéfinit les valeurs des attributs du message avec les info 
		updateMessage.setTitre(messageToUpdate.getTitre());
		updateMessage.setContenu(messageToUpdate.getContenu());
		//messageToUpdate.setAuteur(messageToUpdate.getAuteur());
		//messageToUpdate.setTournee(messageToUpdate.getTournee());

		repo.save(updateMessage); //sauvegarde le message dans la BDD

		return updateMessage;
	}
	
	/*
	 * Supprimer un message
	 */
	public void deleteMessage(Long id) {
		Message messageToDelete = repo.findById(id) //récupère le message à supprimer
				.orElseThrow(() -> new ResourceNotFoundException("Message", "id", id)); // ou renvoi une exception
		
		repo.delete(messageToDelete); //supprime le message
		
	}
}
