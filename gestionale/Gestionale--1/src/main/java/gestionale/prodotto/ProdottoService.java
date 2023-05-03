package gestionale.prodotto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ProdottoService {

	@Autowired ProdottoRepository repo;

	public Prodotto createProdotto(Prodotto p) {

		repo.save(p);
		System.out.println("Prodotto  creato");
			return p;
		}
		
		public List<Prodotto> getAllProdotto() {
			return (List<Prodotto>) repo.findAll();
		}
		
		public Prodotto getProdottoById(Long id) {
			if(!repo.existsById(id)) {
				 throw new EntityNotFoundException("questo Prodotto non esiste");
			}
			return repo.findById(id).get();
		}
		
		public Prodotto updateProdotto(Prodotto p) {
			if(!repo.existsById(p.getId())) {
				 throw new EntityNotFoundException("questo Prodotto non esiste");
			}
			repo.save(p);
			return p;
		}
		
		public String removeProdotto(Long id) {
			if(!repo.existsById(id)) {
				 throw new EntityNotFoundException("questo Prodotto non esiste");
			}
			repo.deleteById(id);
			return "Prodotto eliminato";
		}
}
