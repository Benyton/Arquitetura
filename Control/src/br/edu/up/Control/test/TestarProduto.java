package br.edu.up.Control.test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.edu.up.Control.DAO.ProdutoDao;
import br.edu.up.Control.entidade.Produto;
import br.edu.up.Control.service.ProdutoService;
import br.edu.up.Control.service.ServiceException;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestarProduto {
	
	static Produto c = new Produto();
	
	@Test
	public void cadastrarProduto() {
		
		c.setId(null);
		c.setNome("Processador");
		c.setMarca("AMD");
		
		try {
			new ProdutoService().salvar(c);
		} catch (ServiceException e) {
			e.printStackTrace();
		}

		assertEquals(true,c.getId() != null);
		
	}
	
	@Test
	public void alterarProduto() {
		
		c.setId(2);
		c.setNome("Processador");
		c.setMarca("INTEL");
		
		try {
			new ProdutoService().alterar(c);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	
		assertEquals(true,c.getId() != null);
	}
	
	@Test
	public void excuirProduto() {	
		
		c.setId(1);
		c.setNome("Processador");
		c.setMarca("AMD");
		
		try {
			new ProdutoService().excluir(c);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void listarProduto() {
		
		List<Produto> produtos = new ProdutoDao().listar();

		assertEquals(true, produtos.size()>0);
	}

}
