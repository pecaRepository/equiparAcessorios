package br.com.equiparAcessorios.jersey.services;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.equiparAcessorios.entity.Funcionario;
import br.com.equiparAcessorios.entity.HistoricoMaoDeObra;
import br.com.equiparAcessorios.entity.HistoricoProduto;
import br.com.equiparAcessorios.entity.HistoricoVenda;
import br.com.equiparAcessorios.entity.ItemVenda;
import br.com.equiparAcessorios.entity.Orcamento;
import br.com.equiparAcessorios.entity.OrcamentoMaoDeObra;
import br.com.equiparAcessorios.entity.OrcamentoProduto;
import br.com.equiparAcessorios.entity.Produto;
import br.com.equiparAcessorios.entity.ProdutoComissao;
import br.com.equiparAcessorios.service.FuncionarioServiceImpl;
import br.com.equiparAcessorios.service.ProdutoServiceImpl;
import br.com.equiparAcessorios.service.VendaServiceImpl;

@Path("/venda")
public class VendaController {

	VendaServiceImpl servico;

	public VendaController() {
		if (servico == null)
			servico = new VendaServiceImpl();

	}

	@GET
	@Path("/listProduto")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Produto> listarTodosProdutos() {

		return new ProdutoServiceImpl().consultarProduto();

	}

	@POST
	@Path("/salvarComissao")
	@Produces(MediaType.APPLICATION_JSON)
	public boolean salvarComissao(List<ProdutoComissao> produtosComissao) {

		return true;
	}

	@GET
	@Path("/listFuncionario")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Funcionario> listarTodos() {

		List<Funcionario> listaFuncionario = new FuncionarioServiceImpl()
				.consultarFuncionarios();

		return listaFuncionario;

	}

	@POST
	@Path("/CarregarListaOS")
	@Produces(MediaType.APPLICATION_JSON)
	public List<HistoricoVenda> consultarTodasOS(HistoricoVenda parametros) {
		return servico.consultarHistoricoVenda(parametros);

	}

	@POST
	@Path("/CarregarDetalhesOS")
	@Produces(MediaType.APPLICATION_JSON)
	public List<ItemVenda> CarregarDetalhesOS(Long codigoVenda) {
		List<ItemVenda> listaItens = new ArrayList<ItemVenda>();

		List<HistoricoProduto> listaProdutos = servico
				.consultarHistoricoProdutoPorCodigoVenda(codigoVenda);
		for (HistoricoProduto produto : listaProdutos) {
			ItemVenda item = new ItemVenda();
			item.setFuncionario(produto.getCodigoFuncionaio());
			item.setCodigo(produto.getCdProd());
			item.setTipo("p");
			item.setQuantidadeVenda(produto.getQtdProd());
			item.setGarantia(produto.getGarantiaProd());
			item.setValor(produto.getVlVenda());
			item.setModelo(new ProdutoServiceImpl()
					.consultarModeloProduto(produto.getCdProd()));
			item.setNoFuncionario(new FuncionarioServiceImpl()
					.consultarNomeFuncionario(produto.getCodigoFuncionaio()));
			listaItens.add(item);
		}
		List<HistoricoMaoDeObra> listaMaoObras = servico
				.consultarHistoricoMaoObraPorCodigoVenda(codigoVenda);
		for (HistoricoMaoDeObra mo : listaMaoObras) {
			ItemVenda item = new ItemVenda();
			item.setFuncionario(mo.getCodigoFuncionaio());
			item.setTipo("m");
			item.setValor(mo.getValorMO());
			item.setModelo(mo.getDescMO());
			item.setNoFuncionario(new FuncionarioServiceImpl()
					.consultarNomeFuncionario(mo.getCodigoFuncionaio()));
			listaItens.add(item);
		}

		return listaItens;

	}

	@GET
	@Path("/buscar/{codigo}")
	@Produces(MediaType.APPLICATION_JSON)
	public Funcionario consultar(@PathParam("codigo") long codigo) {

		Funcionario funcionario = new FuncionarioServiceImpl()
				.consultarFuncionario(codigo);
		return funcionario;
	}

	@GET
	@Path("/CarregarNumeroOS/")
	@Produces(MediaType.APPLICATION_JSON)
	public long consultar() {

		return new VendaServiceImpl().consultarNumeroOS();
	}

	public static void main(String[] args) {

	}

	public boolean registrarListaProduto(List<ItemVenda> lista, long codigoVenda) {
		boolean retorno = false;
		for (ItemVenda itemVenda : lista) {
			if (itemVenda.getTipo().equalsIgnoreCase("p")) {
				HistoricoProduto produto = new HistoricoProduto();
				produto.setCdProd(itemVenda.getCodigo());
				produto.setCodigoFuncionaio(itemVenda.getFuncionario());
				produto.setGarantiaProd(itemVenda.getGarantia());
				produto.setQtdProd(itemVenda.getQuantidadeVenda());
				produto.setVlVenda(itemVenda.getValor());
				produto.setCodigoVenda(codigoVenda);
				new ProdutoServiceImpl().saidaProdutoEstoque(
						produto.getCdProd(), produto.getQtdProd());
				retorno = servico.registrarProdutoHistorico(produto);
			} else {
				retorno = true;
			}
		}
		return retorno;
	}

	public boolean registrarListaMaoObra(List<ItemVenda> lista, long codigoVenda) {
		boolean retorno = false;
		for (ItemVenda itemVenda : lista) {
			if (itemVenda.getTipo().equals("m")) {
				HistoricoMaoDeObra mo = new HistoricoMaoDeObra();
				mo.setCodigoFuncionaio(itemVenda.getFuncionario());
				mo.setDescMO(itemVenda.getModelo());
				mo.setValorMO(itemVenda.getValor());
				mo.setCodigoVenda(codigoVenda);
				retorno = servico.registrarMaoDeObraHistorico(mo);
			} else {
				retorno = true;
			}
		}
		return retorno;
	}

