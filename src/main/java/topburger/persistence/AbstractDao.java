package topburger.persistence;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map.Entry;

import javax.persistence.TransactionRequiredException;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.metadata.ClassMetadata;

import topburger.infraestrutura.Filtro;
import topburger.infraestrutura.ObjetoPersistente;


public abstract class AbstractDao<T extends ObjetoPersistente<C>,C> implements IDao<T,C> {
	private Class objectClass;
	
	
	public SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	public AbstractDao(){
		this.objectClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	public Session getSession(){
		return this.sessionFactory.getCurrentSession();
	}
	
	@Override
	public void insert(T objeto) {
		try{
			this.getSession().persist(objeto);
			
		}catch(IllegalArgumentException e){
			
		}
		
	}

	@Override
    public void update(T objeto) {
		try{
		this.getSession().merge(objeto);
		}catch(TransactionRequiredException  e){
			
		}
	}

	@Override
	public List<T> consultarTodos() {
		Criteria criteria = getSession().createCriteria(objectClass);
		return criteria.list();
	}

	@Override
	public List<T> consultarPorFiltro(Filtro filtro,String...ordenar) {
		
		Criteria criteria = getSession().createCriteria(objectClass);
		
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
			this.getSession().delete(objeto);
		}catch(IllegalArgumentException e){
			
		}
		
	}

	@Override
	public Class<T> getObjectClass() {
				return objectClass;
	}
	
	
	@Override
	public T buscaPorChave(C chave) {
		//ClassMetadata metaData = sessionFactory.getClassMetadata(this.getObjectClass());
		Criteria criteria = getSession().createCriteria(objectClass);
		criteria.add(Restrictions.eq("codigo", chave));
		return (T) criteria.uniqueResult();
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	

}
