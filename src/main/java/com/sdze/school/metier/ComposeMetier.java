package com.sdze.school.metier;

import java.util.List;

import com.sdze.school.entite.Compose;


public interface ComposeMetier {
	public Compose SaveCompose(Compose cmp);
	public void deleteCompose(Long id);
	public Compose getCompose(Long id);
	public List<Compose> getComposes();

}
