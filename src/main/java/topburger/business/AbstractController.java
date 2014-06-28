package topburger.business;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import topburger.infraestrutura.Filtro;
import topburger.infraestrutura.ObjetoPersistente;
import topburger.persistence.AbstractTopBurgerDAO;

@Service("abstractController")
@Transactional(readOnly = true)
public abstract class AbstractController<T extends ObjetoPersistente<C>,C> implements IController<T,C> {

	AbstractTopBurgerDAO<T,C> dao;

	@Override
	@Transactional
	public void insert(T objeto) {
		try{
			this.getDao().insert(objeto);
		}catch(RuntimeException e){
			
		}
		
	}

	@Override
	@Transactional
	public void update(T objeto) {
		this.getDao().update(objeto);
		
	}

	@Override
	@Transactional(readOnly=true)
	public List<T> consultarTodos() {
		return this.getDao().consultarTodos();
	}

	@Override
	@Transactional(readOnly=true)
	public List<T> consultarPorFiltro(Filtro filtro, String... ordenar) {
		return this.getDao().consultarPorFiltro(filtro, ordenar);
		
	}

	@Override
	@Transactional()
	public void delete(T objeto) {
		this.getDao().delete(objeto);
		
	}
	
	public AbstractTopBurgerDAO<T, C> getDao() {
		return dao;
	}
	public void setDao(AbstractTopBurgerDAO<T, C> dao) {
		this.dao = dao;
	}

}
