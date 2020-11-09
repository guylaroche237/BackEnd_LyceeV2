package com.sdze.school.entite;

import java.io.Serializable;
import java.security.AuthProvider;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import com.fasterxml.jackson.annotation.JsonIgnore;





@Entity
public class User implements Serializable {
	@Id
	@GeneratedValue
	private Long id;
	private String username;
	private String login;
	@Column(length=500)
	@JsonIgnore
	private String password;
	@Column(length=50)
	private String email;
	private String prenom;
	private String tel;
	@Column(length=50)
	private String adresse;
	private Date date;
	private String classe;
	@Lob
	private byte[] profil;
	
	//@ManyToMany(fetch = FetchType.LAZY)
	//@JoinTable(	name = "user_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	//private Set<Role> roles = new HashSet<>();
	
	@ManyToOne
	@JoinColumn(name="id_role")
	private Role role;
	
    @Column
    private Timestamp registerDate;
    @Column
    private Timestamp lastConnectionDate;
    @Column
    private Timestamp validationDate;
    @Column
    private boolean isOnline;
    
    @ManyToMany
	private List<Classes> classes_prof;
    
    private String matiere_prof;
    
    
     
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public List<Classes> getClasses_prof() {
		return classes_prof;
	}
	public void setClasses_prof(List<Classes> classes_prof) {
		this.classes_prof = classes_prof;
	}
	public String getMatiere_prof() {
		return matiere_prof;
	}
	public void setMatiere_prof(String matiere_prof) {
		this.matiere_prof = matiere_prof;
	}
	public Role getRoles() {
		return role;
	}
	public void setRoles(Role role) {
		this.role = role;
	}
	public boolean isOnline() {
		return isOnline;
	}
	public void setOnline(boolean isOnline) {
		this.isOnline = isOnline;
	}
	public Timestamp getValidationDate() {
		return validationDate;
	}
	public void setValidationDate(Timestamp validationDate) {
		this.validationDate = validationDate;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return username;
	}
	public void setNom(String nom) {
		this.username = nom;
	}
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getClasse() {
		return classe;
	}
	public void setClasse(String classe) {
		this.classe = classe;
	}
	public byte[] getProfil() {
		return profil;
	}
	public void setProfil(byte[] profil) {
		this.profil = profil;
	}
	
	
	public Timestamp getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(Timestamp registerDate) {
		this.registerDate = registerDate;
	}
	public Timestamp getLastConnectionDate() {
		return lastConnectionDate;
	}
	public void setLastConnectionDate(Timestamp lastConnectionDate) {
		this.lastConnectionDate = lastConnectionDate;
	}
	
	
	
	
	public User(String nom, String email,String password) {
		super();
		this.username = nom;
		this.password = password;
		this.email = email;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", login=" + login + ", password=" + password + ", email=" + email
				+ ", prenom=" + prenom + ", tel=" + tel + ", adresse=" + adresse + ", date=" + date + ", classe="
				+ classe 
				+ ", registerDate=" + registerDate
				+ ", lastConnectionDate=" + lastConnectionDate+ "]";
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
    
    


}
