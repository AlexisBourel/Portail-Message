package co.simplon.portail.messages.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "messages")
public class Message implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -1025223523728208763L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false, unique=true)
    private String titre;

    @Column(nullable=false)
    private String contenu;

    @Column(nullable = false, updatable = false)
    private LocalDate date;
    
//    @Column(nullable = false, updatable = false)
//    private Facteur auteur;
//    
//    @Column(nullable = false, updatable = false)
//    private Tournee tournee;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

//	public Facteur getAuteur() {
//		return auteur;
//	}
//
//	public void setAuteur(Facteur auteur) {
//		this.auteur = auteur;
//	}
//
//	public Tournee getTournee() {
//		return tournee;
//	}
//
//	public void setTournee(Tournee tournee) {
//		this.tournee = tournee;
//	}
    
    
    
}
