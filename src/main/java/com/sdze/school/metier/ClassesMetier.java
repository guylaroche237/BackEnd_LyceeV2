package com.sdze.school.metier;

import java.util.List;

import com.sdze.school.entite.Classes;


public interface ClassesMetier {
	public Classes saveClasses(Classes classes);
	public void deleteClasses(Long id);
	public Classes getClasses(Long id);
	public List<Classes> ListClasses();

}
