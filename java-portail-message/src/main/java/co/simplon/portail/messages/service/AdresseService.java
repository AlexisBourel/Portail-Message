package co.simplon.portail.messages.service;

import java.util.List;

import co.simplon.portail.messages.model.Adresse;

public interface AdresseService {
		
	List<Adresse> getAll();

	Adresse getOneById(long id);

	Adresse create(Adresse adresse);

	Adresse update(Adresse adresse);

	void delete(Adresse adresse);

}
