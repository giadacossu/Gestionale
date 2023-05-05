package gestionale.ordini;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import gestionale.pizze.PizzaService;
import gestionale.prodotti.Prodotto;
import gestionale.prodotti.ProdottoService;
import gestionale.tavolo.TavoloService;

@Component
public class OrdineRunner implements ApplicationRunner {
	@Autowired
	ProdottoService serviceP;
	@Autowired
	OrdineService service;
	@Autowired TavoloService t;

	@Override
	public void run(ApplicationArguments args) throws Exception {
	 //creaOrdine();
	// creaLista();
	}

	public Ordine creaOrdine() {
		Ordine o = new Ordine();
		o.setCoperti(4);
	//	o.setTavolo(t.getTavoloByNumero());
		o.setListaOrdine(creaLista());
		
		service.createOrdine(o);
		service.calcolaPrezzoTotale(o);
		return o;
	}

	public List<Prodotto> creaLista() {
		List<Prodotto> o = new ArrayList<Prodotto>();
		o.add(serviceP.getProdottoByNome("margherita"));
		o.add(serviceP.getProdottoByNome("Fanta"));
		System.out.println(o.size());
		return o;
	}
}
