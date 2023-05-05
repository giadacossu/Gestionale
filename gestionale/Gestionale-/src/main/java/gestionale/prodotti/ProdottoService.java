package gestionale.prodotti;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
@Service
public class ProdottoService {
 @Autowired ProdottoRepository repo;
 
 

	//////crea///////////////
	public Prodotto createProdotto(Prodotto p) {
		if(repo.existsByNome(p.getNome())) {
			 throw new EntityExistsException(" prodotto  già presente!");
		}
		repo.save(p);
	
		System.out.println("Prodotto " + p.getNome()+"  creata");
			return p;
		
	}
	
	
	
	///////////get/////////////////
		public List<Prodotto> getAllProdotto() {
			return (List<Prodotto>) repo.findAll();
		}
		
		public Prodotto getProdottoById(Long id) {
			if(!repo.existsById(id)) {
				 throw new EntityNotFoundException("questa Prodotto non esiste");
			}
			return repo.findById(id).get();
		}
		
		public Prodotto getProdottoByNome(String nome) {
			if(!repo.existsByNome(nome)) {
				System.out.println("questa Prodotto non esiste");
			}
			return repo.findByNome(nome);
		}
		
	
		
		////////////UpDate/////////////////
		public Prodotto updateProdotto(Prodotto p) {
			if(!repo.existsById(p.getId())) {
				 throw new EntityNotFoundException("questa Prodotto  non esiste");
			}
			repo.save(p);
			return p;
		}
		////////////Remove///////////////////////
		public String removeProdotto(Long id) {
			if(!repo.existsById(id)) {
				 throw new EntityNotFoundException("questa Prodotto  non esiste");
			}
			repo.deleteById(id);
			return "Prodotto eliminato";
		}
}
