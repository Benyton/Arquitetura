package br.edu.up.Control.test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.edu.up.Control.DAO.FactoryDao;
import br.edu.up.Control.DAO.FuncionarioDao;
import br.edu.up.Control.entidade.Funcionario;
import br.edu.up.Control.service.FuncionarioService;
import br.edu.up.Control.service.ServiceException;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestarFuncionario {

	static Funcionario c = new Funcionario();
	
	@Test
	public void testAcadastrarFuncionario() {
		
		c.setId(null);
		c.setNome("Ronaldo");
		
		try {
			new FuncionarioService().salvar(c);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		
		assertEquals(true,c.getId() != null);
		
	}
	
	@Test
	public void testBalterarFuncionario() {
		
		c.setNome("Victor");
		
		try {
			new FuncionarioService().alterar(c);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	
		assertEquals(true,c.getId() != null);
	}
	
	@Test
	public void testDexcuirFuncionario() {

		try {
			new FuncionarioService().excluir(c);
			
			c = FactoryDao.createFuncionarioDao().buscarPorId(c.getId());
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		
		assertEquals(true, c == null);
	}
	
	@Test
	public void testClistarFuncionario() {
		
		List<Funcionario> funcionarios = new FuncionarioDao().listar();

		assertEquals(true, funcionarios.size()>0);
	}
}
