package com.sdze.school.entite;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

@Entity
public class Publication {
	@Id
	@GeneratedValue
	private long id;
	private String commentaire;
	private Date datepub;
	@ManyToOne
	@JoinColumn(name="id_enseignant")
	private User enseignant;
	@Lob
	private byte[] photo;
	private int type;
	private String concerner;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCommentaire() {
		return commentaire;
	}
	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}
	public Date getDatepub() {
		return datepub;
	}
	public void setDatepub(Date datepub) {
		this.datepub = datepub;
	}
	public User getEnseignant() {
		return enseignant;
	}
	public void setEnseignant(User enseignant) {
		this.enseignant = enseignant;
	}
	public byte[] getPhoto() {
		return photo;
	}
	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getConcerner() {
		return concerner;
	}
	public void setConcerner(String concerner) {
		this.concerner = concerner;
	}
	public Publication(String commentaire,User enseignant, byte[] photo, int type, String concerner) {
		super();
		this.commentaire = commentaire;
		this.enseignant = enseignant;
		this.photo = photo;
		this.type = type;
		this.concerner = concerner;
		this.datepub = new Date();
	}
	public Publication(String commentaire, User enseignant, int type, String concerner) {
		super();
		this.commentaire = commentaire;
		this.enseignant = enseignant;
		this.type = type;
		this.concerner = concerner;
		this.datepub = new Date();
	}
	public Publication() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
	

}
