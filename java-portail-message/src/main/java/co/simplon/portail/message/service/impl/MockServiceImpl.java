package co.simplon.portail.message.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.javafaker.Faker;

import co.simplon.portail.message.model.Message;
import co.simplon.portail.message.model.Tour;
import co.simplon.portail.message.model.Type;
import co.simplon.portail.message.model.User;
import co.simplon.portail.message.repository.MessageRepository;
import co.simplon.portail.message.repository.TourRepository;
import co.simplon.portail.message.repository.UserRepository;
import co.simplon.portail.message.service.MockService;

@Service
public class MockServiceImpl implements MockService {

	@Autowired
	UserRepository userRepository;
	@Autowired
	TourRepository tourRepository;
	@Autowired
	MessageRepository messageRepository;
	private Random rand = new Random();

	@Override
	public void populateDbWithMockedData() {
		populateDbWithUsers();
		populateDbWithTours();
		populateDbWithMessages();
	}

	private void populateDbWithUsers() {
		List<User> users = new ArrayList<>();
		users.add(mockAdminUser());
		for (int i = 0; i < 50; i++) {
			users.add(mockUser());
		}
		userRepository.saveAll(users);
	}

	private void populateDbWithTours() {
		List<Tour> tours = new ArrayList<>();
		for (int i = 1; i < 10; i++) {
			tours.add(mockTour("TL000" + i));
		}
		for (int i = 10; i < 31; i++) {
			tours.add(mockTour("TL00" + i));
		}
		tourRepository.saveAll(tours);
	}

	public void populateDbWithMessages() {
		List<Message> messages = new ArrayList<>();
		messages.addAll(mockSomeMessages());
		for (int i = 0; i < 40; i++) {
			messages.add(mockMessage("Faux Message " + i , randomType().toString()));
		}
		messageRepository.saveAll(messages);
	}

	private User mockUser() {
		// Permet de générer des fausses Data
		Faker faker = new Faker();
		User user = new User();
		// A LA POSTE les userId sont sous la forme de "pabc123" p définit le service
		// "courrier" puis 3 lettres + 3 chiffres
		user.setMatricule(new StringBuilder("p").append(RandomStringUtils.randomAlphabetic(3).toLowerCase())
				.append(rand.nextInt(999) + 1).toString());
		user.setLastname(faker.name().lastName());
		user.setFirstname(faker.name().firstName());
		user.setPassword(new StringBuilder(user.getMatricule()).append("mdp").toString());
		user.setPhone("06" + (rand.nextInt(99999999) + 1));
		user.setFunction("agent");
		return user;
	}

	private User mockAdminUser() {
		User userAdmin = new User();
		userAdmin.setMatricule("pabc123");
		userAdmin.setLastname("Bourel");
		userAdmin.setFirstname("Alexis");
		userAdmin.setPassword("azerty");
		userAdmin.setFunction("Administrateur");
		userAdmin.setPhone("0123456789");
		return userAdmin;
	}

	private Tour mockTour(String name) {
		Tour tour = new Tour();
		tour.setName(name);
		return tour;
	}

	private Message mockMessage(String titre, String type) {
		List<User> users = userRepository.findAll();
		List<Tour> tours = tourRepository.findAll();
		Message message = new Message();
		message.setTitle(titre);
		message.setAutor(users.get(new Random().nextInt(users.size())));
		message.setTour(tours.get(new Random().nextInt(tours.size())));
		message.setContent(mockContent());
		message.setType(type);
		return message;
	}

//	private Message mockRandomMessage() {
//		List<User> users = userRepository.findAll();
//		List<Tour> tours = tourRepository.findAll();
//		Message message = new Message();
//		message.setTitle(RandomStringUtils.randomAlphabetic(rand.nextInt(8)).toLowerCase());
//		message.setAutor(users.get(rand.nextInt(users.size())));
//		message.setTour(tours.get(rand.nextInt(tours.size())));
//		message.setContent(
//				"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam sit amet lectus vel augue pretium consequat"
//				+ ". Etiam in magna quis metus mattis facilisis vitae sit amet lectus. Morbi mollis enim sed lacus molestie,"
//				+ " varius accumsan nisl efficitur. Praesent a viverra dolor, sed iaculis risus. In a condimentum nunc. "
//				+ "Donec magna libero, pharetra non purus vitae, congue commodo quam. Quisque accumsan nisl lorem, "
//				+ "tempor maximus neque cursus non. Proin augue leo, auctor non dignissim vel, mattis non leo.");
//		message.setType(randomType().toString());
//		return message;
//	}

	private String mockContent() {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < 10; i++) {
			String newString = RandomStringUtils.randomAlphabetic(rand.nextInt(8)).toLowerCase();
			result = result.append(" ").append(newString);
		}
		return result.toString();
	}

	private List<Message> mockSomeMessages() {
		List<Message> mockedMessages = new ArrayList<>();
		mockedMessages.add(mockMessage("Message Test", "Test"));
		mockedMessages.add(mockMessage("Commande Mme Dupont", "Commande"));
		mockedMessages.add(mockMessage("Travaux rue du Séminaire", "Travaux"));
		mockedMessages.add(mockMessage("Entreprise X fermée", "Fermeture"));
		mockedMessages.add(mockMessage("Incident sur la tournée", "Incident"));
		mockedMessages.add(mockMessage("Accès Vigik en panne", "Incident"));
		mockedMessages.add(mockMessage("Gardien en vacance", "Fermeture"));
		return mockedMessages;
	}

	public static Type randomType() {
		return Type.values()[new Random().nextInt(Type.values().length)];
	}

}
