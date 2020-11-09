package com.sdze.school.controlleur;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sdze.school.entite.Unite;
import com.sdze.school.repository.UniteRepository;



@RestController
@RequestMapping("/api/unite")
@CrossOrigin(origins = "http://localhost:4200")
public class UniteController {
	
	@Autowired
	private UniteRepository unit;
	
	@GetMapping("/all")
	public List<Unite> allUnite(){
		return unit.findAll();
		
	}
	
	@GetMapping("/name/{nom}")
	public Unite getUnite(@PathVariable String nom) {
		return unit.getUniteByName(nom);
	}

}
