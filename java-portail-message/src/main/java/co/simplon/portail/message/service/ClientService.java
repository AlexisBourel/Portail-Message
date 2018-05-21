package co.simplon.portail.message.service;

import java.util.List;

import co.simplon.portail.message.model.Client;

public interface ClientService {
	
	List<Client> getAll();

	Client getOneById(long id);

	Client create(Client client);

	Client update(Client client);

	void delete(Client client);

}
