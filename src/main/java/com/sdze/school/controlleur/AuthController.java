package com.sdze.school.controlleur;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sdze.school.controlleur.request.LoginRequest;
import com.sdze.school.controlleur.request.SignupRequest;
import com.sdze.school.controlleur.response.JwtResponse;
import com.sdze.school.controlleur.response.MessageResponse;
import com.sdze.school.entite.ERole;
import com.sdze.school.entite.Role;
import com.sdze.school.entite.User;
import com.sdze.school.metier.UserMetier;
import com.sdze.school.repository.RoleRepository;
import com.sdze.school.repository.UserRepository;
import com.sdze.school.security.JwtUtils;
import com.sdze.school.service.UserDetailsImpl;




@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtUtils jwtUtils;
	
	@Autowired
	UserMetier userMetier;

	@PostMapping("/login")
	public ResponseEntity<JwtResponse> authenticateUser(@RequestBody LoginRequest loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);
		
		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();		
		List<String> roles = userDetails.getAuthorities().stream()
				.map(item -> item.getAuthority())
				.collect(Collectors.toList());

		return ResponseEntity.ok(new JwtResponse(jwt, 
												 userDetails.getId(), 
												 userDetails.getUsername(), 
												 userDetails.getEmail(), 
												 roles));
	}

	@PostMapping("/register")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
		
		if (userRepository.existsByUsername(signUpRequest.getUsername())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Username is already taken!"));
		}
		

		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Email is already in use!"));
		}
		
		Role mon_role = null;
		
		if(signUpRequest.getRole().equalsIgnoreCase("ADMIN")) {
			mon_role = roleRepository.findByName(ERole.ROLE_ADMIN);
		}else if(signUpRequest.getRole().equalsIgnoreCase("ENSEIGNANT")) {
			mon_role = roleRepository.findByName(ERole.ROLE_ENSEIGNANT);
		}else if(signUpRequest.getRole().equalsIgnoreCase("PARENT")) {
			mon_role = roleRepository.findByName(ERole.ROLE_PARENT);
		}else {
			mon_role = roleRepository.findByName(ERole.ROLE_ETUDIANT);
			
		}
		
	
		
		User user = new User(signUpRequest.getUsername(), 
							 signUpRequest.getEmail(),
							 encoder.encode(signUpRequest.getPassword()));
		if(signUpRequest.getRole().equalsIgnoreCase("ETUDIANT")) {
			user.setClasse(signUpRequest.getClasse());
		}
		if(signUpRequest.getRole().equalsIgnoreCase("ENSEIGNANT")) {
			System.out.println("--------------------matiere prefere de l enseignant --------------");
			user.setMatiere_prof(signUpRequest.getMatiere());
			System.out.println(signUpRequest.getMatiere());
		}
		
		user.setRegisterDate(Timestamp.from(Instant.now()));

		//Set<Role> strRoles = user.getRoles();
		
		
		//Set<Role> roles = new HashSet<>();
		

		//if (mon_role == null) {
			//Role userRole = ((Object) roleRepository.findByName(ERole.ROLE_ETUDIANT)).orElseThrow(() -> new RuntimeException("Error: Role is not found."));
			//roles.add(userRole);
			
	//	}else{
			//strRoles.forEach(role -> {Role adminRole = roleRepository.findByName(role.getName()).orElseThrow(() -> new RuntimeException("Error: Role is not found."));roles.add(adminRole);
			//Role userRole = roleRepository.findByName(strRoles.getName());
			
	//	}

		user.setRoles(mon_role);
		userRepository.save(user);

		return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
	}
	
	@GetMapping("/users")
	public ResponseEntity<?> allUsers(){
		return ResponseEntity.ok(userRepository.findAll());
	}
	
	@GetMapping("/users/profs")
	public ResponseEntity<?> allProf(){
		List<User> all = userRepository.findAll();
		List<User> tmp = new ArrayList<User>();
		for(User u:all) {
			if(u.getRole().getName().equals(ERole.ROLE_ENSEIGNANT)) {tmp.add(u);}
		}
		return ResponseEntity.ok(tmp);
	}
	@GetMapping("/user/id/{id}")
	public ResponseEntity<?> getUserById(@PathVariable long id){
		return ResponseEntity.ok(userMetier.findUserById(id));	
	}
	
	@GetMapping("/users/role/{name}")
	public ResponseEntity<?> findUserByRole(@PathVariable ERole name){
		return ResponseEntity.ok(userMetier.getUserByRole(name));
	}
}