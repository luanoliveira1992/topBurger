package topburger.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import topburger.entitys.Funcionario;
import topburger.persistence.AbstractTopBurgerDAO;
import topburger.persistence.FuncionarioDao;

@Controller
public class FuncionarioControler extends AbstractController<Funcionario,Integer> implements IFuncionarioControler <Funcionario,Integer>  {
	
	@Autowired(required=true)
	AbstractTopBurgerDAO<Funcionario, Integer> funcionarioDao;
	
	@Autowired
	FuncionarioDao dao;
	
	@Override
	public AbstractTopBurgerDAO<Funcionario, Integer> getDao() {
		return funcionarioDao;
	}
	@Override
	public void setDao(AbstractTopBurgerDAO<Funcionario, Integer> dao) {
		funcionarioDao = dao;
	}
	
	

}
