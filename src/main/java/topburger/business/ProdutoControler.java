package topburger.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import topburger.entitys.Produto;
import topburger.persistence.AbstractTopBurgerDAO;
import topburger.persistence.ProdutoDao;

@Controller
public class ProdutoControler extends AbstractController<Produto,Integer> implements IProdutoControler  {
	
	public ProdutoDao getProdutoDao() {
		return produtoDao;
	}

	public void setProdutoDao(ProdutoDao produtoDao) {
		this.produtoDao = produtoDao;
	}

	@Autowired(required=true)
	ProdutoDao produtoDao;

	@Override
	public AbstractTopBurgerDAO<Produto, Integer> getDao() {
		return produtoDao;
	}

	@Override
	public void setDao(AbstractTopBurgerDAO<Produto, Integer> dao) {
		this.dao = this.produtoDao;
	}
	
	

	
	
	
	
	
	
	

}
