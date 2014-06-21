package topburger.business;

import java.util.List;

import topburger.infraestrutura.Filtro;
import topburger.infraestrutura.ObjetoPersistente;

public interface IController<T extends ObjetoPersistente<C>,C> {
	public void insert(T objeto); 
    
    public void update(T objeto);
    
    public List<T> consultarTodos();
    
    public List<T>consultarPorFiltro(Filtro filtro, String...ordenar);
    
    public void delete(T objeto);
    
    
}
