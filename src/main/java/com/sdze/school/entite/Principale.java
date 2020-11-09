package com.sdze.school.entite;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Principale {
	@Id
	@GeneratedValue
	private long id;
	@ManyToOne
	@JoinColumn(name="id_enseignant")
	private User enseignant;
	@ManyToOne
	@JoinColumn(name="id_classes")
	private Classes classes;
	private String login;
	private String password;
	
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public User getEnseignant() {
		return enseignant;
	}
	public void setEnseignant(User enseignant) {
		this.enseignant = enseignant;
	}
	public Classes getClasses() {
		return classes;
	}
	public void setClasses(Classes classes) {
		this.classes = classes;
	}
	public Principale(User enseignant, Classes classes) {
		super();
		this.login = enseignant.getLogin();
		this.password = enseignant.getPassword();
		this.enseignant = enseignant;
		this.classes = classes;
	}
	public Principale() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
