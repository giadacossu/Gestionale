package gestionale.pizze;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface PizzeRepository  extends CrudRepository <Pizze, Long>{

}
