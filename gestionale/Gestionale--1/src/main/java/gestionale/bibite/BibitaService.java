package gestionale.bibite;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.persistence.EntityNotFoundException;

@Service
public class BibitaService {

	@Autowired BibitaRepository repo;
	
	public Bibita createBibita(Bibita p) {

		repo.save(p);
		System.out.println("Bibita " + p.getNome()+"  creata");
			return p;
		}
		
		public List<Bibita> getAllBibita() {
			return (List<Bibita>) repo.findAll();
		}
		
		public Bibita getBibitaById(Long id) {
			if(!repo.existsById(id)) {
				 throw new EntityNotFoundException("questa Bibita non esiste");
			}
			return repo.findById(id).get();
		}
		
		public Bibita updateBibita(Bibita p) {
			if(!repo.existsById(p.getId())) {
				 throw new EntityNotFoundException("questa Bibita  non esiste");
			}
			repo.save(p);
			return p;
		}
		
		public String removeBibita(Long id) {
			if(!repo.existsById(id)) {
				 throw new EntityNotFoundException("questa Bibita  non esiste");
			}
			repo.deleteById(id);
			return "Bibita eliminato";
		}
	
	
}
