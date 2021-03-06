package co.simplon.portail.messages.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.javafaker.Faker;

import co.simplon.portail.messages.exception.ResourceNotFoundException;
import co.simplon.portail.messages.model.User;
import co.simplon.portail.messages.repository.UserRepository;
import co.simplon.portail.messages.service.UserService;

/*
 * Classe de méthodes pour gérer les intéractions avec User
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository repository;

	@Override
	public List<User> getAll() {
		if (repository.findAll().isEmpty()) {
			populateDbWithMockedUsers();
		}
		return repository.findAll();
	}

	@Override
	public User getOneById(long id) {
		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
	}
	
	@Override
	public User getOneByMatricule(String matricule) {
		return repository.getOneByMatricule(matricule); 
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


	private void populateDbWithMockedUsers() {
		List<User> users = new ArrayList<>();
		// creation d'un user pour les test
		User userTest = new User();
		userTest.setMatricule("pabc123");
		userTest.setNom("Bourel");
		userTest.setPrenom("Alexis");
		userTest.setPassword("testmdp");
		userTest.setFonction("Administrateur");
		users.add(userTest);
		// creation d'une dizaine de faux users
		for (int i = 0; i < 10; i++) {
			users.add(mockUser());
		}
		// enregistrement des users dans la BDD
		repository.saveAll(users);
	}

	private User mockUser() {
		// Permet de générer des fausses Data
		Faker faker = new Faker();
		User user = new User();
		// A LA POSTE les userId sont sous la forme de "pabc123" p définit le service
		// "courrier" puis 3 lettres + 3 chiffres
		user.setMatricule(new StringBuilder("p").append(RandomStringUtils.randomAlphabetic(3).toLowerCase())
				.append(new Random().nextInt(999) + 1).toString());
		user.setNom(faker.name().lastName());
		user.setPrenom(faker.name().firstName());
		user.setPassword(new StringBuilder(user.getMatricule()).append("mdp").toString());
		user.setFonction("agent");
		return user;
	}

}
