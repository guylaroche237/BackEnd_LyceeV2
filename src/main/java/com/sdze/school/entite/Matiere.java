package com.sdze.school.entite;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Matiere {
	@Id
	@GeneratedValue
	private Long id;
	private String title;
	private String image;
	private String nom_matiere;
	@Lob
	private byte[] cour;
	@ManyToOne
	@JoinColumn(name="id_classe")
	//@JsonIgnore
	private Classes classes;
	
	
	
	public byte[] getCour() {
		return cour;
	}
	public void setCour(byte[] cour) {
		this.cour = cour;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom_matiere() {
		return nom_matiere;
	}
	public void setNom_matiere(String nom_matiere) {
		this.nom_matiere = nom_matiere;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
		
	}
	public Classes getClasses() {
		return classes;
	}
	public void setClasses(Classes classes) {
		this.classes = classes;
	}
	public Matiere(String nom_matiere) {
		super();
		this.nom_matiere = nom_matiere;
	}
	
	public Matiere(String title, String nom_matiere,Classes classes,byte[] cour) {
		super();
		this.title = title;
		this.nom_matiere = nom_matiere;
		this.classes = classes;
		this.cour = cour;
		
		if(this.title.equalsIgnoreCase("Math")) {
			this.image ="../../assets/matiere/mat.png";
		}else if(this.title.equalsIgnoreCase("Histoire")) {
			this.image ="../../assets/matiere/cafe.jpg";

		}else if(this.title.equalsIgnoreCase("Geographie")) {
			this.image ="../../assets/matiere/francais.jpg";
		}
		else if(this.title.equalsIgnoreCase("Histoire")) {
			this.image ="../../assets/matiere/pain.jpg";
		}
		else if(this.title.equalsIgnoreCase("informatique")) {
			this.image ="../../assets/matiere/work.jpg";
		}
		else if(this.title.equalsIgnoreCase("francais")) {
			this.image ="../../assets/matiere/francais.jpg";
		}
		else if(this.title.equalsIgnoreCase("Chimie")) {
			this.image ="../../assets/matiere/chi.jpg";
		}else if(this.title.equalsIgnoreCase("Philosophie")) {
			this.image ="../../assets/matiere/chimie1.jpg";
		}
	}
	
	public Matiere(String title, String nom_matiere,Classes classes) {
		super();
		this.title = title;
		this.nom_matiere = nom_matiere;
		this.classes = classes;
		
		
		if(this.title.equalsIgnoreCase("Math")) {
			this.image ="../../assets/matiere/mat.png";
		}else if(this.title.equalsIgnoreCase("Histoire")) {
			this.image ="../../assets/matiere/cafe.jpg";

		}else if(this.title.equalsIgnoreCase("Geographie")) {
			this.image ="../../assets/matiere/francais.jpg";
		}
		else if(this.title.equalsIgnoreCase("Histoire")) {
			this.image ="../../assets/matiere/pain.jpg";
		}
		else if(this.title.equalsIgnoreCase("informatique")) {
			this.image ="../../assets/matiere/work.jpg";
		}
		else if(this.title.equalsIgnoreCase("francais")) {
			this.image ="../../assets/matiere/francais.jpg";
		}
		else if(this.title.equalsIgnoreCase("Chimie")) {
			this.image ="../../assets/matiere/chi.jpg";
		}else if(this.title.equalsIgnoreCase("Philosophie")) {
			this.image ="../../assets/matiere/chimie1.jpg";
		}
	}
	public Matiere() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
	

}
