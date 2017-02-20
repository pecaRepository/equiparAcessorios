package br.com.equiparAcessorios.jersey.services;

import java.util.EnumMap;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.equiparAcessorios.entity.Cliente;
import br.com.equiparAcessorios.entity.Ligacao;
import br.com.equiparAcessorios.enumeration.TipoSexo;
import br.com.equiparAcessorios.service.ClienteServiceImpl;

@Path("/cliente")
public class ClienteController {

	@GET
	@Path("/tipoSexo")
	@Produces(MediaType.APPLICATION_JSON)
	public EnumMap<TipoSexo, String> findAll() {
		EnumMap<TipoSexo, String> tipos = new EnumMap<TipoSexo, String>(TipoSexo.class);
		for (TipoSexo tipo : TipoSexo.values()) {
			tipos.put(tipo, tipo.getDescricao());
		}
		return tipos;
	}
	
	
	@GET
	@Path("/client")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Cliente> listarTodos() {

		List<Cliente> listacliente = new ClienteServiceImpl().consultarClientes();
				
		return listacliente;

	}
	
	@GET
	@Path("/listLigacoes/{codigo}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Ligacao> listarTodasLigacoes(@PathParam("codigo") Long codigo ) {

		List<Ligacao> listaLigacoes = new ClienteServiceImpl().consultaLigacoes(codigo);
				
		return listaLigacoes;

	}
	
	@GET
	@Path("/consultarClientePorCpf/{cpf}")
	@Produces(MediaType.APPLICATION_JSON)
	public Cliente consultarPorCPF (@PathParam("cpf") String cpf) {

		Cliente cliente = new ClienteServiceImpl().consultarClientePorCPF(cpf);
				
		return cliente;

	}
	
	@GET
	@Path("/consultarClientePorCodigo/{codigo}")
	@Produces(MediaType.APPLICATION_JSON)
	public Cliente consultarClientePorCodigo (@PathParam("codigo") Long codigo) {

		Cliente cliente = new ClienteServiceImpl().consultarClientePorCodigo(codigo);
				
		return cliente;

	}
	
	
	@POST
	@Path("/registrarLigacao")	
	@Produces(MediaType.APPLICATION_JSON)
	public boolean registrarLigacao (Ligacao ligacao) {
		
		return new ClienteServiceImpl().registrarLigacao(ligacao);
	}
	
	public static void main(String[] args) {

	
		java.util.Date dataUtil = new java.util.Date();  
		java.sql.Date dataSql = new java.sql.Date(dataUtil.getTime()); 
		System.out.println(dataSql);

		
		
	}
	
	@POST
	@Path("/salvar")
	@Produces(MediaType.APPLICATION_JSON)
	public boolean salvar ( Cliente cliente) {

		return new ClienteServiceImpl().cadastraCliente(cliente);
	}
	
	@POST
	@Path("/alterar")
	@Produces(MediaType.APPLICATION_JSON)
	public boolean alterar ( Cliente cliente) {

		return new ClienteServiceImpl().editarCliente(cliente);
	}
	
	@POST
	@Path("/excluir")
	@Produces(MediaType.APPLICATION_JSON)
	public boolean excluir ( Cliente cliente) {

		return new ClienteServiceImpl().deletarCliente(cliente);
	}


}
