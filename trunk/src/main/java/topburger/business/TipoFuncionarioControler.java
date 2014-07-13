package topburger.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import topburger.entitys.Funcionario;
import topburger.entitys.TipoFuncionario;
import topburger.persistence.AbstractTopBurgerDAO;
import topburger.persistence.TipoFuncionarioDao;


@Service
@Qualifier("tipoFuncionarioControler")
public class TipoFuncionarioControler extends AbstractController<TipoFuncionario,Integer> implements ITipoFuncionarioControler {
	
	@Autowired(required=true)
	TipoFuncionarioDao  tipofuncionarioDao;

	@Override
	public AbstractTopBurgerDAO<TipoFuncionario, Integer> getDao() {
		return tipofuncionarioDao;
	}

	@Override
	public void setDao(AbstractTopBurgerDAO<TipoFuncionario, Integer> dao) {
		this.dao = this.tipofuncionarioDao;
	}
	
	
	
	
	

}
