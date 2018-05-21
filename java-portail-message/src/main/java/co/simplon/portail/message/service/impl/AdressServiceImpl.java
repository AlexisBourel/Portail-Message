package co.simplon.portail.message.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.simplon.portail.message.exception.ResourceNotFoundException;
import co.simplon.portail.message.model.Adress;
import co.simplon.portail.message.repository.AdressRepository;
import co.simplon.portail.message.service.AdressService;

@Service
public class AdressServiceImpl implements AdressService{
		
	@Autowired
	AdressRepository repository;

	@Override
	public List<Adress> getAll() {
		return repository.findAll();
	}

	@Override
	public Adress getOneById(long id) {
		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Adress", "id", id));
	}

	@Override
	public Adress create(Adress adress) {
		return repository.save(adress);
	}

	@Override
	public Adress update(Adress adress) {
		return repository.save(adress);
	}

	@Override
	public void delete(Adress adress) {
		repository.delete(adress);
	}

}
