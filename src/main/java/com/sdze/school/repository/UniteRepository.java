package com.sdze.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sdze.school.entite.Unite;



public interface UniteRepository extends JpaRepository<Unite, Long> {
	
	@Query("SELECT unite FROM Unite unite WHERE unite.nom = ?1")
	public Unite getUniteByName(String nom);

}
