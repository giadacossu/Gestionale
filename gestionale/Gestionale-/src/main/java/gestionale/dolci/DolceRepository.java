package gestionale.dolci;

import org.springframework.data.repository.CrudRepository;

public interface DolceRepository  extends CrudRepository <Dolce, Long>{
	public boolean existsByNome(String nome);
}
