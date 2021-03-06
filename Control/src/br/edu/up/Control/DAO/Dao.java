package br.edu.up.Control.DAO;

import java.util.List;

public interface Dao<T> {
	
	public void salvar(T t);
	
	public void excluir(T t);
	
	public void alterar(T t);
	
	public List<T> listar();
	
	public T buscarPorId(Integer id);
	
}
