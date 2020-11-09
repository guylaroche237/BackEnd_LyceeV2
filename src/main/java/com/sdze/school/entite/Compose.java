package com.sdze.school.entite;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



@Entity
public class Compose {
	@Id
	@GeneratedValue
	private Long id;
	private Date date;
	private double note;
	private int coef;
	private double total;
	private String mention;
	private String sequence;
	@ManyToOne
	@JoinColumn(name="id_unite")
	//private Matiere matiere;
	private Unite matiere;
	public User getStudent() {
		return student;
	}
	public void setStudent(User student) {
		this.student = student;
	}

	@ManyToOne
	@JoinColumn(name="id_student")
	private User student;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public double getNote() {
		return note;
	}
	public void setNote(double note) {
		this.note = note;
	}
	public String getMention() {
		
		
		return this.mention;
	}
	public void setMention(String mention) {
		this.mention = mention;
	}
	public Unite getMatiere() {
		return matiere;
	}
	public void setMatiere(Unite matiere) {
		this.matiere = matiere;
	}
	
	public String getSequence() {
		return sequence;
	}
	public void setSequence(String sequence) {
		this.sequence = sequence;
	}
	
	
	
	public int getCoef() {
		return coef;
	}
	public void setCoef(int coef) {
		this.coef = coef;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public Compose(double note,int coef, String sequence,Unite matiere,User student) {
		super();
		this.date = new Date();
		this.note = note;
		this.sequence = sequence;
		this.matiere = matiere;
		this.student = student;
		this.coef = coef;
		this.total = note*coef;
		
		if(this.note <=5) {
			this.mention = "Nulle";
		}else if(this.note >5 && this.note<=9) {
			this.mention = "Faible";
		}else if(this.note>=10 && this.note<=12) {
			this.mention = "Passable";
		}else if(this.note>=13 && this.note<17) {
			this.mention = "Bien";
		}else if(this.note>=17 && this.note<=20) {
			this.mention = "TRES bien";
		}
	}
	
	public Compose() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
