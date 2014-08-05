package topburger.presentation;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.primefaces.event.TransferEvent;
import org.primefaces.model.DualListModel;
import org.primefaces.model.LazyDataModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import topburger.business.IPratoController;
import topburger.business.IProdutoControler;
import topburger.entitys.Prato;
import topburger.entitys.Produto;
import topburger.infraestrutura.Filtro;
import topburger.infraestrutura.NegocioException;

@SuppressWarnings("serial")
@Component
@Scope(WebApplicationContext.SCOPE_SESSION)
public class ManterPratoMB  extends AbstractMB{
	
	private LazyDataModel<Prato> lazyModel;
	private LazyDataModel<Produto> lazyModelProduto;
	private DualListModel<Produto> produtos;
	private List<Produto> listaProduto;
	private List<Produto> listaFinal;
	private Produto produto;
	
	private Prato prato;
	Filtro filtro;
	
	@Autowired
	IPratoController controllerPrato;
	
	@Autowired
	IProdutoControler controllerProduto;

	@Override
	@PostConstruct
	public void inicializar() {
		filtro = new Filtro();
		lazyModel =  new PratoDataModel(controllerPrato.consultarPorFiltro(filtro, "nome"));
		this.prato = new Prato();
		this.produto = new Produto();
		
	}
	
	
	
	public void callInserir(){
		configuraChamadaInsercao();
		this.chamaInserir("/topburger/prato/inserirPrato.xhtml");
		
		
	}



	private void configuraChamadaInsercao() {
		
		this.listaProduto = controllerProduto.consultarTodos();
		this.listaFinal = new ArrayList<Produto>();
		this.prato = new Prato();
		this.prato.setProdutos(new ArrayList<Produto>());
		this.produtos = new DualListModel<Produto>(this.listaProduto, listaFinal);
	}
	public void callAlterar(){
		this.prato =   this.controllerPrato.buscaPorChave(this.prato.getCodigo());
		this.prato.setProdutos(new ArrayList<Produto>());
		this.listaProduto = controllerProduto.consultarTodos();
		for (Produto produto : this.prato.getProdutos()) {
			this.listaProduto.remove(produto);
			this.produtos = new DualListModel<Produto>(this.listaProduto, this.prato.getProdutos());
			
			
		}
		this.chamaAlterar("/topburger/prato/alterarPrato.xhtml");
	}
	
	public void deletar(){
		
	}
	
	public void voltar(){
		super.voltar("/topburger/prato/manterPrato.xhtml");
	}

    public void salvar(){
    	this.prato.setProdutos(listaFinal);
		this.controllerPrato.insert(this.prato);
		this.voltar("/topburger/prato/manterPrato.xhtml");
		this.adcionaMensagemSucesso("Prato Inserido com Sucesso!");
	}
	
	public void alterar(){
		try{
		 this.controllerPrato.update(this.prato);
		}catch( Exception e){
			this.adcionaMensagemErro(e.getMessage());
			
		}
		 this.voltar("/topburger/prato/manterPrato.xhtml");
		 this.adcionaMensagemSucesso("Prato Alterado com Sucesso!");
	}
	
	public void modificaEscolhido(){
		this.produto.setEscolhido(!this.produto.isEscolhido());
	}
	
	public void configuraSalvarOuAlterar(){
		for(Produto produto: this.listaProduto){
			if(produto.isEscolhido()){
				this.prato.getProdutos().add(produto);
			}
			
		}
		
	}
	
	


	@Override
	public void adcionaMensagemAlerta(String mensagem) {
		
		super.adcionaMensagemAlerta(mensagem);
	}

   public Prato getPrato() {
		return prato;
	}
	public void setPrato(Prato prato) {
		this.prato = prato;
	}
	public LazyDataModel<Prato> getLazyModel() {
		return lazyModel;
	}
	public void setLazyModel(LazyDataModel<Prato> lazyModel) {
		this.lazyModel = lazyModel;
	}
	
	public DualListModel<Produto> getProdutos() {
		return produtos;
	}
	public void setProdutos(DualListModel<Produto> produtos) {
		this.produtos = produtos;
	}
	
	public List<Produto> getListaProduto() {
		return listaProduto;
	}
	public void setListaProduto(List<Produto> listaProduto) {
		this.listaProduto = listaProduto;
	}
	public List<Produto> getListaFinal() {
		return listaFinal;
	}
	public void setListaFinal(List<Produto> listaFinal) {
		this.listaFinal = listaFinal;
	}
	public LazyDataModel<Produto> getLazyModelProduto() {
		return lazyModelProduto;
	}
	public void setLazyModelProduto(LazyDataModel<Produto> lazyModelProduto) {
		this.lazyModelProduto = lazyModelProduto;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	
	

}
