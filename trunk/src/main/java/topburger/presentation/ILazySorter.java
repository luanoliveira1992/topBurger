package topburger.presentation;

import topburger.infraestrutura.ObjetoPersistente;

public interface ILazySorter<T,C extends ObjetoPersistente<C>> {
	
	public int compare(T objeto1, T objeto2);

}
