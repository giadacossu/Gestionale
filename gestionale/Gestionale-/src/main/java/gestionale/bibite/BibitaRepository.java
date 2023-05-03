package gestionale.bibite;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BibitaRepository  extends CrudRepository <Bibita, Long>{
	public boolean existsByNome(String nome);
}
