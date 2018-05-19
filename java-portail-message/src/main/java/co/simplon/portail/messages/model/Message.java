package co.simplon.portail.messages.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "message")
public class Message implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -1025223523728208763L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable=false, unique=true, length=25)//définit le nom de la colonne ainsi que les contraintes associéss
    private String titre;

    @Lob //doit être conservé en tant qu'objet volumineux (text)
    @Column(nullable=false)//définit le nom de la colonne ainsi que les contraintes associés
    private String contenu;

    @Column(nullable = false, updatable = false)//définit le nom de la colonne ainsi que les contraintes associés
    private Date date;
    
    @ManyToOne//un facteur peux écrire plusieurs messages
    @JoinColumn(name = "facteur_id",nullable = false, updatable = false)
    private User auteur;
    
    @ManyToOne//une tournée avoir plusieurs messages
    @JoinColumn(name="tournee_id",nullable = false, updatable = false)
    private Tournee tournee;

	public long getId() {
		return id;
	}

	public void setId(long id) {
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public User getAuteur() {
		return auteur;
	}

	public void setAuteur(User auteur) {
		this.auteur = auteur;
	}

	public Tournee getTournee() {
		return tournee;
	}

	public void setTournee(Tournee tournee) {
		this.tournee = tournee;
	} 
    
}
