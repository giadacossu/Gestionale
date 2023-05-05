package gestionale.ordini;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gestionale.prodotti.Prodotto;
import jakarta.persistence.EntityNotFoundException;

@Service
public class OrdineService {

	@Autowired OrdineRepository repo;
	
	//////crea/////////
	public Ordine createOrdine(Ordine p) {
		repo.save(p);
	
		System.out.println("Ordine " + p.getId()+"  creato");
			return p;
		}
		
	
	//////get/////////
		public List<Ordine> getAllOrdine() {
			return (List<Ordine>) repo.findAll();
		}
		
		public Ordine getOrdineById(Long id) {
			if(!repo.existsById(id)) {
				 throw new EntityNotFoundException("questa Ordine non esiste");
			}
			return repo.findById(id).get();
		}
		
		public double calcolaPrezzoTotale(Ordine o) {
		    double prezzoTotale = 0.0;
		    for (Prodotto prodotto : o.getListaOrdine()) {
		        prezzoTotale += prodotto.getPrezzo();
		    }
		    prezzoTotale += o.getCoperti() * o.getCostoCoperto();
		    System.out.println("il totale è "+prezzoTotale);
		    return prezzoTotale;
		}
		//////upDate/////////
		public Ordine updateOrdine(Ordine p) {
			if(!repo.existsById(p.getId())) {
				 throw new EntityNotFoundException("questa Ordine  non esiste");
			}
			repo.save(p);
			return p;
		}
		//////remove/////////
		public String removeOrdine(Long id) {
			if(!repo.existsById(id)) {
				 throw new EntityNotFoundException("questa Ordine  non esiste");
			}
			repo.deleteById(id);
			return "Ordine eliminato";
		}
}