	@POST
	@Path("/salvar")
	@Produces(MediaType.APPLICATION_JSON)
	public boolean registrarVenda(HistoricoVenda hvenda) {
		System.out.println(hvenda.toString());
		boolean retorno = false;
		if (hvenda.getListaItem() != null) {

			long codigoVenda = servico.registrarVenda(hvenda);

			if (codigoVenda != 0) {
				boolean vProd = registrarListaProduto(hvenda.getListaItem(),
						codigoVenda);
				boolean vMO = registrarListaMaoObra(hvenda.getListaItem(),
						codigoVenda);
				if (vProd == true && vMO == true)
					retorno = true;
			}
		}

		return retorno;
	}

	@POST
	@Path("/salvarOrcamento")
	@Produces(MediaType.APPLICATION_JSON)
	public boolean registrarOrcamento(Orcamento orcamento) {
		System.out.println(orcamento.toString());
		boolean retorno = false;
		if (orcamento.getListaItem() != null) {

			long codigoVenda = servico.registrarOrcamento(orcamento);

			if (codigoVenda != 0) {
				boolean vProd = registrarListaProdutoOrcamento(orcamento.getListaItem(),
						codigoVenda);
				boolean vMO = registrarListaMaoObraOrcamento(orcamento.getListaItem(),
						codigoVenda);
				if (vProd == true && vMO == true)
					retorno = true;
			}
		}

		return retorno;
	}

	public boolean registrarListaProdutoOrcamento(List<ItemVenda> lista,
			long codigoVenda) {
		boolean retorno = false;
		for (ItemVenda itemVenda : lista) {
			if (itemVenda.getTipo().equalsIgnoreCase("p")) {
				OrcamentoProduto produto = new OrcamentoProduto();
				produto.setCdProd(itemVenda.getCodigo());
				produto.setCodigoFuncionaio(itemVenda.getFuncionario());
				produto.setGarantiaProd(itemVenda.getGarantia());
				produto.setQtdProd(itemVenda.getQuantidadeVenda());
				produto.setVlVenda(itemVenda.getValor());
				produto.setCodigoVenda(codigoVenda);
				retorno = servico.registrarProdutoOrcamento(produto);
			} else {
				retorno = true;
			}
		}
		return retorno;
	}

	public boolean registrarListaMaoObraOrcamento(List<ItemVenda> lista,
			long codigoVenda) {
		boolean retorno = false;
		for (ItemVenda itemVenda : lista) {
			if (itemVenda.getTipo().equals("m")) {
				OrcamentoMaoDeObra mo = new OrcamentoMaoDeObra();
				mo.setCodigoFuncionaio(itemVenda.getFuncionario());
				mo.setDescMO(itemVenda.getModelo());
				mo.setValorMO(itemVenda.getValor());
				mo.setCodigoVenda(codigoVenda);
				retorno = servico.registrarMaoDeObraOrcamento(mo);
			} else {
				retorno = true;
			}
		}
		return retorno;
	}
	
	@POST
	@Path("/CarregarListaOrcamento")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Orcamento> listarTodasOrcamento(Orcamento parametros) {
		return servico.consultarOrcamento(parametros);

	}

	@POST
	@Path("/CarregarDetalhesOrcamento")
	@Produces(MediaType.APPLICATION_JSON)
	public List<ItemVenda> CarregarDetalhesOrcamento(Long codigoOrcamento) {
		List<ItemVenda> listaItens = new ArrayList<ItemVenda>();

		List<OrcamentoProduto> listaProdutos = servico
				.consultarOrcamentoProdutoPorCodigoVenda(codigoOrcamento);
		for (OrcamentoProduto produto : listaProdutos) {
			ItemVenda item = new ItemVenda();
			item.setFuncionario(produto.getCodigoFuncionaio());
			item.setCodigo(produto.getCdProd());
			item.setTipo("p");
			item.setQuantidadeVenda(produto.getQtdProd());
			item.setGarantia(produto.getGarantiaProd());
			item.setValor(produto.getVlVenda());
			item.setModelo(new ProdutoServiceImpl()
					.consultarModeloProduto(produto.getCdProd()));
			item.setNoFuncionario(new FuncionarioServiceImpl()
					.consultarNomeFuncionario(produto.getCodigoFuncionaio()));
			listaItens.add(item);
		}
		List<OrcamentoMaoDeObra> listaMaoObras = servico
				.consultarOrcamentoMaoObraPorCodigoVenda(codigoOrcamento);
		for (OrcamentoMaoDeObra mo : listaMaoObras) {
			ItemVenda item = new ItemVenda();
			item.setFuncionario(mo.getCodigoFuncionaio());
			item.setTipo("m");
			item.setValor(mo.getValorMO());
			item.setModelo(mo.getDescMO());
			item.setNoFuncionario(new FuncionarioServiceImpl()
					.consultarNomeFuncionario(mo.getCodigoFuncionaio()));
			listaItens.add(item);
		}

		return listaItens;

	}
	
	@POST
	@Path("/excluirOrcamento")
	@Produces(MediaType.APPLICATION_JSON)
	public boolean excluir ( Orcamento objeto) {

		return new VendaServiceImpl().removerItem(objeto);
	}
	
	@POST
	@Path("/excluirOS")
	@Produces(MediaType.APPLICATION_JSON)
	public boolean excluir ( HistoricoVenda objeto) {

		return new VendaServiceImpl().removerItem(objeto);
	}

}