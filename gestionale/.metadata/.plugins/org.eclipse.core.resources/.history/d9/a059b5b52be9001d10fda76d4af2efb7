package gestionale.pizze;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;

@Service
public class PizzeService {
	
	@Autowired PizzeRepository repo;
	
	public Pizze createPizze(Pizze p) {

		repo.save(p);
		System.out.println("Pizza" + p.getNome()+"  creata");
			return p;
		}
		
		public List<Pizze> getAllPizze() {
			return (List<Pizze>) repo.findAll();
		}
		
		public Pizze getPizzeById(Long id) {
			if(!repo.existsById(id)) {
				 throw new EntityNotFoundException("questa Pizza non esiste");
			}
			return repo.findById(id).get();
		}
		
		public Pizze updatePizze(Pizze p) {
			if(!repo.existsById(p.getId())) {
				 throw new EntityNotFoundException("questa Pizza  non esiste");
			}
			repo.save(p);
			return p;
		}
		
		public String removePizze(Long id) {
			if(!repo.existsById(id)) {
				 throw new EntityNotFoundException("questa Pizza  non esiste");
			}
			repo.deleteById(id);
			return "Pizza eliminato";
		}
}
