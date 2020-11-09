package com.sdze.school.controlleur;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sdze.school.entite.Sms;
import com.sdze.school.entite.User;
import com.sdze.school.metier.SmsMetier;
import com.sdze.school.repository.UserRepository;



@RestController
@RequestMapping("/api/sms")
public class SmsController {
	
	@Autowired
	private SmsMetier smsmetier;
	@Autowired
	private UserRepository student;
	
	@PostMapping("/save/{message}/{id}")
	public void addSms(@PathVariable("message") String message,@PathVariable("id") Long id) {
		User stu = student.findUserById(id);
		Sms sms = new Sms(message,stu);
		smsmetier.addSms(sms);
		
	}
	@GetMapping("/all")
	public List<Sms> allSms() {
		List<Sms> alls = new ArrayList<Sms>();
		List<Sms> liste = smsmetier.allSms();
		for(Sms s: liste) {
			User stu = s.getStudent();
			if(stu.getProfil()!=null) {
				
				
			User elev = new User(stu.getNom(),stu.getEmail(),stu.getPassword());
			elev.setClasse(stu.getClasse());
			elev.setLogin(stu.getLogin());
			elev.setDate(stu.getDate());
			elev.setProfil(decompressZLib(stu.getProfil()));
			elev.setId(stu.getId());
			Sms sms = new Sms(s.getMessage(),elev);
			alls.add(sms);
			}
			}
		
		return alls;
	}
	
	public static byte[] decompressZLib(byte[] data) {
		Inflater inflater = new Inflater();
		inflater.setInput(data);
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
		byte[] buffer = new byte[1024];
		try {
			while (!inflater.finished()) {
				int count = inflater.inflate(buffer);
				outputStream.write(buffer, 0, count);
			}
			outputStream.close();
		} catch (IOException ioe) {
		} catch (DataFormatException e) {
		}
		return outputStream.toByteArray();
	}

}
