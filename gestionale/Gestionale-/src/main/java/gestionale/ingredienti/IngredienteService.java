package gestionale.ingredienti;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;

@Service
public class IngredienteService {
	
	
	@Autowired IngredienteRepository repo;
	
	public Ingrediente createIngrediente(Ingrediente p) {
if(repo.existsByNome(p.getNome())) {
	throw new EntityExistsException(" ingrediete  già presente!");
}
		repo.save(p);
		System.out.println("Ingrediente " + p.getNome()+"  creata");
			return p;
		}
		
		public List<Ingrediente> getAllIngrediente() {
			return (List<Ingrediente>) repo.findAll();
		}
		
		public Ingrediente getIngredienteById(Long id) {
			if(!repo.existsById(id)) {
				 throw new EntityNotFoundException("questa Ingrediente non esiste");
			}
			return repo.findById(id).get();
		}
		
		public Ingrediente updateIngrediente(Ingrediente p) {
			if(!repo.existsById(p.getId())) {
				 throw new EntityNotFoundException("questa Ingrediente  non esiste");
			}
			repo.save(p);
			return p;
		}
		
		public String removeIngrediente(Long id) {
			if(!repo.existsById(id)) {
				 throw new EntityNotFoundException("questa Ingrediente  non esiste");
			}
			repo.deleteById(id);
			return "Ingrediente eliminato";
		}
}
