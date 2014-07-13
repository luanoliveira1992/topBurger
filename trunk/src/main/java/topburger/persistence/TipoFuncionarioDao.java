package topburger.persistence;

import org.springframework.stereotype.Component;

import topburger.entitys.TipoFuncionario;
@Component(value="tipoFuncinarioDao")
public class TipoFuncionarioDao extends AbstractTopBurgerDAO<TipoFuncionario, Integer> implements IDao<TipoFuncionario, Integer> {

	
	AbstractDao<TipoFuncionario, Integer> dao;
	
	public AbstractDao<TipoFuncionario, Integer> getDao() {
		return dao;
	}
	public void setDao(AbstractDao<TipoFuncionario, Integer> dao) {
		this.dao = dao;
	}
}
