package br.edu.up.Control.DAO;

import br.edu.up.Control.entidade.Cliente;
import br.edu.up.Control.entidade.Funcionario;
import br.edu.up.Control.entidade.Produto;

public class FactoryDao {

	public static Dao<Cliente> createClienteDao() {
		return new ClienteDao();
	}
	
	public static Dao<Funcionario> createFuncionarioDao() {
		return new FuncionarioDao();
	}
	
	public static Dao<Produto> createProdutoDao() {
		return new ProdutoDao();
	}
}
