package co.simplon.portail.message.model;

import java.io.Serializable;

import javax.persistence.*;


@Entity
@Table(name="tour")
public class Tour implements Serializable{
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
	private String name;
	@OneToOne
	private User agent;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public User getAgent() {
		return agent;
	}
	public void setAgent(User agent) {
		this.agent = agent;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
