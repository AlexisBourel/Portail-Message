package co.simplon.portail.messages.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="facteur")
public class Facteur implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6536696703821642058L;
	@Id
	@Column(nullable=false, unique=true, length=7)
	private String id; //ex: pabc123
	@Column(nullable=false, length = 25)
	private String nom;
	@Column(nullable=false, length=25)
	private String prenom;
	@Column(nullable=false, length=25)
	private String password;
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
