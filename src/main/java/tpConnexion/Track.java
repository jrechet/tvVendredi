package tpConnexion;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.ManyToOne;

@Entity
@Table(name="Track")
public class Track {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) //GenerationType.IDENTITY au départ, sans succès
	private Long id;
	@Column
	private String title;
	@Column
	private String artist;
	
	@ManyToOne(fetch = FetchType.EAGER)				// Apparié avec OneToMany ds User.java
	private User user; 

	public Track() {
	}
	
	// Getters-Setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}