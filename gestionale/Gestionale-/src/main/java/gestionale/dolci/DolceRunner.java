package gestionale.dolci;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import gestionale.prodotti.Prodotto;

@Component
public class DolceRunner implements ApplicationRunner{
@Autowired DolceService service;
	@Override
	public void run(ApplicationArguments args) throws Exception {
		// creaDolce();
		
	}
public Dolce creaDolce() {
	Dolce d = new Dolce();
	d.setNome("tiramisù");
	d.setPrezzo(4.00);
	service.createDolce(d);
	return d; 
}
}
