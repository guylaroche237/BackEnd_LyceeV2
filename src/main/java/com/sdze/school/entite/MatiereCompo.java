package com.sdze.school.entite;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class MatiereCompo {
	@Id
	@GeneratedValue
	private long id;
	private String Classes;
	@ManyToMany
	private List<Unite> matieres;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getClasses() {
		return Classes;
	}
	public void setClasses(String classes) {
		Classes = classes;
	}
	public List<Unite> getMatieres() {
		return matieres;
	}
	public void setMatieres(List<Unite> matieres) {
		this.matieres = matieres;
	}
	public MatiereCompo(String classes, List<Unite> matieres) {
		super();
		Classes = classes;
		this.matieres = matieres;
	}
	public MatiereCompo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}
