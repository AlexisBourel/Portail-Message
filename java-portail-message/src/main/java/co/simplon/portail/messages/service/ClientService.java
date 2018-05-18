package co.simplon.portail.messages.service;

import java.util.List;

import co.simplon.portail.messages.model.Client;

public interface ClientService {
	
	List<Client> getAll();

	Client getOneById(long id);

	Client create(Client client);

	Client update(Client client);

	void delete(Client client);

}
