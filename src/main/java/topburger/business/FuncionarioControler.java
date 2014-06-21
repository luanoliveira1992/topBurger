package topburger.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import topburger.entitys.Funcionario;
import topburger.persistence.FuncionarioDao;


@Component
public class FuncionarioControler extends AbstractController<Funcionario,Integer> implements IFuncionarioControler  {
	
	@Autowired
	FuncionarioDao dao;
	
	public FuncionarioDao getDao() {
		return dao;
	}
	public void setDao(FuncionarioDao dao) {
		this.dao = dao;
	}
	
	

}
