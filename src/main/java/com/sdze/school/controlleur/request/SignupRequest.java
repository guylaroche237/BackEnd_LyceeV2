package com.sdze.school.controlleur.request;

public class SignupRequest {
	public String username;
	public String email;
	public String password;
	public String comfirmpassword;
	public String role;
	public String classe;
	public String matiere;
	
	
	
	
	
	public String getMatiere() {
		return matiere;
	}
	public void setMatiere(String matiere) {
		this.matiere = matiere;
	}
	public String getClasse() {
		return classe;
	}
	public void setClasse(String classe) {
		this.classe = classe;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getComfirmpassword() {
		return comfirmpassword;
	}
	public void setComfirmpassword(String comfirmpassword) {
		this.comfirmpassword = comfirmpassword;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public SignupRequest(String username, String email, String password,String comfirmpassword) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.comfirmpassword = comfirmpassword;
	}
	
	
	public SignupRequest(String username, String email, String password, String comfirmpassword,String role,String classe) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.comfirmpassword = comfirmpassword;
		this.role = role;
		this.classe = classe;
	}
	
	
	public SignupRequest() {
		super();
	}
	
	

}
