package com.sdze.school.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sdze.school.entite.Bulletin;




public interface BulletinRepository extends JpaRepository<Bulletin, Long> {
	
	@Query("SELECT bulletin FROM Bulletin bulletin WHERE bulletin.sequence = ?1 and bulletin.classes = ?2")
	public List<Bulletin> getBulletinBySequenceAndClasses(String sequence,String Classes);
	
	@Query("SELECT bulletin FROM Bulletin bulletin WHERE bulletin.id = ?1")
	public Bulletin getBulletinById(long id);
	
	@Query("SELECT bulletin FROM Bulletin bulletin WHERE bulletin.id_eleve = ?1")
	public List<Bulletin> getBulletinStudentById(long id);

}
