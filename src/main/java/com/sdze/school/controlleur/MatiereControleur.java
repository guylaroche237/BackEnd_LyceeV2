package com.sdze.school.controlleur;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.sdze.school.entite.Classes;
import com.sdze.school.entite.Matiere;
import com.sdze.school.metier.MatiereMetier;
import com.sdze.school.repository.ClassesRepository;
import com.sdze.school.repository.MatiereRepository;


@RestController
@RequestMapping("/api/matiere")
public class MatiereControleur {
	
	@Autowired
	private MatiereMetier matiere;
	@Autowired
	private ClassesRepository classerep;
	
	@Autowired
	private MatiereRepository mrep;
	
	@GetMapping("/all")
	public List<Matiere> getMatiere() {
		return matiere.getMatieres();
	}
	
	@GetMapping("/{name}")
	public List<Matiere> getMatiereByClasse(@PathVariable String name){
		List<Matiere> alls = matiere.getMatiereByclasse(name);
		List<Matiere> result = new ArrayList<Matiere>();
		for(Matiere m:alls) {
			if(m.getCour()!= null) {
				Matiere mat = new Matiere(m.getTitle(),m.getNom_matiere(),m.getClasses(),decompressZLib(m.getCour()));
				mat.setId(m.getId());
				result.add(mat);
			}
		}
		return result;
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteMatiere(@PathVariable long id) {
		matiere.deleteMatiere(id);
	}
	
	@PostMapping("/save/{titre}/{nom}/{clas}")
	public void saveMatiere(@PathVariable String titre,@PathVariable String nom,@PathVariable String clas) {
		
		Classes cls = classerep.findClassesByName(clas);
		
		Matiere m = new Matiere(titre,nom,cls);
		matiere.addMatier(m);
		
	}
	
	@PostMapping("/savecour/{titre}/{nom}/{clas}")
	public BodyBuilder saveCour(@PathVariable String titre,@PathVariable String nom,@PathVariable String clas,@RequestParam("pdfFile") MultipartFile file) throws IOException {
		Classes cls = classerep.findClassesByName(clas);
		Matiere cour = new Matiere(titre,nom,cls,compressZLib(file.getBytes()));
		System.out.println("----------------------"+cour.getCour());
		matiere.addMatier(cour);
		return ResponseEntity.status(HttpStatus.OK);
		
	}
	
	@GetMapping("/{title}/{cls}")
	public Matiere findMatiereByClasseAndTitle(@PathVariable String title,@PathVariable String cls) {
		return mrep.getMatiereByTitleAndClasse(title, cls);
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
