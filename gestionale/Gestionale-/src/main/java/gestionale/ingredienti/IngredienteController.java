package gestionale.ingredienti;

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
@RequestMapping("/Ingredienti")
@CrossOrigin(origins = "http://localhost:4200/")
public class IngredienteController {

	@Autowired IngredienteService service;
	
	@GetMapping
	public ResponseEntity<List<Ingrediente>> getAllIngrediente(){
		return new ResponseEntity<List<Ingrediente>>(service.getAllIngrediente(),HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Ingrediente> getIngredienteById(@PathVariable Long id){
		return new ResponseEntity <Ingrediente>(service.getIngredienteById(id),HttpStatus.OK);
		
	}
	
	@GetMapping("/nome/{nome}")
	public ResponseEntity<Ingrediente> getPointByNome(@PathVariable String nome, int pagina, int dimensioniPagina){
		return  ResponseEntity.ok(service.getIngredienteByNome(nome ));
		
	}
	
	@PostMapping
	public ResponseEntity <Ingrediente> createIngrediente(@RequestBody Ingrediente p){
		return new ResponseEntity <Ingrediente>(service.createIngrediente(p), HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity <Ingrediente> updateIngrediente(@RequestBody Ingrediente p){
		return new ResponseEntity <Ingrediente>(service.updateIngrediente(p),HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity <String> deleteIngrediente(@PathVariable Long id){
		return  new ResponseEntity<String>(service.removeIngrediente(id),HttpStatus.OK);
	}

	
	
}
