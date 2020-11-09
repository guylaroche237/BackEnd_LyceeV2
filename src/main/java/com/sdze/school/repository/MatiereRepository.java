package com.sdze.school.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.sdze.school.entite.Matiere;




public interface MatiereRepository extends JpaRepository<Matiere, Long> {
	
	@Query("SELECT matiere FROM Matiere matiere WHERE matiere.classes.nom = ?1")
	public List<Matiere> getMatiereByNameClasse(String name);
	
	@Transactional
	@Query("SELECT matiere FROM Matiere matiere WHERE matiere.title = ?1 AND matiere.classes.nom = ?2")
	public Matiere getMatiereByTitleAndClasse(String title,String cls);

}
