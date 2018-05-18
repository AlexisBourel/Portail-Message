package co.simplon.portail.messages.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.simplon.portail.messages.exception.ResourceNotFoundException;
import co.simplon.portail.messages.model.Adresse;
import co.simplon.portail.messages.repository.AdresseRepository;
import co.simplon.portail.messages.service.AdresseService;

@Service
public class AdresseServiceImpl implements AdresseService{
		
	@Autowired
	AdresseRepository repository;

	@Override
	public List<Adresse> getAll() {
		return repository.findAll();
	}

	@Override
	public Adresse getOneById(long id) {
		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Adresse", "id", id));
	}

	@Override
	public Adresse create(Adresse adresse) {
		return repository.save(adresse);
	}

	@Override
	public Adresse update(Adresse adresse) {
		return repository.save(adresse);
	}

	@Override
	public void delete(Adresse adresse) {
		repository.delete(adresse);
	}

}
