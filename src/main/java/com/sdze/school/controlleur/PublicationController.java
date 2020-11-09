package com.sdze.school.controlleur;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.sdze.school.entite.Publication;
import com.sdze.school.repository.PublicationRepository;
import com.sdze.school.repository.UserRepository;


@RestController
@RequestMapping("/api/publication")
@CrossOrigin(origins = "http://localhost:4200")
public class PublicationController {
	
	@Autowired
	private PublicationRepository publication;
	@Autowired
	private UserRepository enseignant;
	
	@PostMapping("/save/{comm}/{clas}/{login}/{password}/{type}")
	public Publication savePub(@PathVariable String comm,@PathVariable String clas,@PathVariable String login,@PathVariable String password,@PathVariable int type) {
		
	//	User e = enseignant.getEnseignantByLoginAndPass(login, password);
	//	Publication p = new Publication(comm,e,type,clas);
	//	return publication.save(p);		
		return null;
	}
	
	@PostMapping("/saveimg/{comm}/{clas}/{login}/{password}")
	public Publication savePubImg(@PathVariable String comm,@PathVariable String clas,@PathVariable String login,@PathVariable String password,@RequestParam("imgPub")MultipartFile file) throws IOException {
		
		//Enseignant e = enseignant.getEnseignantByLoginAndPass(login, password);
	//	Publication p = new Publication(comm,e,compressZLib(file.getBytes()),0,clas);
	//	return publication.save(p);	
		return null;
		
	}
	
	@GetMapping("/all")
	public List<Publication> allPub(){
		List<Publication> pubs = publication.findAll();
		List<Publication> alls = new ArrayList<Publication>();
		
		for(Publication p: pubs) {
			if(p.getType() == 0) {
			//	Enseignant e = new Enseignant(p.getEnseignant().getNom(), p.getEnseignant().getTel(), p.getEnseignant().getEmail(), decompressZLib(p.getEnseignant().getPhoto()),p.getEnseignant().getMatiere(),p.getEnseignant().getLogin(),p.getEnseignant().getPassword());
				
			//	Publication pub = new Publication(p.getCommentaire(),e,decompressZLib(p.getPhoto()),p.getType(),p.getConcerner());
			//    alls.add(pub);
			}else {
			//	Enseignant e = new Enseignant(p.getEnseignant().getNom(), p.getEnseignant().getTel(), p.getEnseignant().getEmail(), decompressZLib(p.getEnseignant().getPhoto()),p.getEnseignant().getMatiere(),p.getEnseignant().getLogin(),p.getEnseignant().getPassword());
				

			//	Publication pub = new Publication(p.getCommentaire(),e,p.getType(),p.getConcerner());
			//    alls.add(pub);
				
			}
		}
		return alls;
		
	}
	
	public static byte[] compressZLib(byte[] data) {
		Deflater deflater = new Deflater();
		deflater.setInput(data);
		deflater.finish();

		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
		byte[] buffer = new byte[1024];
		while (!deflater.finished()) {
			int count = deflater.deflate(buffer);
			outputStream.write(buffer, 0, count);
		}
		try {
			outputStream.close();
		} catch (IOException e) {
		}
		System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);

		return outputStream.toByteArray();
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
