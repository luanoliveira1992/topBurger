package topburger.persistence;

import org.springframework.stereotype.Component;

import topburger.entitys.Funcionario;
@Component(value="funcionarioDao")
public class FuncionarioDao extends AbstractTopBurgerDAO<Funcionario, Integer> {
	

}
