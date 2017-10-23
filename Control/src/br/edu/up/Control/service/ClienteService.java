package br.edu.up.Control.service;

import br.edu.up.Control.DAO.Dao;
import br.edu.up.Control.DAO.FactoryDao;
import br.edu.up.Control.entidade.Cliente;

public class ClienteService {

	public void salvar(Cliente c) throws ServiceException {
			
			if (c.getNome() == null || c.getNome().equals("")) {
				
				throw new 
				ServiceException("ERR01 - O nome precisa ser preenchido.");
			}
			
			Dao<Cliente> ClienteDao = FactoryDao.createClienteDao();
			ClienteDao.salvar(c);	
		}
	
	public void alterar (Cliente c) throws ServiceException {
		Dao<Cliente> ClienteDao = FactoryDao.createClienteDao();
		ClienteDao.alterar(c);
		}
}
