package topburger.presentation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedProperty;

import org.primefaces.model.LazyDataModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import topburger.business.FuncionarioControler;
import topburger.business.IController;
import topburger.business.IFuncionarioControler;
import topburger.business.TipoFuncionarioControler;
import topburger.entitys.Funcionario;
import topburger.entitys.TipoFuncionario;
import topburger.infraestrutura.Filtro;

@Component
@Scope(WebApplicationContext.SCOPE_SESSION)
public class ManterFuncionarioMB extends AbstractMB{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8236724572320706435L;
	public Funcionario funcionario;
	public List<Funcionario> funcionarios;
	public List<TipoFuncionario> listaTipo;
	Filtro filtro;
	private LazyDataModel<Funcionario> lazyModel;
	
	@Autowired
	IFuncionarioControler controler;
	
	
	
	IController<TipoFuncionario, Integer> tipoFuncionarioControler;
	
	

	@Override
	@PostConstruct
	public void inicializar() {
		
		funcionario = new Funcionario();
		funcionarios = new ArrayList<>();
		filtro = new Filtro();
		lazyModel = new FuncionarioDataModel(controler.consultarPorFiltro(filtro, "nome"));
		
}
	@Override
	public void chamaInserir(String url) {
		listaTipo = tipoFuncionarioControler.consultarTodos();
		super.chamaInserir(url);
	}
	@Override
	public void chamaAlterar(String url) {
		listaTipo = tipoFuncionarioControler.consultarTodos();
		super.chamaAlterar(url);
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
	
	public void voltar(){
		super.voltar("topburger/faces/topburger/funcionario/manterFuncionario.xhtml");
	}
	public void callInserir(){
		super.chamaInserir("topburger/faces/topburger/funcionario/inserirFuncionario.xhtml");
	}
	
	public void salvar(){
		controler.insert(this.funcionario);
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
	public List<TipoFuncionario> getTipoFuncionario() {
		return listaTipo;
	}
	public void setTipoFuncionario(List<TipoFuncionario> tipoFuncionario) {
		this.listaTipo = tipoFuncionario;
	}
	public IController<Funcionario, Integer> getControler() {
		return controler;
	}
	
	public IController<TipoFuncionario, Integer> getTipoFuncionarioControler() {
		return tipoFuncionarioControler;
	}
	
	
	
	
	

}
