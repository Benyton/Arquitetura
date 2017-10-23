package br.edu.up.Control.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Conexao {

	static EntityManagerFactory emf = Persistence.
			createEntityManagerFactory("Control");
	
	public static EntityManager getInstance() {
		return emf.createEntityManager();
	}
}
