package gestionale.prodotti;

import org.springframework.data.repository.CrudRepository;

import gestionale.pizze.Pizza;

public interface ProdottoRepository  extends CrudRepository<Prodotto, Long> {
	public boolean existsByNome(String nome);
	public Prodotto findByNome(String nome);
}
