package br.edu.up.Control.DAO;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import br.edu.up.Control.entidade.Funcionario;


public class FuncionarioDao implements Dao<Funcionario> {

	public void salvar(Funcionario c) {
		EntityManager em = Conexao.getInstance();
		
		em.getTransaction().begin();
		em.persist(c);
		em.getTransaction().commit();
		
	}
	
	public void excluir(Funcionario c) {
		
	}
	
	public void alterar(Funcionario c) {
		
	}
	
	public List<Funcionario> listar() {
		EntityManager em = Conexao.getInstance();
		Query q = em.createQuery("from Funcionario");
		return q.getResultList();
	}
	
	public Funcionario buscarPorId(Integer id) {
		return null;
	}
}
