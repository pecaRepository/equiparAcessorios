package br.com.equiparAcessorios.jersey.services;

import java.util.EnumMap;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.equiparAcessorios.entity.Fornecedor;
import br.com.equiparAcessorios.enumeration.TipoSexo;
import br.com.equiparAcessorios.service.FornecedorServiceImpl;

@Path("/fornecedor")
public class FornecedorController {
	
	FornecedorServiceImpl servico;

	public FornecedorController() {
	if(servico == null)
		servico = new FornecedorServiceImpl();
	}


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
	@Path("/listfornecedor")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Fornecedor> listarTodos() {

		List<Fornecedor> listafornecedor = servico.consultarFornecedores();
				
		return listafornecedor;

	}
	
	@GET
	@Path("/buscar/{codigo}")
	@Produces(MediaType.APPLICATION_JSON)
	public Fornecedor consultar (@PathParam("codigo") long codigo) {

		Fornecedor fornecedor = servico.consultarFornecedor(codigo); 		
		return fornecedor;
	}
	
	@POST
	@Path("/salvar")
	@Produces(MediaType.APPLICATION_JSON)
	public boolean salvar ( Fornecedor fornecedor) {

		return servico.cadastrarFornecedor(fornecedor);
	}
	
	@POST
	@Path("/alterar")
	@Produces(MediaType.APPLICATION_JSON)
	public boolean alterar ( Fornecedor fornecedor) {

		return servico.editarFornecedor(fornecedor);
	}
	
	@POST
	@Path("/excluir")
	@Produces(MediaType.APPLICATION_JSON)
	public boolean excluir ( Fornecedor fornecedor) {

		return servico.deletarFornecedor(fornecedor);
	}


}
