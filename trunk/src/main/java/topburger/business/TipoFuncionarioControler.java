package topburger.business;

import org.hibernate.validator.internal.util.privilegedactions.GetAnnotationParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import topburger.entitys.TipoFuncionario;
import topburger.persistence.AbstractDao;
import topburger.persistence.TipoFuncionarioDao;


@Service
@Qualifier("tipoFuncionarioControler")
public class TipoFuncionarioControler extends AbstractController<TipoFuncionario,Integer> implements ITipoFuncionarioControler  {
	
	@Autowired
	TipoFuncionarioDao tipofuncionarioDao;
	
	public TipoFuncionarioDao getTipofuncionarioDao() {
		return tipofuncionarioDao;
	}
	public void setTipofuncionarioDao(TipoFuncionarioDao tipofuncionarioDao) {
		this.tipofuncionarioDao = tipofuncionarioDao;
	}
	

}
