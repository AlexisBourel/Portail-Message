package co.simplon.portail.message.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.simplon.portail.message.exception.ResourceNotFoundException;
import co.simplon.portail.message.model.User;
import co.simplon.portail.message.repository.UserRepository;
import co.simplon.portail.message.service.UserService;

/*
 * Classe de méthodes pour gérer les intéractions avec User
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository repository;

	@Override
	public List<User> getAll() {
		return repository.findAll();
	}

	@Override
	public User getOneById(long id) {
		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
	}
	
	@Override
	public User getOneByMatricule(String matricule) {
		return repository.getOneByMatricule(matricule).orElseThrow(() -> new ResourceNotFoundException("User", "matricule", matricule)); 
	}

	@Override
	public User create(User user) {
		return repository.save(user);
	}

	@Override
	public User update(User user) {
		return repository.save(user);
	}

	@Override
	public void delete(User user) {
		repository.delete(user);
	}
}
