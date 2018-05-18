package co.simplon.portail.messages.model;

import java.io.Serializable;

import javax.persistence.*;


@Entity
@Table(name="tournee")
public class Tournee implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 9123440425394314843L;
	/*
	 * Model pour la tournée, on a besoin ici uniquement de son id
	 * qui se traduit en string (ex: TL0001) par convention à LA POSTE
	 * les autres attibuts seront simulés pour la présentation de l'application
	 * en effet, ces informations sont extraits de l'application "TRACEO"
	 * il s'agits des diffèrents services à effectuer lors de la tournée par le facteur
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(nullable=false, unique=true, length=6)
	private String nom;
	@Column
	private int objets;
	@Column
	private int entreprises;
	@Column
	private int presta;
	@Column
	private int pickup;
	@OneToOne
	private User agent;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getObjets() {
		return objets;
	}
	public void setObjets(int objets) {
		this.objets = objets;
	}
	public int getEntreprises() {
		return entreprises;
	}
	public void setEntreprises(int entreprises) {
		this.entreprises = entreprises;
	}
	public int getPresta() {
		return presta;
	}
	public void setPresta(int presta) {
		this.presta = presta;
	}
	public int getPickup() {
		return pickup;
	}
	public void setPickup(int pickup) {
		this.pickup = pickup;
	}
	public User getAgent() {
		return agent;
	}
	public void setAgent(User agent) {
		this.agent = agent;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	
}
