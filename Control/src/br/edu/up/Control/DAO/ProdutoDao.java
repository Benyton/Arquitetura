package br.edu.up.Control.DAO;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.edu.up.Control.entidade.Produto;

public class ProdutoDao implements Dao<Produto> {

	public void salvar(Produto c) {
		EntityManager em = Conexao.getInstance();
		
		em.getTransaction().begin();
		em.persist(c);
		em.getTransaction().commit();
		
	}
	
	public void excluir(Produto c) {
		
	}
	
	public void alterar(Produto c) {
		
	}
	
	public List<Produto> listar() {
		EntityManager em = Conexao.getInstance();
		Query q = em.createQuery("from Produto");
		return q.getResultList();
	}
	
	public Produto buscarPorId(Integer id) {
		return null;
	}

}
