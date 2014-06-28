package topburger.presentation;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.springframework.stereotype.Service;

@Service
public abstract class AbstractMB implements IMB, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5226824695764980925L;

	@Override
	public abstract void inicializar() ;
	
	public String manterFuncionario(){
		return "listaFuncionario";
	}
	
	public String novoFuncionario(){
		return "novoFuncionario";
	}
	
	public String atualizaFuncionario(){
		return "atualizaFuncionario";
	}

	@Override
	public void chamaInserir(String url) {
		FacesContext faces = FacesContext.getCurrentInstance();  
		ExternalContext context = faces.getExternalContext();  
		try {
			context.redirect(url);
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
	}

	@Override
	public void voltar(String url) {
		FacesContext faces = FacesContext.getCurrentInstance();  
		ExternalContext context = faces.getExternalContext();  
		try {
			context.redirect(url);
		} catch (IOException e) {
		   e.printStackTrace();
		}
		
	}

	@Override
	public void chamaAlterar(String url) {
		FacesContext faces = FacesContext.getCurrentInstance();  
		ExternalContext context = faces.getExternalContext();  
		try {
			context.redirect(url);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	

}
