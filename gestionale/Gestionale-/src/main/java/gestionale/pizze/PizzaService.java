package gestionale.pizze;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;

@Service
public class PizzaService {
	
	@Autowired PizzaRepository repo;
	
	public Pizza createPizza(Pizza p) {
		if(repo.existsByNome(p.getNome()))
		repo.save(p);
	
		System.out.println("Pizza " + p.getNome()+"  creata");
			return p;
		}
		
		public List<Pizza> getAllPizza() {
			return (List<Pizza>) repo.findAll();
		}
		
		public Pizza getPizzaById(Long id) {
			if(!repo.existsById(id)) {
				 throw new EntityNotFoundException("questa Pizza non esiste");
			}
			return repo.findById(id).get();
		}
		
		public Pizza updatePizza(Pizza p) {
			if(!repo.existsById(p.getId())) {
				 throw new EntityNotFoundException("questa Pizza  non esiste");
			}
			repo.save(p);
			return p;
		}
		
		public String removePizza(Long id) {
			if(!repo.existsById(id)) {
				 throw new EntityNotFoundException("questa Pizza  non esiste");
			}
			repo.deleteById(id);
			return "Pizza eliminato";
		}
}
