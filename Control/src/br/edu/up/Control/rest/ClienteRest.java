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

import br.edu.up.Control.DAO.ClienteDao;
import br.edu.up.Control.entidade.Cliente;
import br.edu.up.Control.service.ClienteService;
import br.edu.up.Control.service.ServiceException;

@Path("/detalhecliente")
public class ClienteRest {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Cliente> listarClientes() {
		List<Cliente> clientes = new ClienteDao().listar();
		return new ArrayList<>(clientes);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void cadastrarCliente(Cliente cliente) {
		try {
			new ClienteService().salvar(cliente);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	public void deletarCliente(Cliente cliente) {
		try {
			new ClienteService().excluir(cliente);
			
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public void alterarCliente(Cliente cliente) {
		try {
			new ClienteService().alterar(cliente);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	
		
	}
}
