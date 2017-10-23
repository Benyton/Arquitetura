package br.edu.up.Control.test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import br.edu.up.Control.DAO.ClienteDao;
import br.edu.up.Control.entidade.Cliente;
import br.edu.up.Control.service.ClienteService;
import br.edu.up.Control.service.ServiceException;


public class TestarCliente {
	
	@Test
	public void cadastrarCliente() {
		
		Cliente c = new Cliente();
		c.setId(null);
		c.setNome("Cleverson");
		
		try {
			new ClienteService().salvar(c);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	
		
		assertEquals(true,c.getId() != null);
		
	}
	
	@Test
	public void listarCliente() {
		
		List<Cliente> clientes = new ClienteDao().listar();

		assertEquals(true, clientes.size()>0);
	}

}

