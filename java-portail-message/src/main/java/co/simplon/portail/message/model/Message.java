package co.simplon.portail.message.model;

import javax.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "message")
public class Message extends AuditModel {
    /**
	 * 
	 */
	private static final long serialVersionUID = -1025223523728208763L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
	
	@Column(nullable=false, unique=true, length=25)
    private String title;
    @Lob
    @Column(nullable=false)
    private String content;
    @Column
    private Date expiryDate;        
    @ManyToOne
    @JoinColumn(name="tour_id",nullable = false, updatable = false)
    private Tour tour;
    @Column(nullable=false, length=30)
    private String type;    

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

    public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public Tour getTour() {
		return tour;
	}

	public void setTour(Tour tour) {
		this.tour = tour;
	} 
    
}
