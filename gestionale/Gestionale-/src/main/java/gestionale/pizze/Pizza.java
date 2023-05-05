package gestionale.pizze;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.ManyToAny;

import gestionale.ingredienti.Ingrediente;
import gestionale.prodotti.Prodotto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Pizze")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Pizza  extends Prodotto{

	@OneToMany(mappedBy = "nome")
	private List <Ingrediente> ingredienti = new ArrayList<Ingrediente>();

	
	public String Info() {
		return this.getNome()+ " ingredienti " + this.getIngredienti() +" prezzo: "+this.getPrezzo();
	}
}

