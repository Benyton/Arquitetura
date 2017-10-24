package br.edu.up.Control.test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import br.edu.up.Control.DAO.ClienteDao;
import br.edu.up.Control.entidade.Cliente;
import br.edu.up.Control.service.ClienteService;
import br.edu.up.Control.service.ServiceException;


public class TestarCliente {
	
	
	public void cadastrarCliente() {
		
		Cliente c = new Cliente();
		c.setId(null);
		c.setNome("Eduardo");
		
		try {
			new ClienteService().salvar(c);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	
		assertEquals(true,c.getId() != null);
		
	}
	@Test
	public void alterarCliente() {
		Cliente c = new Cliente();
		c.setId(2);
		c.setNome("Pedro");
		
		try {
			new ClienteService().alterar(c);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	
		assertEquals(true,c.getId() != null);
	}
	
	public void excuirCliente() {
		Cliente c = new Cliente();
		
		c.setId(1);
		c.setNome("Eduardo");
		
		try {
			new ClienteService().excluir(c);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}
	
	
	public void listarCliente() {
		
		List<Cliente> clientes = new ClienteDao().listar();

		assertEquals(true, clientes.size()>0);
	}

}

