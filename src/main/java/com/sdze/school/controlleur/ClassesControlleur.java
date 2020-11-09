package com.sdze.school.controlleur;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sdze.school.entite.Classes;
import com.sdze.school.metier.ClassesMetier;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/classes")
public class ClassesControlleur {
	
	@Autowired
	private ClassesMetier classes;
	
	@GetMapping("/")
	public List<Classes> allClasses(){
		return classes.ListClasses();
	}
	
	@PostMapping("/save")
	public void saveClasse(@RequestBody Classes cls) {
		classes.saveClasses(cls);
	}

}
