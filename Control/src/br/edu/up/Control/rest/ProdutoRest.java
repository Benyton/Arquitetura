package br.edu.up.Control.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.edu.up.Control.DAO.ProdutoDao;
import br.edu.up.Control.entidade.Produto;
import br.edu.up.Control.service.ProdutoService;
import br.edu.up.Control.service.ServiceException;

@Path("/detalheproduto")
public class ProdutoRest {
		
		@GET
		@Produces(MediaType.APPLICATION_JSON)
		public ArrayList<Produto> listarProdutos() {
			List<Produto> produtos = new ProdutoDao().listar();
			return new ArrayList<>(produtos);
		}

		@POST
		@Consumes(MediaType.APPLICATION_JSON)
		public void cadastrarProduto(Produto produto) {
			try {
				new ProdutoService().salvar(produto);
			} catch (ServiceException e) {
				e.printStackTrace();
			}
		}

		@DELETE
		@Consumes(MediaType.APPLICATION_JSON)
		public void deletarProduto(Produto produto) {
			try {
				new ProdutoService().excluir(produto);
				
			} catch (ServiceException e) {
				e.printStackTrace();
			}
			
		}
		
		@PUT
		@Consumes(MediaType.APPLICATION_JSON)
		public void alterarProduto(Produto produto) {
			try {
				new ProdutoService().alterar(produto);
			} catch (ServiceException e) {
				e.printStackTrace();
			}
		
			
		}
	}
