package topburger.business;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import topburger.infraestrutura.Filtro;
import topburger.infraestrutura.ObjetoPersistente;
import topburger.persistence.AbstractDao;

@Repository
public abstract class AbstractController<T extends ObjetoPersistente<C>,C> implements IController<T,C> {
	
	@Autowired
	AbstractDao<T,C> dao;

	@Override
	@Transactional
	public void insert(T objeto) {
		try{
			this.dao.insert(objeto);
		}catch(RuntimeException e){
			
		}
		
	}

	@Override
	@Transactional
	public void update(T objeto) {
		this.dao.update(objeto);
		
	}

	@Override
	@Transactional()
	public List<T> consultarTodos() {
		return this.dao.consultarTodos();
	}

	@Override
	@Transactional()
	public List<T> consultarPorFiltro(Filtro filtro, String... ordenar) {
		return this.dao.consultarPorFiltro(filtro, ordenar);
		
	}

	@Override
	@Transactional()
	public void delete(T objeto) {
		this.dao.delete(objeto);
		
	}

}
