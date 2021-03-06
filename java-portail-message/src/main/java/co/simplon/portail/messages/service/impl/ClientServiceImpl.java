package co.simplon.portail.messages.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import co.simplon.portail.messages.exception.ResourceNotFoundException;
import co.simplon.portail.messages.model.Client;
import co.simplon.portail.messages.repository.ClientRepository;
import co.simplon.portail.messages.service.ClientService;

public class ClientServiceImpl implements ClientService{

	@Autowired
	ClientRepository repository;

	@Override
	public List<Client> getAll() {
		return repository.findAll();
	}

	@Override
	public Client getOneById(long id) {
		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Client", "id", id));
	}

	@Override
	public Client create(Client client) {
		return repository.save(client);
	}

	@Override
	public Client update(Client client) {
		return repository.save(client);
	}

	@Override
	public void delete(Client client) {
		repository.delete(client);
	}

}
