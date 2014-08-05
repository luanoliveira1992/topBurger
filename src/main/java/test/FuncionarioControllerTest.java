package test;

import org.easymock.EasyMock;
import org.junit.Test;

import topburger.business.FuncionarioControler;
import topburger.business.ProdutoControler;
import topburger.entitys.Funcionario;
import topburger.entitys.Produto;
import topburger.persistence.FuncionarioDao;
import topburger.persistence.ProdutoDao;

public class FuncionarioControllerTest {
	
	@Test
	public void insert(){
		Funcionario funcionario = new Funcionario();
		funcionario.setCodigo(25);
		funcionario.setNome("Projeto nota 10");
		FuncionarioDao dao = EasyMock.createMock(FuncionarioDao.class);
		dao.insert(funcionario);
		EasyMock.replay(dao);
		
		FuncionarioControler controller = new FuncionarioControler();
		controller.insert(funcionario);
	}
	
	@Test
	public void delete(){
		Funcionario funcionario = new Funcionario();
		funcionario.setCodigo(25);
		funcionario.setNome("Projeto nota 10");
		FuncionarioDao dao = EasyMock.createMock(FuncionarioDao.class);
		dao.delete(funcionario);
		EasyMock.replay(dao);
		
		
		FuncionarioControler controller = new FuncionarioControler();
		controller.setFuncionarioDao(dao);
		controller.delete(funcionario);
	}
	
	@Test
	public void update(){
		Funcionario funcionario = new Funcionario();
		funcionario.setCodigo(25);
		funcionario.setNome("Projeto nota 10");
		FuncionarioDao dao = EasyMock.createMock(FuncionarioDao.class);
		dao.delete(funcionario);
		EasyMock.replay(dao);
		
		FuncionarioControler controller = new FuncionarioControler();
		controller.setFuncionarioDao(dao);
		controller.delete(funcionario);
	}
	
	@Test
	public void buscaPorChave(){
		Funcionario funcionario = new Funcionario();
		funcionario.setCodigo(25);
		funcionario.setNome("Projeto nota 10");
		Integer chave = new Integer("1");
		
		FuncionarioDao dao = EasyMock.createMock(FuncionarioDao.class);
		EasyMock.expect(dao.buscaPorChave(chave)).andReturn(null); 
		
		
		FuncionarioControler controller = new FuncionarioControler();
		controller.setFuncionarioDao(dao);
		controller.buscaPorChave(chave);
	}

}
