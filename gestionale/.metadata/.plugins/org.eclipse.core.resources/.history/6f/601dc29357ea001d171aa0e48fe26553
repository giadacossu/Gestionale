package gestionale.ingredienti;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class IngredienteRunner implements ApplicationRunner{
@Autowired IngredienteService service;
	@Override
	public void run(ApplicationArguments args) throws Exception {
		//creaLista();
			
	}
	public List<Ingrediente> creaLista(){
		List<Ingrediente> ingredienti= new ArrayList<Ingrediente>();
		ingredienti.add(creaIngrediente());
		return ingredienti;
	}
	
public  Ingrediente creaIngrediente(){
		Ingrediente i = new Ingrediente();
		i.setNome("prosciutto cotto");
		//service.createIngrediente(i);
		return i;
		
		}
}
