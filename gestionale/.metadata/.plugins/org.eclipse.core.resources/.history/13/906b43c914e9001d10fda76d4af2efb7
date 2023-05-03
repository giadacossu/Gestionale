package gestionale.pizze;

import java.util.List;

import gestionale.prodotto.Prodotto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Pizze")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Pizze extends Prodotto {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String nome;
//	private List ingredienti;
	private int prezzo;
}

