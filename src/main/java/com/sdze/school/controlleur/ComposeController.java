package com.sdze.school.controlleur;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sdze.school.entite.Compose;
import com.sdze.school.entite.Unite;
import com.sdze.school.entite.User;
import com.sdze.school.repository.ComposeResitory;
import com.sdze.school.repository.MatiereRepository;
import com.sdze.school.repository.UniteRepository;
import com.sdze.school.repository.UserRepository;


@RestController
@RequestMapping("/api/compo")
public class ComposeController {
	
	@Autowired
	private ComposeResitory compose;
	@Autowired
	private MatiereRepository mat;
	
	@Autowired
	private UserRepository stu;
	@Autowired
	private UniteRepository unite;
	
	
	
	@GetMapping("/seq/{id}/{seq}")
	public List<Compose> findCompoStudentBySequence(@PathVariable long id,@PathVariable String seq){
		return compose.allCompoStudentBySequence(id, seq);
	}
	
	@GetMapping("/matiere/{id}/{mat}")
	public List<Compose> findCompoStudentByMatiere(@PathVariable long id,@PathVariable String mat){
		return compose.allCompoStudentByMatiere(id,mat);
	}
	
	@GetMapping("/all/student/{id}")
	public List<Compose> findCompoStudent(@PathVariable long id){
		return compose.allCompoStudent(id);
	}
	
	@GetMapping("/all")
	public List<Compose> findallCompo(){
		return compose.findAll();
	}
	
	@Transactional
	@PostMapping("/save/{note}/{seq}/{title}/{classes}/{stu}/{coef}")
	public boolean saveCompo(@PathVariable double note,@PathVariable String seq,@PathVariable String title,@PathVariable String classes,@PathVariable String stu,@PathVariable int coef) {
		//Matiere matiere  = this.mat.getMatiereByTitleAndClasse(title, classes);
		boolean rep = false;
		Unite matiere  = unite.getUniteByName(title);
		User student = this.stu.getStudentByNameAndClasse(stu, classes);
		Compose compo = new Compose(note,coef, seq, matiere, student);
		for(Compose c: compose.findAll()) {
			if(compo.getStudent().getNom().equals(c.getStudent().getNom()) && compo.getSequence().equals(c.getSequence()) && compo.getMatiere().getNom().equals(c.getMatiere().getNom())) {
				rep = true;
			}
		}
		
		if(rep==false) {
			compose.save(compo);
		}
		
		return rep;
		
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteComposition(@PathVariable Long id) {
		compose.deleteById(id);
	}
	
	

}
