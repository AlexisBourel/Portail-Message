package co.simplon.portail.message.service;

import java.util.List;

import co.simplon.portail.message.model.Adress;

public interface AdressService {
		
	List<Adress> getAll();

	Adress getOneById(long id);

	Adress create(Adress adresse);

	Adress update(Adress adresse);

	void delete(Adress adresse);

}
