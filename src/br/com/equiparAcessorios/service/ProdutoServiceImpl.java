package br.com.equiparAcessorios.service;

import java.util.ArrayList;
import java.util.List;

import br.com.equiparAcessorios.entity.Categoria;
import br.com.equiparAcessorios.entity.Comissao;

import br.com.equiparAcessorios.entity.Fornecedor;
import br.com.equiparAcessorios.entity.Produto;

public class ProdutoServiceImpl implements ProdutoService {

	Fornecedor fornecedor;
	Conexao conexao;

	public ProdutoServiceImpl() {
		if (conexao == null) {
			conexao = new Conexao();
		}
	}

	public int consultarCodigoProduto(String produto) {
		int retorno = 0;
		try {
			conexao.criarQuery(" SELECT prod.codigo FROM Produto prod where prod.nome = :pValidar");
			conexao.setParameter("pValidar", produto);
			List<Integer> prod = conexao.getResultList();
			retorno = Integer.parseInt(prod.get(0).toString());
			System.out.println("ConsultarProduto--FIM");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return retorno;
	}

	public Produto consultarProduto(long codigo) {
		System.out.println("ConsultarProduto--INICIO");

		Produto retorno = null;

		if (codigo != 0) {

			try {
				conexao.criarQuery(" SELECT prod FROM Produto prod where prod.codigo = :pValidar");
				conexao.setParameter("pValidar", codigo);
				List<Produto> prod = conexao.getResultList();
				retorno = prod.get(0);
				System.out.println("ConsultarProduto--FIM");

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return retorno;
	}
	
	public Categoria consultarCategoria(long codigo) {
		System.out.println("ConsultarProduto--INICIO");

		Categoria retorno = null;

		if (codigo != 0) {

			try {
				conexao.criarQuery(" SELECT cat FROM Categoria cat where cat.codigo = :pValidar");
				conexao.setParameter("pValidar", codigo);
				retorno = (Categoria)conexao.getSingleResult();
				System.out.println("ConsultarProduto--FIM");

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return retorno;
	}
	

	public String consultarModeloProduto(long codigoProduto) {
		System.out.println("ConsultarProduto--INICIO");
		try {

			conexao.criarQuery(" SELECT prod.modelo FROM Produto prod where prod.codigo = :pValidar");
			conexao.setParameter("pValidar", codigoProduto);
			List<String> prod = conexao.getResultList();
			String retorno = prod.get(0);
			System.out.println("ConsultarProduto--FIM");
			return retorno;

		} catch (Exception e) {
			return null;
		}
	}

	public List<Produto> consultarProduto() {
		System.out.println("ConsultarProduto--INICIO");
		try {

			conexao.criarQuery(" SELECT prod FROM Produto prod");
			List<Produto> produtos = conexao.getResultList();
			System.out.println("ConsultarProduto--FIM");

			// Collections.sort(produtos, Comparator<T>);
			return produtos;

		} catch (Exception e) {
			return null;
		}
	}
	
	public List<Comissao> consultarProdutoComissao(Long cdFuncionario) {
		System.out.println("ConsultarProduto--INICIO");
		try {

			conexao.criarQuery(" SELECT prod FROM Comissao prod where prod.cdFuncionario = :pcdFuncionario");
			conexao.setParameter("pcdFuncionario", cdFuncionario);
			List<Comissao> produtos = conexao.getResultList();
			System.out.println("ConsultarProduto--FIM");

			// Collections.sort(produtos, Comparator<T>);
			return produtos;

		} catch (Exception e) {
			return null;
		}
	}
	
	public List<Categoria> consultarCategorias() {
		System.out.println("ConsultarCategoria--INICIO");
		try {

			conexao.criarQuery(" SELECT cat FROM Categoria cat");
			List<Categoria> categorias = conexao.getResultList();
			System.out.println("ConsultarCategoria--FIM");
			return categorias;

		} catch (Exception e) {
			return null;
		}

	}

	public boolean cadastrarProduto(Produto produto) {
		boolean retorno = false;
		try {
			conexao.persist(produto);
			retorno = true;
		} catch (Exception e) {
			e.printStackTrace();
			retorno = false;
		}
		return retorno;
	}

	public boolean editarProduto(Produto produto) {
		System.out.println("editarProduto--INICIO");
		boolean retorno = false;
		try {
			conexao.merge(produto);
			retorno = true;
		} catch (Exception e) {
			e.printStackTrace();
			retorno = false;
		}
		System.out.println("editarProduto--FIM");
		return retorno;

	}
	
	public boolean editarCategoria(Categoria categoria) {
		System.out.println("editarProduto--INICIO");
		boolean retorno = false;
		try {
			conexao.merge(categoria);
			retorno = true;
		} catch (Exception e) {
			e.printStackTrace();
			retorno = false;
		}
		System.out.println("editarProduto--FIM");
		return retorno;

	}
	
	
	public boolean salvarComissao(List<Comissao> listaProdutoComissao, long funcionario) {
		System.out.println("SalvarComissao--INICIO");
		boolean retorno = false;
		try {
			if(funcionario != 0){
				removerComissaoFuncionario(funcionario);	
				for (Comissao comissao : listaProdutoComissao) {
					conexao.persist(comissao);
				}
				conexao.iniciarTransacao();
				conexao.fecharTransacao();
				retorno = true;
				
			}else{
				return false;
			}
			
		} catch (Exception e) {
			conexao.getEm().getTransaction().rollback();
//			conexao.fecharTransacao();
			e.printStackTrace();
			retorno = false;
		}finally{
			conexao.close();
		}
		System.out.println("SalvarComissao--FIM");
		return retorno;
	}
	
	public boolean removerComissaoFuncionario(long funcionario){
		try {
			
			conexao.criarQuery("DELETE FROM Comissao c where c.cdFuncionario = :funcionario");
			conexao.setParameter("funcionario", funcionario );
			conexao.executaQuery();
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean removerItem(Object objeto) {
		boolean retorno = false;
		try {
			conexao.remove(objeto);
			retorno = true;
		} catch (Exception e) {
			e.printStackTrace();
			retorno = false;
		}
		return retorno;
	}



	public boolean saidaProdutoEstoque(long codigoProduto, int quantidade) {
		try {

			Produto produto = consultarProduto(codigoProduto);
			if (null != produto) {
				produto.setQuantidade(produto.getQuantidade() - quantidade);
				conexao.merge(produto);
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			return false;
		}
	}

	public boolean cadastrarProdutoFornecedor(int codigoProduto,
			int codigoFornecedor, float valor) {
		return false;
	}



	@SuppressWarnings("finally")
	public List<Produto> consultaProdutosPorMarca(String marca) {
		System.out.println("ConsultarProdutoPorMarca--INICIO");

		List<Produto> retorno = new ArrayList<Produto>();
		try {
			conexao.setParameter("marca", marca);
			retorno = conexao.getResultList();
		} catch (Exception e) {

		} finally {
			System.out.println("ConsultarProdutoPorMarca--FIM");
			return retorno;
		}

	}

	public static String excluirUltimaLetra(String texto) {
		int length = texto.length();
		return texto.substring(0, length - 1);
	}
	
	public boolean cadastrarCategoria(Categoria categoria){
		boolean retorno = false;
		try {
			conexao.persist(categoria);
			retorno = true;
		} catch (Exception e) {
			e.printStackTrace();
			retorno = false;
		}
		return retorno;
	}


	public static void main(String[] args) {
		ArrayList<Comissao> listaProdutoComissao = new ArrayList<Comissao>();
		long funcionario = 1;
		Comissao comissao = new Comissao();
		comissao.setCdFuncionario(1L);
		comissao.setCdProduto(22L);
		comissao.setComissao(2);
		listaProdutoComissao.add(comissao);
		
		Comissao comissao2 = new Comissao();
		comissao2.setCdFuncionario(1L);
		comissao2.setCdProduto(22L);
		comissao2.setComissao(2);
		listaProdutoComissao.add(comissao2);
		System.out.println(new ProdutoServiceImpl().salvarComissao(listaProdutoComissao, funcionario));	
		
	}



}
