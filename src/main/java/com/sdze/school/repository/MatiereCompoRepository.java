package com.sdze.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sdze.school.entite.MatiereCompo;




public interface MatiereCompoRepository extends JpaRepository<MatiereCompo, Long>{
	
	@Query("SELECT matcp FROM MatiereCompo matcp WHERE matcp.Classes = ?1")
	public MatiereCompo getMatiereCompoByName(String nom);
	
	

}
