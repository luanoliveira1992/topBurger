package test;



import org.easymock.EasyMock;
import org.junit.Test;

import topburger.business.FuncionarioControler;
import topburger.business.ProdutoControler;
import topburger.entitys.Funcionario;
import topburger.entitys.Produto;
import topburger.infraestrutura.Filtro;
import topburger.persistence.FuncionarioDao;
import topburger.persistence.ProdutoDao;

//Este teste é para o Caso de uso 09
public class ProdutoControllerTest{
	@Test
	public void inserirProdutoTest(){
		Produto produto = new Produto();
		produto.setDescricao("teste");
		
		ProdutoDao dao = EasyMock.createMock(ProdutoDao.class);
		dao.insert(produto);
		EasyMock.replay(dao);
		
		ProdutoControler controller = new ProdutoControler();
		controller.setDao(dao);
		controller.insert(produto);
	}
	@Test
	public void consultarTodos(){
		Produto produto = new Produto();
		produto.setDescricao("teste");
		
		ProdutoDao dao = EasyMock.createMock(ProdutoDao.class);
		EasyMock.expect(dao.consultarTodos()).andReturn(null); 
		
		
		ProdutoControler controller = new ProdutoControler();
		controller.setProdutoDao(dao);
		controller.consultarTodos();
	}
	
	@Test
	public void delete(){
		Produto produto = new Produto();
		produto.setCodigo(25);
		produto.setDescricao("Projeto nota 10");
		ProdutoDao dao = EasyMock.createMock(ProdutoDao.class);
		dao.delete(produto);
		EasyMock.replay(dao);
		
		
		ProdutoControler controller = new ProdutoControler();
		controller.setProdutoDao(dao);
		controller.delete(produto);
	}
	
	@Test
	public void consultarPorFiltro(){
		Filtro filtro = new Filtro();
		Produto produto = new Produto();
		produto.setDescricao("teste");
		
		ProdutoDao dao = EasyMock.createMock(ProdutoDao.class);
		EasyMock.expect(dao.consultarPorFiltro(filtro)).andReturn(null); 
		
		
		ProdutoControler controller = new ProdutoControler();
		controller.setProdutoDao(dao);
		controller.consultarPorFiltro(filtro);
	}
}
