package com.sdze.school.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sdze.school.entite.ERole;
import com.sdze.school.entite.Role;


@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	//Optional<Role> findByName(ERole name);
	Role findByName(ERole name);
}