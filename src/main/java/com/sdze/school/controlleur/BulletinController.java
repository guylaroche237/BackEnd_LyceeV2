package com.sdze.school.controlleur;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sdze.school.entite.Bulletin;
import com.sdze.school.entite.Compose;
import com.sdze.school.repository.BulletinRepository;


@RestController
@RequestMapping("/api/bulletin")
@CrossOrigin(origins = "http://localhost:4200")
public class BulletinController {
	
	@Autowired
	private BulletinRepository bulletin;
	
	@PostMapping("/save")
	public boolean saveBulletin(@RequestBody List<Compose> compos) {
		String seq = "",clas="";
		boolean rep = false;
		if(compos != null) {
			seq = compos.get(0).getSequence();
			clas = compos.get(0).getStudent().getClasse();
		}
		Bulletin bull = new Bulletin(compos);
		for(Bulletin b : bulletin.getBulletinBySequenceAndClasses(seq, clas)) {
			if(b.getEleve().equals(bull.getEleve()) && b.getSequence().equals(bull.getSequence())&& b.getClasses().equals(bull.getClasses())) {
				rep = true;
			}
		}
		
		if(rep == false) { bulletin.save(bull);}
		
		return rep;
		
	}
	
	@GetMapping("/all")
	public List<Bulletin> getAllBulletin(){
		return bulletin.findAll();
	}
	
	@GetMapping("/get/{seq}/{cls}")
	public List<Bulletin> getBulletinBySeqAndClasse(@PathVariable String seq,@PathVariable String cls){
		return bulletin.getBulletinBySequenceAndClasses(seq, cls);
		
	}
	
	@GetMapping("/id/{id}")
	public Bulletin getBulletinById(@PathVariable long id) {
		return bulletin.getBulletinById(id);
	}
	
	@GetMapping("/id/student/{id}")
	public List<Bulletin> getBulletinStudentById(@PathVariable long id) {
		return bulletin.getBulletinStudentById(id);
	}

}
