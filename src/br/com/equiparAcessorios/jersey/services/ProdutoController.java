package br.com.equiparAcessorios.jersey.services;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.equiparAcessorios.entity.Categoria;
import br.com.equiparAcessorios.entity.Produto;
import br.com.equiparAcessorios.service.ProdutoServiceImpl;

@Path("/produto")
public class ProdutoController {
	
	@GET
	@Path("/listCategoria")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Categoria> listarCategoria() {

		List<Categoria> ListaCategoria = new ProdutoServiceImpl().consultarCategorias();
				
		return ListaCategoria;

	}
	
	
	@GET
	@Path("/listProduto")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Produto> listarTodos() {

		List<Produto> listaProduto = new ProdutoServiceImpl().consultarProduto();
				
		return listaProduto;

	}	
	
	@GET
	@Path("/buscar/{codigo}")
	@Produces(MediaType.APPLICATION_JSON)
	public Produto consultar (@PathParam("codigo") long codigo) {

		Produto Produto = new ProdutoServiceImpl().consultarProduto(codigo);
				
		return Produto;

	}
	
	@GET
	@Path("/buscarCategoria/{codigo}")
	@Produces(MediaType.APPLICATION_JSON)
	public Categoria consultarCategoria (@PathParam("codigo") long codigo) {

		Categoria categoria = new ProdutoServiceImpl().consultarCategoria(codigo);
				
		return categoria;

	}
	
	@POST
	@Path("/salvar")
	@Produces(MediaType.APPLICATION_JSON)
	public boolean salvar ( Produto produto) {

		return new ProdutoServiceImpl().cadastrarProduto(produto);
	}
	
	@POST
	@Path("/salvarCategoria")
	@Produces(MediaType.APPLICATION_JSON)
	public boolean salvarCategoria ( Categoria categoria) {

		return new ProdutoServiceImpl().cadastrarCategoria(categoria);
	}
	
	@POST
	@Path("/alterar")
	@Produces(MediaType.APPLICATION_JSON)
	public boolean alterar ( Produto produto) {

		return new ProdutoServiceImpl().editarProduto(produto);
	}
	
	@POST
	@Path("/alterarCategoria")
	@Produces(MediaType.APPLICATION_JSON)
	public boolean alterarCategoria ( Categoria categoria) {

		return new ProdutoServiceImpl().editarCategoria(categoria);
	}
	
	@POST
	@Path("/excluir")
	@Produces(MediaType.APPLICATION_JSON)
	public boolean excluir ( Produto produto) {

		return new ProdutoServiceImpl().removerItem(produto);
	}
	
	@POST
	@Path("/excluirCategoria")
	@Produces(MediaType.APPLICATION_JSON)
	public boolean excluirCategoria ( Categoria categoria) {

		return new ProdutoServiceImpl().removerItem(categoria);
	}


}
