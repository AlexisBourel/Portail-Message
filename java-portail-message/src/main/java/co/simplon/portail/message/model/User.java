package co.simplon.portail.message.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6536696703821642058L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(nullable=false, unique=true, length=7)
	private String matricule; //ex: pabc123
	@Column(nullable=false, length=25)
	private String lastname;
	@Column(nullable=false, length=25)
	private String firstname;
	@Column(nullable=false, length=25)
	private String password;
	@Column(length=10)
	private Long phone;
	@OneToOne
	private Tour tour;
	@Column(nullable=false, length=15)
	private String function;
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}

	public Tour getTour() {
		return tour;
	}

	public void setTour(Tour tour) {
		this.tour = tour;
	}

	public String getFunction() {
		return function;
	}

	public void setFunction(String fonction) {
		this.function = fonction;
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	
}
