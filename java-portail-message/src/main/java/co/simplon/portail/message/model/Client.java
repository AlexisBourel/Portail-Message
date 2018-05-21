package co.simplon.portail.message.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "client")
public class Client {
	
	@Id
	@Column(nullable=false, unique=true)
	private long id;
	@Column
	private String name;
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "adresse_id",nullable = false)
	private Adress adresse;
	@Column(length = 10)
	private long phone;
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tour_id",nullable = false)
	private Tour tour;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Adress getAdresse() {
		return adresse;
	}

	public void setAdresse(Adress adresse) {
		this.adresse = adresse;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public Tour getTour() {
		return tour;
	}

	public void setTour(Tour tour) {
		this.tour = tour;
	}

}
