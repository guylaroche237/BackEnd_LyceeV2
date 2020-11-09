package com.sdze.school.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdze.school.entite.ERole;
import com.sdze.school.entite.User;
import com.sdze.school.metier.UserMetier;
import com.sdze.school.repository.UserRepository;

@Service
public class UserMetierImple implements UserMetier {
	
	@Autowired
	private UserRepository userRepository;

	
	public User findUserById(long id) {
		// TODO Auto-generated method stub
		return userRepository.findUserById(id);
	}

	
	public List<User> getUserByClasse(String classe) {
		// TODO Auto-generated method stub
		return userRepository.getUserByClasse(classe);
	}


	@Override
	public List<User> getUserByRole(ERole name) {
		// TODO Auto-generated method stub
		return userRepository.getUserByRole(name);
	}

}
