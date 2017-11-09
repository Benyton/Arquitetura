package br.edu.up.Control.service;

import br.edu.up.Control.DAO.Dao;
import br.edu.up.Control.DAO.FactoryDao;
import br.edu.up.Control.entidade.Produto;

public class ProdutoService {

	public void salvar(Produto c) throws ServiceException {
		
			if (c.getNome() == null || c.getNome().equals("")) {
				
				throw new 
				ServiceException("ERR01 - O nome precisa ser preenchido.");
			}
			
			Dao<Produto> ProdutoDao = FactoryDao.createProdutoDao();
			ProdutoDao.salvar(c);	
	}

	public void alterar (Produto c) throws ServiceException {
		Dao<Produto> ProdutoDao = FactoryDao.createProdutoDao();
		ProdutoDao.alterar(c);
	}
	
	public void excluir (Produto c) throws ServiceException {
		Dao<Produto> ProdutoDao = FactoryDao.createProdutoDao();
		ProdutoDao.excluir(c);
	}
}
