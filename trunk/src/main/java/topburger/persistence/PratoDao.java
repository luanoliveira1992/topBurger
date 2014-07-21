package topburger.persistence;

import org.springframework.stereotype.Component;

import topburger.entitys.Funcionario;
import topburger.entitys.Prato;
import topburger.entitys.TipoFuncionario;
@Component(value="pratoDao")
public class PratoDao extends AbstractTopBurgerDAO<Prato, Integer> implements IDao<Prato, Integer> {
	

}
