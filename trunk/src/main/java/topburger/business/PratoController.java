package topburger.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import topburger.entitys.Prato;
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

}
