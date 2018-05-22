package co.simplon.portail.message.service;

import java.util.List;

import co.simplon.portail.message.model.Message;

public interface MessageService {
	
	List<Message> getAll();

	Message getOneById(long id);

	Message create(Message message);

	Message update(Message message);

	void delete(Message message);

	List<Message> getAllTourMessages(long id);

}
