package gestionale.pizze;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface PizzaRepository  extends CrudRepository <Pizza, Long>{
	public boolean existsByNome(String nome);
	public Pizza findByNome(String nome);
}
