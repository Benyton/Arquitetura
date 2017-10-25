package br.edu.up.Control.test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.After;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.edu.up.Control.DAO.ClienteDao;
import br.edu.up.Control.DAO.FactoryDao;
import br.edu.up.Control.entidade.Cliente;
import br.edu.up.Control.service.ClienteService;
import br.edu.up.Control.service.ServiceException;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestarCliente {
	
	static Cliente c = new Cliente();
	
	@Test
	public void testAcadastrarCliente() {
		
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
	public void testBalterarCliente() {
//		
		c.setNome("Pedro");
		
		try {
			new ClienteService().alterar(c);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	
		assertEquals(true,c.getId() != null);
	}
	
	@Test
	public void testDexcuirCliente() {
		
		try {
			new ClienteService().excluir(c);
			
			c = FactoryDao.createClienteDao().buscarPorId(c.getId());
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		
		assertEquals(true, c == null);
	}
	
	@Test
	public void testClistarCliente() {
		
		List<Cliente> clientes = new ClienteDao().listar();

		assertEquals(true, clientes.size()>0);
	}

}

