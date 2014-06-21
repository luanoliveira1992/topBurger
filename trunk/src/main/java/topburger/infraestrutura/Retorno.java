package topburger.infraestrutura;

import org.hibernate.Criteria;

public class Retorno {
	public <Retorno> Retorno list(Criteria criteria) {
	       return (Retorno) criteria.list();
	   }

}
