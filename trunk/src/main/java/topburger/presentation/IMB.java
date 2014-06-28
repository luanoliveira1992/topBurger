package topburger.presentation;

import javax.annotation.PostConstruct;


public interface IMB {
	
	@PostConstruct
	public void inicializar();
	
	public void chamaInserir(String url);
	
	public void voltar(String url);
	
	public void chamaAlterar(String url);
		
	

}
