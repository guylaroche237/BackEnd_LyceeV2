package com.sdze.school.metier;

import java.util.List;

import com.sdze.school.entite.Matiere;


public interface MatiereMetier {
	public Matiere addMatier(Matiere matiere);
	public void deleteMatiere(Long id);
	public Matiere getMatiere(Long id);
	public List<Matiere> getMatieres();
	public List<Matiere> getMatiereByclasse(String nom);

}
