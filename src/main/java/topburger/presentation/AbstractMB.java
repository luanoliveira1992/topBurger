package topburger.presentation;

import java.io.Serializable;

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
	
	

}
