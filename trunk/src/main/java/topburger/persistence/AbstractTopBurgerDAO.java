package topburger.persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import topburger.infraestrutura.ObjetoPersistente;

@Repository
public abstract class AbstractTopBurgerDAO<T extends ObjetoPersistente<C>,C>  extends AbstractDao<T, C> {

	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;
	
	@Override
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
}
