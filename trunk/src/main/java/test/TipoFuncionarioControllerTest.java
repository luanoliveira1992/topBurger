package test;

import org.easymock.EasyMock;
import org.junit.Test;

import topburger.business.ProdutoControler;
import topburger.business.TipoFuncionarioControler;
import topburger.entitys.Produto;
import topburger.entitys.TipoFuncionario;
import topburger.infraestrutura.Filtro;
import topburger.persistence.ProdutoDao;
import topburger.persistence.TipoFuncionarioDao;

public class TipoFuncionarioControllerTest {
	
	@Test
	public void inserirProdutoTest(){
		TipoFuncionario tipoFuncionario = new TipoFuncionario();
		tipoFuncionario.setDescricao("teste");
		
		TipoFuncionarioDao dao = EasyMock.createMock(TipoFuncionarioDao.class);
		dao.insert(tipoFuncionario);
		EasyMock.replay(dao);
		
		TipoFuncionarioControler controller = new TipoFuncionarioControler();
		controller.setTipofuncionarioDao(dao);
		controller.insert(tipoFuncionario);
	}
	@Test
	public void consultarTodos(){
		TipoFuncionario tipoFuncionario = new TipoFuncionario();
		tipoFuncionario.setDescricao("teste");
		
		TipoFuncionarioDao dao = EasyMock.createMock(TipoFuncionarioDao.class);
		EasyMock.expect(dao.consultarTodos()).andReturn(null); 
		
		
		TipoFuncionarioControler controller = new TipoFuncionarioControler();
		controller.setTipofuncionarioDao(dao);
		controller.consultarTodos();
	}
	
	@Test
	public void delete(){
		TipoFuncionario tipoFuncionario = new TipoFuncionario();
		tipoFuncionario.setCodigo(25);
		tipoFuncionario.setDescricao("Projeto nota 10");
		TipoFuncionarioDao dao = EasyMock.createMock(TipoFuncionarioDao.class);
		dao.delete(tipoFuncionario);
		EasyMock.replay(dao);
		
		
		TipoFuncionarioControler controller = new TipoFuncionarioControler();
		controller.setTipofuncionarioDao(dao);
		controller.delete(tipoFuncionario);
	}
	
	@Test
	public void consultarPorFiltro(){
		Filtro filtro = new Filtro();
		TipoFuncionario tipoFuncionario = new TipoFuncionario();
		tipoFuncionario.setCodigo(25);
		tipoFuncionario.setDescricao("Projeto nota 10");
		
		TipoFuncionarioDao dao = EasyMock.createMock(TipoFuncionarioDao.class);
		EasyMock.expect(dao.consultarPorFiltro(filtro)).andReturn(null); 
		
		
		TipoFuncionarioControler controller = new TipoFuncionarioControler();
		controller.setTipofuncionarioDao(dao);
		controller.consultarPorFiltro(filtro);
	}

}
