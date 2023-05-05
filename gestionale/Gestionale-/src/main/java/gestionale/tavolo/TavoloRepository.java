package gestionale.tavolo;

import org.springframework.data.repository.CrudRepository;



public interface TavoloRepository  extends CrudRepository <Tavolo, Long>{
	public boolean existsByNumero(int numero);
	public Tavolo findByNumero(int numero);
}
