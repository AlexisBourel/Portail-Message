package co.simplon.portail.messages.service;

import java.util.List;

import co.simplon.portail.messages.model.Tournee;

public interface TourneeService {
	
	List<Tournee> getAll();

	Tournee getOneById(long id);

	Tournee create(Tournee tournee);

	Tournee update(Tournee tournee);

	void delete(Tournee tournee);

}
