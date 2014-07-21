package topburger.persistence;

import org.springframework.stereotype.Component;

import topburger.entitys.Funcionario;
import topburger.entitys.Prato;
import topburger.entitys.Produto;
import topburger.entitys.TipoFuncionario;
@Component(value="produtoDao")
public class ProdutoDao extends AbstractTopBurgerDAO<Produto, Integer> implements IDao<Produto, Integer> {
	

}
