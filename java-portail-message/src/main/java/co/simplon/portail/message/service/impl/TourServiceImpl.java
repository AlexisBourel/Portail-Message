package co.simplon.portail.message.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.simplon.portail.message.exception.ResourceNotFoundException;
import co.simplon.portail.message.model.Tour;
import co.simplon.portail.message.repository.TourRepository;
import co.simplon.portail.message.service.TourService;

@Service
public class TourServiceImpl implements TourService{
	
	/*
	 * Services impliquant les tournées, ici assez vide les données étant fictives, l'application ,tourne essentielllement autour des messages
	 */

	@Autowired
	TourRepository repository;

	@Override
	public List<Tour> getAll() {
		return repository.findAll();
	}

	@Override
	public Tour getOneById(long id) {
		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Tour", "id", id));
	}

	@Override
	public Tour create(Tour tour) {
		return repository.save(tour);
	}

	@Override
	public Tour update(Tour tour) {
		return repository.save(tour);
	}

	@Override
	public void delete(Tour tour) {
		repository.delete(tour);
	}	
}
