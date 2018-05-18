package co.simplon.portail.messages.service;

import java.util.List;

import co.simplon.portail.messages.model.Message;

public interface MessageService {

	List<Message> getAllMessagesForTournee(String idTournee);
	
	List<Message> getAll();

	Message getOneById(long id);

	Message create(Message message);

	Message update(Message message);

	void delete(Message message);

}
