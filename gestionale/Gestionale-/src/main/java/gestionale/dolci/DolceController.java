package gestionale.dolci;

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
@RequestMapping("/dolci")
@CrossOrigin(origins = "http://localhost:4200/")
public class DolceController {

	@Autowired DolceService service;
	
	@GetMapping
	public ResponseEntity<List<Dolce>> getAllDolce(){
		return new ResponseEntity<List<Dolce>>(service.getAllDolce(),HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Dolce> getDolceById(@PathVariable Long id){
		return new ResponseEntity <Dolce>(service.getDolceById(id),HttpStatus.OK);
		
	}
	
	@GetMapping("/nome/{nome}")
	public ResponseEntity<Dolce> getPointByNome(@PathVariable String nome, int pagina, int dimensioniPagina){
		return  ResponseEntity.ok(service.getDolceByNome(nome ));
		
	}
	
	@PostMapping
	public ResponseEntity <Dolce> createDolce(@RequestBody Dolce p){
		return new ResponseEntity <Dolce>(service.createDolce(p), HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity <Dolce> updateDolce(@RequestBody Dolce p){
		return new ResponseEntity <Dolce>(service.updateDolce(p),HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity <String> deleteDolce(@PathVariable Long id){
		return  new ResponseEntity<String>(service.removeDolce(id),HttpStatus.OK);
	}
	
}
