package topburger.presentation;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.LazyDataModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import topburger.business.FuncionarioControler;
import topburger.entitys.Funcionario;
import topburger.infraestrutura.Filtro;

@Component
@Scope(WebApplicationContext.SCOPE_SESSION)
public class ManterFuncionarioMB extends AbstractMB{
	
	public Funcionario funcionario;
	public List<Funcionario> funcionarios;
	Filtro filtro;
	private LazyDataModel<Funcionario> lazyModel;
	
	@Autowired
	FuncionarioControler controler;

	@Override
	@PostConstruct
	public void inicializar() {
		
		funcionario = new Funcionario();
		funcionarios = new ArrayList<>();
		filtro = new Filtro();
		lazyModel = new FuncionarioDataModel(controler.consultarPorFiltro(filtro, "nome"));
		
}
	public Funcionario getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	
	public void consultaListagem(){
		Map<String,Object> valores = new HashMap<String,Object>();
		valores.put("%nome", funcionario.getNome());
		valores.put("tipo", funcionario.getTipo());
		valores.put("dataNascimento", funcionario.getDataNascimento());
		System.out.println(funcionario.getNome());
		filtro.setValores(valores);
		
		lazyModel = new FuncionarioDataModel(controler.consultarPorFiltro(filtro, "nome"));
	
		
		
		
	}
	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}
	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}
	
	public LazyDataModel<Funcionario> getLazyModel() {
		return lazyModel;
	}
	public void setLazyModel(LazyDataModel<Funcionario> lazyModel) {
		this.lazyModel = lazyModel;
	}
	
	

}
