package gestionale.bibite;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/bibite")
@CrossOrigin(origins = "http://localhost:4200/")
public class BibiteController {

	
	@Autowired BibitaService service;
	
	@GetMapping
	public ResponseEntity<List<Bibita>> getAllBibita(){
		return new ResponseEntity<List<Bibita>>(service.getAllBibita(),HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Bibita> getBibitaById(@PathVariable Long id){
		return new ResponseEntity <Bibita>(service.getBibitaById(id),HttpStatus.OK);
		
	}
	
	@GetMapping("/nome/{nome}")
	public ResponseEntity<Bibita> getPointByNome(@PathVariable String nome, int pagina, int dimensioniPagina){
		return  ResponseEntity.ok(service.getBibitaByNome(nome ));
		
	}
	
	@PostMapping
	public ResponseEntity <Bibita> createBibita(@RequestBody Bibita p){
		return new ResponseEntity <Bibita>(service.createBibita(p), HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity <Bibita> updateBibita(@RequestBody Bibita p){
		return new ResponseEntity <Bibita>(service.updateBibita(p),HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity <String> deleteBibita(@PathVariable Long id){
		return  new ResponseEntity<String>(service.removeBibita(id),HttpStatus.OK);
	}
}
