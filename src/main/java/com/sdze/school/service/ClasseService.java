package com.sdze.school.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdze.school.entite.Classes;
import com.sdze.school.metier.ClassesMetier;
import com.sdze.school.repository.ClassesRepository;


@Service
public class ClasseService implements ClassesMetier{

	@Autowired
	private ClassesRepository cls;
	@Override
	public Classes saveClasses(Classes classes) {
		// TODO Auto-generated method stub
		return cls.save(classes);
	}

	@Override
	public void deleteClasses(Long id) {
		// TODO Auto-generated method stub
		cls.deleteById(id);
	}

	@Override
	public Classes getClasses(Long id) {
		// TODO Auto-generated method stub
		return cls.getOne(id);
	}

	@Override
	public List<Classes> ListClasses() {
		// TODO Auto-generated method stub
		return cls.findAll();
	}

}
