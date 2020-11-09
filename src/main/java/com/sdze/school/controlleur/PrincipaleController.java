package com.sdze.school.controlleur;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sdze.school.entite.Classes;
import com.sdze.school.entite.Principale;
import com.sdze.school.entite.User;
import com.sdze.school.repository.ClassesRepository;
import com.sdze.school.repository.PrincipaleRepository;
import com.sdze.school.repository.UserRepository;


@RestController
@RequestMapping("/api/principale")
@CrossOrigin(origins = "http://localhost:4200")
public class PrincipaleController {
	
	@Autowired
	private PrincipaleRepository principale;
	@Autowired
	private UserRepository enseignant;
	@Autowired
	private ClassesRepository sale;
	
	@PostMapping("/save/{username}/{classes}")
	public Principale savePrincipale(@PathVariable String username,@PathVariable String classes) {
		User teacher = enseignant.findUserByUsername(username);
		Classes clas = sale.findClassesByName(classes);
		Principale prin = new Principale(teacher, clas);
		return principale.save(prin);
		
	}
	
	@GetMapping("/all")
	public List<Principale> allPrincipale(){
		return principale.findAll();
	}

}
