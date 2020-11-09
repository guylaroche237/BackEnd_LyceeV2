package com.sdze.school.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.sdze.school.entite.Compose;
import com.sdze.school.metier.ComposeMetier;
import com.sdze.school.repository.ComposeResitory;



public class ComposeService implements ComposeMetier {

	@Autowired
	private ComposeResitory comp;
	@Override
	public Compose SaveCompose(Compose cmp) {
		// TODO Auto-generated method stub
		return comp.save(cmp);
	}

	@Override
	public void deleteCompose(Long id) {
		// TODO Auto-generated method stub
		comp.deleteById(id);
	}

	@Override
	public Compose getCompose(Long id) {
		// TODO Auto-generated method stub
		return comp.getOne(id);
	}

	@Override
	public List<Compose> getComposes() {
		// TODO Auto-generated method stub
		return comp.findAll();
	}

}
