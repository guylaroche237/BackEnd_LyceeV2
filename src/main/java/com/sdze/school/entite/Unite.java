package com.sdze.school.entite;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Unite {
	@Id
	@GeneratedValue
	private long id;
	private String nom;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Unite(String nom) {
		super();
		this.nom = nom;
	}
	public Unite() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
