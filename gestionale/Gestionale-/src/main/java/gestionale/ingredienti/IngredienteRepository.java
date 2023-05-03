package gestionale.ingredienti;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredienteRepository  extends CrudRepository <Ingrediente, Long>{
public boolean existsByNome(String nome);
public Ingrediente findByNome(String nome);
}
