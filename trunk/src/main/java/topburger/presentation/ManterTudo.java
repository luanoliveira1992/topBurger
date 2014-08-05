package topburger.presentation;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Component
@Scope(WebApplicationContext.SCOPE_SESSION)
public class ManterTudo extends AbstractMB {
	
	public void mudaManterFuncionario(){
		super.chamaInserir("");
		
	}
	
   public void mudaNovoFuncionario(){
	   super.chamaInserir("");
	}

public void mudaManterProduto(){
	super.chamaInserir("");
}

@Override
public void inicializar() {
	// TODO Auto-generated method stub
	
}

}
