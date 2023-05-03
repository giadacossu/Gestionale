package gestionale.ordini;

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
@RequestMapping("/ordini")
@CrossOrigin(origins = "http://localhost:4200/")
public class OrdineController {

	@Autowired OrdineService service;
	
	
	@GetMapping
	public ResponseEntity<List<Ordine>> getAllOrdine(){
		return new ResponseEntity<List<Ordine>>(service.getAllOrdine(),HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Ordine> getOrdineById(@PathVariable Long id){
		return new ResponseEntity <Ordine>(service.getOrdineById(id),HttpStatus.OK);
		
	}
	
	
	@PostMapping
	public ResponseEntity <Ordine> createOrdine(@RequestBody Ordine p){
		return new ResponseEntity <Ordine>(service.createOrdine(p), HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity <Ordine> updateOrdine(@RequestBody Ordine p){
		return new ResponseEntity <Ordine>(service.updateOrdine(p),HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity <String> deleteOrdine(@PathVariable Long id){
		return  new ResponseEntity<String>(service.removeOrdine(id),HttpStatus.OK);
	}
}
