package co.simplon.portail.message.service.impl;

import java.util.ArrayList;
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
		if (repository.findAll().isEmpty()) {
			populateDbWithMockedTours();
		}
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
		
	public void populateDbWithMockedTours() {
		List<Tour> tours = new ArrayList<>();
		tours.add(mockTour("TL0001"));
		tours.add(mockTour("TL0002"));
		tours.add(mockTour("TL0003"));
		tours.add(mockTour("TL0004"));
		tours.add(mockTour("TL0005"));
		tours.add(mockTour("TL0006"));
		tours.add(mockTour("TL0007"));
		tours.add(mockTour("TL0008"));
		tours.add(mockTour("TL0009"));
		tours.add(mockTour("TL0010"));
		tours.add(mockTour("TL0011"));
		tours.add(mockTour("TL0012"));
		tours.add(mockTour("TL0013"));
		tours.add(mockTour("TL0014"));
		tours.add(mockTour("TL0015"));
		repository.saveAll(tours);	
	}
	
	public Tour mockTour(String name) {
		Tour tour = new Tour();
//		Random random = new Random();
		tour.setName(name);
//		tour.setEntreprises(random.nextInt(15) + 1);
//		tour.setObjets(random.nextInt(50) + 1);
//		tour.setPickup(random.nextInt(5) + 1);
//		tour.setPresta(random.nextInt(5) + 1);
		return tour;
	}






	
	
}
