package co.simplon.portail.message.service;

import java.util.List;

import co.simplon.portail.message.model.User;

public interface UserService {
	
	List<User> getAll();

	User getOneById(long id);

	User create(User user);

	User update(User user);

	void delete(User user);

	User getOneByMatricule(String matricule);

}
