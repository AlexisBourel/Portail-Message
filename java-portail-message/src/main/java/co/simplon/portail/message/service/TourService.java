package co.simplon.portail.message.service;

import java.util.List;

import co.simplon.portail.message.model.Tour;

public interface TourService {
	
	List<Tour> getAll();

	Tour getOneById(long id);

	Tour create(Tour tour);

	Tour update(Tour tour);

	void delete(Tour tour);

}
