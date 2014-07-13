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
import topburger.business.ITipoFuncionarioControler;
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
	private String numeroTelefone;
	
	@Autowired
	IFuncionarioControler controler;
	
	@Autowired
	ITipoFuncionarioControler tipoFuncionarioControler;
	
	

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
		funcionario = new Funcionario();
		listaTipo = tipoFuncionarioControler.consultarTodos();
		this.numeroTelefone = new String();
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
		super.voltar("/topburger/funcionario/manterFuncionario.xhtml");
	}
	public void callInserir(){
		chamaInserir("/topburger/funcionario/inserirFuncionario.xhtml");
	}
	
	public void callAlterar(){
		if(this.funcionario == null){
			
		}
		chamaAlterar("/topburger/funcionario/alterarFuncionario.xhtml");
	}
	
	public void salvar(){
		TipoFuncionario tipoFuncionarioAtual = tipoFuncionarioControler.buscaPorChave(funcionario.getTipo().getCodigo());
		this.funcionario.setTipo(tipoFuncionarioAtual);
		controler.insert(this.funcionario);
		voltar();
		adcionaMensagemSucesso("Funcionário Cadastrado Com Sucesso !");
		this.funcionario = new Funcionario();
	}
	
	public void alterar(){
		TipoFuncionario tipoFuncionarioAtual = tipoFuncionarioControler.buscaPorChave(funcionario.getTipo().getCodigo());
		this.funcionario.setTipo(tipoFuncionarioAtual);
		controler.update(this.funcionario);
		voltar();
		adcionaMensagemSucesso("Funcionário Alterardo Com Sucesso !");
	}
	
	public void deletar(){
		controler.delete(funcionario);
		adcionaMensagemSucesso("Funcionário Deletado Com Sucesso !");
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
	
	
	public IController<Funcionario, Integer> getControler() {
		return controler;
	}
	
	public IController<TipoFuncionario, Integer> getTipoFuncionarioControler() {
		return tipoFuncionarioControler;
	}
	
	public List<TipoFuncionario> getListaTipo() {
		return listaTipo;
	}
	public void setListaTipo(List<TipoFuncionario> listaTipo) {
		this.listaTipo = listaTipo;
	}
	
	
	
	
	
	

}
