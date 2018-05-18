package co.simplon.portail.messages.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.simplon.portail.messages.exception.ResourceNotFoundException;
import co.simplon.portail.messages.model.Tournee;
import co.simplon.portail.messages.repository.TourneeRepository;
import co.simplon.portail.messages.service.TourneeService;

@Service
public class TourneeServiceImpl implements TourneeService{
	
	/*
	 * Services impliquant les tournées, ici assez vide les données étant fictives, l'application ,tourne essentielllement autour des messages
	 */

	@Autowired
	TourneeRepository repository;

	@Override
	public List<Tournee> getAll() {
		if (repository.findAll().isEmpty()) {
			populateDbWithMockedTournees();
		}
		return repository.findAll();
	}

	@Override
	public Tournee getOneById(long id) {
		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Tournee", "id", id));
	}

	@Override
	public Tournee create(Tournee tournee) {
		return repository.save(tournee);
	}

	@Override
	public Tournee update(Tournee tournee) {
		return repository.save(tournee);
	}

	@Override
	public void delete(Tournee tournee) {
		repository.delete(tournee);
	}
		
	public void populateDbWithMockedTournees() {
		List<Tournee> tournees = new ArrayList<>();
		tournees.add(mockTournee("TL0001"));
		tournees.add(mockTournee("TL0002"));
		tournees.add(mockTournee("TL0003"));
		tournees.add(mockTournee("TL0004"));
		tournees.add(mockTournee("TL0005"));
		tournees.add(mockTournee("TL0006"));
		tournees.add(mockTournee("TL0007"));
		tournees.add(mockTournee("TL0008"));
		tournees.add(mockTournee("TL0009"));
		tournees.add(mockTournee("TL0010"));
		tournees.add(mockTournee("TL0011"));
		tournees.add(mockTournee("TL0012"));
		tournees.add(mockTournee("TL0013"));
		tournees.add(mockTournee("TL0014"));
		tournees.add(mockTournee("TL0015"));
		repository.saveAll(tournees);	
	}
	
	public Tournee mockTournee(String name) {
		Tournee tournee = new Tournee();
		Random random = new Random();
		tournee.setNom(name);
		tournee.setEntreprises(random.nextInt(15) + 1);
		tournee.setObjets(random.nextInt(50) + 1);
		tournee.setPickup(random.nextInt(5) + 1);
		tournee.setPresta(random.nextInt(5) + 1);
		return tournee;
	}






	
	
}
