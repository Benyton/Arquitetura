package br.edu.up.Control.test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import br.edu.up.Control.DAO.ProdutoDao;
import br.edu.up.Control.entidade.Produto;
import br.edu.up.Control.service.ProdutoService;
import br.edu.up.Control.service.ServiceException;

public class TestarProduto {
	
	@Test
	public void cadastrarProduto() {
		
		Produto c = new Produto();
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
	public void listarProduto() {
		
		List<Produto> produtos = new ProdutoDao().listar();

		assertEquals(true, produtos.size()>0);
	}

}
