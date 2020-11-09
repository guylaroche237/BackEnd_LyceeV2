package com.sdze.school.controlleur;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sdze.school.entite.MatiereCompo;
import com.sdze.school.entite.Unite;
import com.sdze.school.repository.MatiereCompoRepository;
import com.sdze.school.repository.UniteRepository;

import antlr.StringUtils;

@RestController
@RequestMapping("/api/matcp")
@CrossOrigin(origins = "http://localhost:4200")
public class MatiereCompoControlleur {
	
	@Autowired
	private MatiereCompoRepository compo;
	@Autowired
	private UniteRepository unit;
	
	@GetMapping("/all")
	public List<MatiereCompo> getCompoByClasse(){
		return compo.findAll();
		
	}
	
	@PostMapping("/save")
	public MatiereCompo saveMatiereCompo(@RequestBody MatiereCompo mat) {
		//String classes = mat.getClasses();
		//List<Unite> unites = mat.getMatieres();
		//MatiereCompo matiere = new MatiereCompo(classes, unites);
	    
		//return compo.save(matiere);
		return compo.save(mat);
	}
	
	@PostMapping("/sauve/{classes}/{listes}")
	public void saveMatiere(@PathVariable String classes,@PathVariable String listes) {
		List<Unite> liste = new ArrayList<Unite>();
		 
		String result = listes.substring(0,listes.length()-1);
		if(result.contains("@")) {
			String tab [] = result.split("@");
			for(int i=0; i<tab.length;i++) {
				//System.out.println("----------- element  ---------------:"+tab[i]);
				if(tab[i]!=null) {
					liste.add(unit.getUniteByName(tab[i]));
				}
			}
		}else {
			//System.out.println("-------  UN SEUL ELEMENT ---------"+result);
			if(result !=null) {
				liste.add(unit.getUniteByName(result));
				
			}
		
		}
		MatiereCompo cmp = new MatiereCompo(classes, liste);
		compo.save(cmp);
				
	}
	
	@GetMapping("/mat/{salle}")
	public MatiereCompo getMatiereCompo(@PathVariable String salle) {
		return compo.getMatiereCompoByName(salle);
	}

}
