package br.edu.up.Control.test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import br.edu.up.Control.DAO.FuncionarioDao;
import br.edu.up.Control.entidade.Cliente;
import br.edu.up.Control.entidade.Funcionario;
import br.edu.up.Control.service.ClienteService;
import br.edu.up.Control.service.FuncionarioService;
import br.edu.up.Control.service.ServiceException;

public class TestarFuncionario {

	
	public void cadastrarFuncionario() {
		
		Funcionario c = new Funcionario();
		c.setId(null);
		c.setNome("Rodrigo");
		
		try {
			new FuncionarioService().salvar(c);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		
		assertEquals(true,c.getId() != null);
		
	}
	
	
	public void alterarFuncionario() {
		Funcionario c = new Funcionario();
		c.setId(2);
		c.setNome("Pedro");
		
		try {
			new FuncionarioService().alterar(c);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	
		assertEquals(true,c.getId() != null);
	}
	
	public void excuirCliente() {
		Funcionario c = new Funcionario();
		
		c.setId(1);
		c.setNome("Rodrigo");
		
		try {
			new FuncionarioService().excluir(c);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void listarFuncionario() {
		
		List<Funcionario> funcionarios = new FuncionarioDao().listar();

		assertEquals(true, funcionarios.size()>0);
	}
}
