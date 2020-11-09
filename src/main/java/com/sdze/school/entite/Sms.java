package com.sdze.school.entite;



import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Sms {
	@Id
	@GeneratedValue
	private Long id;
	private Date date;
	private String message;
	@ManyToOne
	@JoinColumn(name="id_eleve")
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
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public User getStudent() {
		return student;
	}
	public void setStudent(User student) {
		this.student = student;
	}
	public Sms() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Sms(String message, User student,Date date) {
		super();
		this.message = message;
		this.student = student;
		this.date = new Date();
		
	}
	public Sms(String message, User student) {
		super();
		this.message = message;
		this.student = student;
		
		this.date = new Date();	
		
	}
	
	

}
