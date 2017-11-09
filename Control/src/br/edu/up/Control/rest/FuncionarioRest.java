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

import br.edu.up.Control.DAO.FuncionarioDao;
import br.edu.up.Control.entidade.Funcionario;
import br.edu.up.Control.service.FuncionarioService;
import br.edu.up.Control.service.ServiceException;

@Path("/detalhefuncionario")
public class FuncionarioRest {
		
		@GET
		@Produces(MediaType.APPLICATION_JSON)
		public ArrayList<Funcionario> listarFuncionarios() {
			List<Funcionario> funcionarios = new FuncionarioDao().listar();
			return new ArrayList<>(funcionarios);
		}

		@POST
		@Consumes(MediaType.APPLICATION_JSON)
		public void cadastrarFuncionario(Funcionario funcionario) {
			try {
				new FuncionarioService().salvar(funcionario);
			} catch (ServiceException e) {
				e.printStackTrace();
			}
		}

		@DELETE
		@Consumes(MediaType.APPLICATION_JSON)
		public void deletarFuncionario(Funcionario funcionario) {
			try {
				new FuncionarioService().excluir(funcionario);
				
			} catch (ServiceException e) {
				e.printStackTrace();
			}
			
		}
		
		@PUT
		@Consumes(MediaType.APPLICATION_JSON)
		public void alterarFuncionario(Funcionario funcionario) {
			try {
				new FuncionarioService().alterar(funcionario);
			} catch (ServiceException e) {
				e.printStackTrace();
			}
		
			
		}
}
