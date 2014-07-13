package topburger.presentation;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

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
		redirectPaginas(url);

		
	}

	@Override
	public void voltar(String url) {
		redirectPaginas(url);
		
	}

	private void redirectPaginas(String url) {
		FacesContext faces = FacesContext.getCurrentInstance();  
		ExternalContext context = faces.getExternalContext();
		HttpServletRequest request = 
				(HttpServletRequest)FacesContext
					.getCurrentInstance()
						.getExternalContext()
							.getRequest();
		String contextPath = request.getContextPath(); 
		try {
			context.redirect(contextPath+"/faces"+url);
		} catch (IOException e) {
		   e.printStackTrace();
		}
	}

	@Override
	public void chamaAlterar(String url) {
		redirectPaginas(url);

		
	}
	
	public void adcionaMensagemSucesso(String mensagem){
		FacesContext.getCurrentInstance().addMessage("messages", new FacesMessage(FacesMessage.SEVERITY_INFO, "Informação:", mensagem));
	}
	
	public void adcionaMensagemErro(String mensagem){
		FacesContext.getCurrentInstance().addMessage("messages", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro:", mensagem));
	}
	
	public void adcionaMensagemAlerta(String mensagem){
		FacesContext.getCurrentInstance().addMessage("messages", new FacesMessage(FacesMessage.SEVERITY_WARN, "Alerta:", mensagem));
	}
	
	
	
	

}
