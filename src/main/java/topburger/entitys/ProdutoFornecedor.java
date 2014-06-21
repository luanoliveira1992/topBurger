package topburger.entitys;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import topburger.infraestrutura.ObjetoPersistente;

@Entity
@Table(name="tbprodutofornecedor")
public class ProdutoFornecedor implements ObjetoPersistente<Integer> {
	 
	@EmbeddedId 
	 ProdutoFornecedorChave id;
	
	@Override
	public Integer getCodigo() {
		return null;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProdutoFornecedor other = (ProdutoFornecedor) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	

}
