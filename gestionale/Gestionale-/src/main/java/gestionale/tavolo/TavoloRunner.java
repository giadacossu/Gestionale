package gestionale.tavolo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
@Component
public class TavoloRunner implements ApplicationRunner{
@Autowired TavoloService service;
	@Override
	public void run(ApplicationArguments args) throws Exception {
		//creaTavolo();
		
	}
public Tavolo creaTavolo() {
	Tavolo t = new Tavolo();
	t.setNumero(1);
service.createTavolo(t);
return t;
}
}
