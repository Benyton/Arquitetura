package br.edu.up.Control.test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import br.edu.up.Control.DAO.FuncionarioDao;
import br.edu.up.Control.entidade.Funcionario;
import br.edu.up.Control.service.FuncionarioService;
import br.edu.up.Control.service.ServiceException;

public class TestarFuncionario {

	@Test
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

	public void listarFuncionario() {
		
		List<Funcionario> funcionarios = new FuncionarioDao().listar();

		assertEquals(true, funcionarios.size()>0);
	}
}
