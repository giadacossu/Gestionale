package gestionale.dolci;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gestionale.ingredienti.Ingrediente;
import jakarta.persistence.EntityNotFoundException;

@Service
public class DolceService {

	@Autowired
	DolceRepository repo;

	/////// crea/////////////////////////////
	public Dolce createDolce(Dolce p) {
		if (repo.existsByNome(p.getNome()))
			repo.save(p);
		System.out.println("Dolce " + p.getNome() + "  creata");
		return p;
	}

   ///////get/////////////////////////////
	public List<Dolce> getAllDolce() {
		return (List<Dolce>) repo.findAll();
	}

	
	public Dolce getDolceById(Long id) {
		if (!repo.existsById(id)) {
			throw new EntityNotFoundException("questa Dolce non esiste");
		}
		return repo.findById(id).get();
	}
	
	public Dolce getDolceByNome(String nome) {
		if(!repo.existsByNome(nome)) {
			System.out.println("questo Dolce non esiste");
		}
		return repo.findByNome(nome);
	}
   ///////upDate/////////////////////////////
	public Dolce updateDolce(Dolce p) {
		if (!repo.existsById(p.getId())) {
			throw new EntityNotFoundException("questa Dolce  non esiste");
		}
		repo.save(p);
		return p;
	}
///////remove/////////////////////////////
	public String removeDolce(Long id) {
		if (!repo.existsById(id)) {
			throw new EntityNotFoundException("questa Dolce  non esiste");
		}
		repo.deleteById(id);
		return "Dolce eliminato";
	}
}
