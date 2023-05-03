package gestionale.ordini;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import jakarta.persistence.EntityNotFoundException;

@Service
public class OrdineService {

	@Autowired OrdineRepository repo;
	
	
	public Ordine createOrdine(Ordine p) {
		repo.save(p);
	
		System.out.println("Ordine " + p.getId()+"  creato");
			return p;
		}
		
		public List<Ordine> getAllOrdine() {
			return (List<Ordine>) repo.findAll();
		}
		
		public Ordine getOrdineById(Long id) {
			if(!repo.existsById(id)) {
				 throw new EntityNotFoundException("questa Ordine non esiste");
			}
			return repo.findById(id).get();
		}
		
		public Ordine updateOrdine(Ordine p) {
			if(!repo.existsById(p.getId())) {
				 throw new EntityNotFoundException("questa Ordine  non esiste");
			}
			repo.save(p);
			return p;
		}
		
		public String removeOrdine(Long id) {
			if(!repo.existsById(id)) {
				 throw new EntityNotFoundException("questa Ordine  non esiste");
			}
			repo.deleteById(id);
			return "Ordine eliminato";
		}
}
