package com.sdze.school.metier;

import java.util.List;

import com.sdze.school.entite.ERole;
import com.sdze.school.entite.User;


public interface UserMetier {
	
	User findUserById(long id);
	List<User> getUserByClasse(String classe);
	List<User> getUserByRole(ERole name);

}
