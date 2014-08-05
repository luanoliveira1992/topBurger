package topburger.persistence;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Component;

import topburger.entitys.Funcionario;
import topburger.entitys.Prato;
import topburger.entitys.TipoFuncionario;
import topburger.infraestrutura.Filtro;
@Component(value="pratoDao")
public class PratoDao extends AbstractTopBurgerDAO<Prato, Integer> implements IDao<Prato, Integer> {
	
	public boolean verificaNomeExistente(String nome){
		Filtro filtro = new Filtro();
		filtro.setValores(new HashMap<String,Object>());
		filtro.getValores().put("nome", nome);
		List<Prato> pratos = this.consultarPorFiltro(filtro);
		if(pratos != null && pratos.size() > 0){
			return true;
		}
		return false;
		
	}
	

}
