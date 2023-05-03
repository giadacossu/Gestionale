package gestionale.pizze;

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
@RequestMapping("/pizze")
@CrossOrigin(origins = "http://localhost:4200/")
public class PizzaController {

	@Autowired PizzaService service;

	
	
	@GetMapping
	public ResponseEntity<List<Pizza>> getAllPizza(){
		return new ResponseEntity<List<Pizza>>(service.getAllPizza(),HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Pizza> getPizzaById(@PathVariable Long id){
		return new ResponseEntity <Pizza>(service.getPizzaById(id),HttpStatus.OK);
		
	}
	
	@GetMapping("/nome/{nome}")
	public ResponseEntity<Pizza> getPointByNome(@PathVariable String nome, int pagina, int dimensioniPagina){
		return  ResponseEntity.ok(service.getPizzaByNome(nome ));
		
	}
	
	@PostMapping
	public ResponseEntity <Pizza> createPizza(@RequestBody Pizza p){
		return new ResponseEntity <Pizza>(service.createPizza(p), HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity <Pizza> updatePizza(@RequestBody Pizza p){
		return new ResponseEntity <Pizza>(service.updatePizza(p),HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity <String> deletePizza(@PathVariable Long id){
		return  new ResponseEntity<String>(service.removePizza(id),HttpStatus.OK);
	}
}
