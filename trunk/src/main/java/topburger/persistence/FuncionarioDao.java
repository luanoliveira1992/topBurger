package topburger.persistence;

import org.springframework.stereotype.Component;

import topburger.entitys.Funcionario;
import topburger.entitys.TipoFuncionario;
@Component(value="funcionarioDao")
public class FuncionarioDao extends AbstractTopBurgerDAO<Funcionario, Integer> implements IDao<Funcionario, Integer> {
	

}
