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
	@Column(nullable=false, unique=true, length=6)
	private String id;
	@Column(nullable=false)
	private int objets;
	@Column(nullable=false)
	private int entreprises;
	@Column(nullable=false)
	private int presta;
	@Column(nullable=false)
	private int pickup;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
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
	
	
}
