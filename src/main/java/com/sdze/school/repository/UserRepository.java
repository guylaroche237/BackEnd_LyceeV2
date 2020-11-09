package com.sdze.school.repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sdze.school.entite.ERole;
import com.sdze.school.entite.User;



@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	Optional<User> findByUsername(String username);
	
	User findUserByUsername(String username);

	Boolean existsByUsername(String username);

	Boolean existsByEmail(String email);
	
	User findUserById(long id);
	
	//List<User> findUserByClas(String classe);
	
	@Query("SELECT student FROM User student WHERE student.classe = ?1")
	public List<User> getUserByClasse(String classes);
	
	@Query("SELECT student FROM User student WHERE student.username = ?1 AND student.classe = ?2")
	public User getStudentByNameAndClasse(String username,String classes);
	
	@Query("SELECT user FROM User user WHERE user.role.name = ?1")
	public List<User> getUserByRole(ERole name);
	
	
	
	
}