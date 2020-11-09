package com.sdze.school.entite;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Bulletin {
	@Id
	@GeneratedValue
	private long id;
	private double moyenne;
	private String mention;
	private String sequence;
	private String classes;
	private String eleve;
	private long id_eleve;
	@ManyToMany
	private List<Compose> composes;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	
	
	public long getId_eleve() {
		return id_eleve;
	}
	public void setId_eleve(long id_eleve) {
		this.id_eleve = id_eleve;
	}
	public double getMoyenne() {
		return moyenne;
	}
	public void setMoyenne(double moyenne) {
		this.moyenne = moyenne;
	}
	public String getMention() {
		return mention;
	}
	public void setMention(String mention) {
		this.mention = mention;
	}
	public List<Compose> getComposes() {
		return composes;
	}
	public void setComposes(List<Compose> composes) {
		this.composes = composes;
	}
	
	
	
	public String getEleve() {
		return eleve;
	}
	public void setEleve(String eleve) {
		this.eleve = eleve;
	}
	public String getSequence() {
		return sequence;
	}
	public void setSequence(String sequence) {
		this.sequence = sequence;
	}
	public String getClasses() {
		return classes;
	}
	public void setClasses(String classes) {
		this.classes = classes;
	}
	public Bulletin() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Bulletin(List<Compose> composes) {
		super();
		this.composes = composes;
		if(composes.size()>0) {
			this.sequence = composes.get(0).getSequence();
			this.classes = composes.get(0).getStudent().getClasse();
			this.eleve = composes.get(0).getStudent().getNom();
			this.id_eleve = composes.get(0).getStudent().getId();
			
		}
		int total_c = 0;
		double total_m = 0;
		for(Compose c: composes) {
			total_c += c.getCoef();
			total_m += c.getTotal();
		}
		this.moyenne = total_m/total_c;
		
		if(this.moyenne <=5) {
			this.mention = "Nulle";
		}else if(this.moyenne >5 && this.moyenne<10) {
			this.mention = "Faible";
		}else if(this.moyenne>=10 && this.moyenne< 12) {
			this.mention = "Passable";
		}else if(this.moyenne>=12 && this.moyenne<17) {
			this.mention = "Bien";
		}else if(this.moyenne>=17 && this.moyenne<=20) {
			this.mention = "TRES bien";
		}
	}
	
	
	

}
