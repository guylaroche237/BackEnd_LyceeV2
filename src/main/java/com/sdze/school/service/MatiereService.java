package com.sdze.school.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdze.school.entite.Matiere;
import com.sdze.school.metier.MatiereMetier;
import com.sdze.school.repository.MatiereRepository;



@Service
public class MatiereService implements MatiereMetier{
	
	@Autowired
	private MatiereRepository mat;

	@Override
	public Matiere addMatier(Matiere matiere) {
		// TODO Auto-generated method stub
		
		return mat.save(matiere);
	}

	@Override
	public void deleteMatiere(Long id) {
		// TODO Auto-generated method stub
		mat.deleteById(id);
	}

	@Override
	public Matiere getMatiere(Long id) {
		// TODO Auto-generated method stub
		return mat.getOne(id);
	}

	@Override
	public List<Matiere> getMatieres() {
		// TODO Auto-generated method stub
		return mat.findAll();
	}

	@Override
	public List<Matiere> getMatiereByclasse(String nom) {
		// TODO Auto-generated method stub
		return mat.getMatiereByNameClasse(nom);
	}

}
