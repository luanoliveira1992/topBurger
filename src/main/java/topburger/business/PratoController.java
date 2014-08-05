package topburger.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import topburger.entitys.Prato;
import topburger.infraestrutura.NegocioException;
import topburger.persistence.AbstractTopBurgerDAO;
import topburger.persistence.PratoDao;
@Controller
public class PratoController extends AbstractController<Prato,Integer> implements IPratoController {
	
	@Autowired(required=true)
	PratoDao pratoDao;

	@Override
	public AbstractTopBurgerDAO<Prato, Integer> getDao() {
		return pratoDao;
	}

	@Override
	public void setDao(AbstractTopBurgerDAO<Prato, Integer> dao) {
		this.dao = this.pratoDao;
	}

	@Override
	public void update(Prato objeto) {
		try {
			verificaNomeExistente(objeto);
		} catch (NegocioException e) {
			
			e.printStackTrace();
		}
		super.update(objeto);
	}

	public void verificaNomeExistente(Prato objeto) throws NegocioException {
		if(this.pratoDao.verificaNomeExistente(objeto.getNome())){
		     throw	new NegocioException("Nome do Prato Já Cadastrado !");
			
		}
	}
	public PratoDao getPratoDao() {
		return pratoDao;
	}
	public void setPratoDao(PratoDao pratoDao) {
		this.pratoDao = pratoDao;
	}
	
	

}
