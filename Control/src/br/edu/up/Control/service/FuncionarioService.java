package br.edu.up.Control.service;

import br.edu.up.Control.DAO.Dao;
import br.edu.up.Control.DAO.FactoryDao;
import br.edu.up.Control.entidade.Cliente;
import br.edu.up.Control.entidade.Funcionario;

public class FuncionarioService {

	public void salvar(Funcionario c) throws ServiceException {
		
			if (c.getNome() == null || c.getNome().equals("")) {
				
				throw new 
				ServiceException("ERR01 - O nome precisa ser preenchido.");
			}
			
			Dao<Funcionario> FuncionarioDao = FactoryDao.createFuncionarioDao();
			FuncionarioDao.salvar(c);	
	}

	public void alterar (Funcionario c) throws ServiceException {
		Dao<Funcionario> FuncionarioDao = FactoryDao.createFuncionarioDao();
		FuncionarioDao.alterar(c);
	}
	
	public void excluir (Funcionario c) throws ServiceException {
		Dao<Funcionario> ProdutoDao = FactoryDao.createFuncionarioDao();
		ProdutoDao.excluir(c);
	}
}
