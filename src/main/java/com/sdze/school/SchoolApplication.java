package com.sdze.school;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sdze.school.entite.ERole;
import com.sdze.school.entite.Role;
import com.sdze.school.entite.Unite;
import com.sdze.school.repository.RoleRepository;
import com.sdze.school.repository.UniteRepository;


@SpringBootApplication
public class SchoolApplication implements CommandLineRunner {
	
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private UniteRepository uniterep;

	public static void main(String[] args) {
		SpringApplication.run(SchoolApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		//roleRepository.save(new Role(ERole.ROLE_ETUDIANT));
		//roleRepository.save(new Role(ERole.ROLE_ADMIN));
		//roleRepository.save(new Role(ERole.ROLE_ENSEIGNANT));
		//roleRepository.save(new Role(ERole.ROLE_PARENT));
		Unite u = new Unite("Math");Unite u1 = new Unite("Histoire");Unite u2 = new Unite("Physique");Unite u3 = new Unite("Infos");
		Unite u4 = new Unite("Chimie");Unite u5 = new Unite("Francais");Unite u6 = new Unite("Sport");Unite u7 = new Unite("EC");
		Unite u8 = new Unite("SVT");Unite u9 = new Unite("Geographie");Unite u10 = new Unite("Anglais");Unite u11 = new Unite("Allemand");
		Unite u12 = new Unite("Espagnol");Unite u13 = new Unite("Philo");
		//uniterep.save(u);uniterep.save(u1);uniterep.save(u2);uniterep.save(u3);uniterep.save(u4);uniterep.save(u5);
		//uniterep.save(u6);uniterep.save(u7);uniterep.save(u8);uniterep.save(u9);uniterep.save(u10);uniterep.save(u11);
		//uniterep.save(u12);uniterep.save(u13);
		
	}

}
