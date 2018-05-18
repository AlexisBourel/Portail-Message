package co.simplon.portail.messages.model;

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
	private String nom;
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "adresse_id",nullable = false)
	private Adresse adresse;
	@Column(length = 10)
	private Long phone;
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tournee_id",nullable = false)
	private Tournee tournee;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public Long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}

	public Tournee getTournee() {
		return tournee;
	}

	public void setTournee(Tournee tournee) {
		this.tournee = tournee;
	}

}
