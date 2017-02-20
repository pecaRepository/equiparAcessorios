package br.com.equiparAcessorios.jersey.services;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.equiparAcessorios.entity.Comissao;
import br.com.equiparAcessorios.entity.Funcionario;
import br.com.equiparAcessorios.entity.Produto;
import br.com.equiparAcessorios.entity.ProdutoComissao;
import br.com.equiparAcessorios.enumeration.TipoSexo;
import br.com.equiparAcessorios.service.FuncionarioServiceImpl;
import br.com.equiparAcessorios.service.ProdutoServiceImpl;

@Path("/funcionario")
public class FuncionarioController {
	
	FuncionarioServiceImpl servico;

	public FuncionarioController() {
	if(servico == null)
		servico = new FuncionarioServiceImpl();
	
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
	@Path("/listProduto")
	@Produces(MediaType.APPLICATION_JSON)
	public List<ProdutoComissao> listarTodosProdutos() {

		List<Produto> listaProduto = new ProdutoServiceImpl().consultarProduto();
		List<ProdutoComissao> listaProdutoFinal = new ArrayList<ProdutoComissao>(); 
		for (Produto produto : listaProduto) {
			ProdutoComissao prod = new ProdutoComissao();
			prod.setCategoria(produto.getCategoria());
			prod.setModelo(produto.getModelo());
			prod.setMarca(produto.getMarca());
			prod.setValor(produto.getValor());
			prod.setCdProduto(produto.getCodigo());
			listaProdutoFinal.add(prod);
		}
				
		return listaProdutoFinal;

	}
	
	static long cdFuncionario;
	
	@GET
	@Path("/listProdutoComissao/{cdFuncionario}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<ProdutoComissao> listarProdutoComissao(@PathParam("cdFuncionario") Long cdFuncionario) {
		
		this.cdFuncionario = cdFuncionario;

		List<Comissao> listaProdutoComissao = new ProdutoServiceImpl().consultarProdutoComissao(cdFuncionario);
		List<Produto> listaProduto = new ProdutoServiceImpl().consultarProduto();
		List<ProdutoComissao> listaFinal = new ArrayList<ProdutoComissao>();  
		
		for (Comissao comissao : listaProdutoComissao) {
			for (Produto produto : listaProduto) {
				if(comissao.getCdProduto() == produto.getCodigo()){
					ProdutoComissao produtoComissao = new ProdutoComissao();
					produtoComissao.setCodigo(comissao.getCodigo());
					produtoComissao.setCdProduto(comissao.getCdProduto());
					produtoComissao.setCdFuncionario(comissao.getCdFuncionario());
					produtoComissao.setCategoria(produto.getCategoria());
					produtoComissao.setMarca(produto.getMarca());
					produtoComissao.setModelo(produto.getModelo());
					produtoComissao.setValor(produto.getValor());
					produtoComissao.setComissao(comissao.getComissao());
					listaFinal.add(produtoComissao);
				}
			}
		}
				
		return listaFinal;

	}
	
	
	@POST
	@Path("/salvarComissao")
	@Produces(MediaType.APPLICATION_JSON)
	public boolean salvarComissao(List<ProdutoComissao> produtosComissao) {

		System.out.println(produtosComissao);
		
		long funcionario = this.cdFuncionario;
		System.out.println(funcionario);
		List<Comissao> listaProdutoComissao = new ArrayList<Comissao>();
		for (ProdutoComissao produtoComissao : produtosComissao) {
			Comissao comissao = new Comissao();
			
			if(produtoComissao.getCodigo() != null)
				comissao.setCodigo(produtoComissao.getCodigo());
			
			comissao.setCdFuncionario(funcionario);
			comissao.setCdProduto(produtoComissao.getCdProduto());
			comissao.setComissao(produtoComissao.getComissao());
			listaProdutoComissao.add(comissao);
		}
		System.out.println(funcionario);
		return new ProdutoServiceImpl().salvarComissao(listaProdutoComissao, funcionario);
	}
	
	
	@GET
	@Path("/listFuncionario")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Funcionario> listarTodos() {

		List<Funcionario> listaFuncionario = servico.consultarFuncionarios();
				
		return listaFuncionario;

	}
	
	@GET
	@Path("/buscar/{codigo}")
	@Produces(MediaType.APPLICATION_JSON)
	public Funcionario consultar (@PathParam("codigo") long codigo) {

		Funcionario funcionario = servico.consultarFuncionario(codigo);
		return funcionario;
	}
	
	@POST
	@Path("/salvar")
	@Produces(MediaType.APPLICATION_JSON)
	public boolean salvar ( Funcionario funcionario) {

		return servico.cadastraFuncionario(funcionario);
	}
	
	@POST
	@Path("/alterar")
	@Produces(MediaType.APPLICATION_JSON)
	public boolean alterar ( Funcionario funcionario) {

		return servico.editarFuncionario(funcionario);
	}
	
	@POST
	@Path("/excluir")
	@Produces(MediaType.APPLICATION_JSON)
	public boolean excluir ( long codigo) {
		new ProdutoServiceImpl().salvarComissao(new ArrayList<Comissao>(), codigo);
		return servico.removerItem(codigo);
		
	}

}
