package test;



import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.easymock.EasyMock;
import org.junit.Test;
import org.mockito.Mockito;

import topburger.business.PratoController;
import topburger.business.ProdutoControler;
import topburger.entitys.Prato;
import topburger.entitys.Produto;
import topburger.infraestrutura.NegocioException;
import topburger.persistence.PratoDao;
import topburger.persistence.ProdutoDao;

public class PratoControllerTest {
	@Test
	//Este teste é para o Caso de uso 09
	public void inserirPratoTest(){
		Prato prato = new Prato();
		prato.setNome("hamburguer");
		
		PratoDao dao = EasyMock.createMock(PratoDao.class);
		dao.insert(prato);
		EasyMock.replay(dao);
		
		PratoController controller = new PratoController();
		controller.setDao(dao);
		controller.insert(prato);
	}
	
	@Test
	public void verificaNomeExistente() throws NegocioException{
		String nomePrato ="Cheese Cheddar";
		List<Prato> listaPrato = new ArrayList<>();
		PratoDao pratoDao = Mockito.mock(PratoDao.class);
		PratoController pratoController = Mockito.mock(PratoController.class);
		
		Mockito.doCallRealMethod().when(pratoController).setPratoDao(pratoDao);
		pratoController.setPratoDao(pratoDao);
		
		Mockito.when(pratoDao.verificaNomeExistente(nomePrato)).thenReturn(true);
		Prato prato = new Prato();
		Mockito.doCallRealMethod().when(pratoController).verificaNomeExistente(prato);
		
		try{
			pratoController.verificaNomeExistente(prato);
			
		}catch(NegocioException e){
			Assert.fail();
		}
	}
	
	@Test
	public void verificaNomeExistenteNaoEncontrado() throws NegocioException{
		String nomePrato ="Cheese Cheddar";
		List<Prato> listaPrato = new ArrayList<>();
		PratoDao pratoDao = Mockito.mock(PratoDao.class);
		PratoController pratoController = Mockito.mock(PratoController.class);
		
		Mockito.doCallRealMethod().when(pratoController).setPratoDao(pratoDao);
		pratoController.setPratoDao(pratoDao);
		
		Mockito.when(pratoDao.verificaNomeExistente(nomePrato)).thenReturn(false);
		Prato prato = new Prato();
		Mockito.doCallRealMethod().when(pratoController).verificaNomeExistente(prato);
		
		try{
			pratoController.verificaNomeExistente(prato);
			
		}catch(NegocioException e){
			Assert.fail();
		  }
		}
	@Test
	public void buscaPorChave(){
		Produto produto = new Produto();
		produto.setDescricao("teste");
		Integer chave = new Integer("1");
		
		ProdutoDao dao = EasyMock.createMock(ProdutoDao.class);
		EasyMock.expect(dao.buscaPorChave(chave)).andReturn(null); 
		
		
		ProdutoControler controller = new ProdutoControler();
		controller.setProdutoDao(dao);
		controller.buscaPorChave(chave);
	}
}
