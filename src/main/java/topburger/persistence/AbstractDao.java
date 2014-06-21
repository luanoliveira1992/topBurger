package topburger.persistence;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map.Entry;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.TransactionRequiredException;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import topburger.entitys.Funcionario;
import topburger.infraestrutura.Filtro;
import topburger.infraestrutura.ObjetoPersistente;

@Repository
public abstract class AbstractDao<T extends ObjetoPersistente<C>,C> implements IDao<T,C> {
	private @PersistenceUnit EntityManagerFactory factory;
	private @PersistenceContext EntityManager manager;
	private Class objectClass;
	
	public AbstractDao(){
		super();
		this.objectClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	@Override
	public void insert(T objeto) {
		try{
			this.manager.persist(objeto);
			
		}catch(IllegalArgumentException e){
			
		}
		
	}

	@Override
	public void update(T objeto) {
		try{
		this.manager.merge(objeto);
		}catch(TransactionRequiredException  e){
			
		}
	}

	@Override
	public List<T> consultarTodos() {
		Session session = (Session) this.manager.getDelegate();
		Criteria criteria = session.createCriteria(objectClass);
		return criteria.list();
	}

	@Override
	public List<T> consultarPorFiltro(Filtro filtro,String...ordenar) {
		Session session = (Session) this.manager.getDelegate();
		Criteria criteria = session.createCriteria(objectClass);
		
		for(Entry<String, Object> entry:  filtro.getValores().entrySet()){
			if(entry.getValue() != null){
				if(entry.getKey().startsWith("%")){
					System.out.println(entry.getKey().substring(1, 5));
					criteria.add(Restrictions.like(entry.getKey().substring(1, 5),"%"+entry.getValue()+"%"));
				}
				else{
					criteria.add(Restrictions.eq(entry.getKey(), entry.getValue()));
				}
				
				
			}
			
		}
		for(String elementoOrdem : ordenar){
			criteria.addOrder(Order.asc(elementoOrdem) );
		}
		
		
		return (List<T>) criteria.list();
		
	 }
    
	@Override
	public void delete(T objeto) {
		try{
			this.manager.remove(objeto);
		}catch(IllegalArgumentException e){
			
		}
		
	}

	@Override
	public Class<T> getObjectClass() {
		// TODO Auto-generated method stub
		return objectClass;
	}

}
