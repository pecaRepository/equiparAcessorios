package br.com.equiparAcessorios.service;

import java.util.List;

import br.com.equiparAcessorios.entity.Fornecedor;

public class FornecedorServiceImpl implements FornecedorService {

	Conexao conexao;
	
	public FornecedorServiceImpl(){
		if (conexao == null) {
			conexao = new Conexao();
		}
	}
	
	public boolean cadastrarFornecedor(Fornecedor fornecedor) {
		System.out.println("cadastrarFornecedor - INICIO");
		boolean retorno = false;
		try {
			conexao.persist(fornecedor);
			retorno = true;
		} catch (Exception e) {
			e.printStackTrace();
			retorno = false;
		}
		System.out.println("cadastrarFornecedor - FIM");
		return retorno;
	}
	
	public Fornecedor consultarFornecedor(Long codigo){
		System.out.println("ConsultarProduto--INICIO");
		try {

			conexao.criarQuery(" SELECT forn FROM Fornecedor forn where forn.codigo = :pcodigo");
			conexao.setParameter("pcodigo", codigo);
			Fornecedor fornecedor = (Fornecedor) conexao.getSingleResult();
			System.out.println("ConsultarFornecedor--FIM");
			return fornecedor;

		} catch (Exception e) {
			return null;
		}
	}
	
	public boolean removerItem(long codigo) {
		try {
			conexao.iniciarTransacao();
			conexao.getEm().remove(
					conexao.getEm().getReference(Fornecedor.class, codigo));
			conexao.fecharTransacao();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public List<Fornecedor> consultarFornecedores() {
		System.out.println("ConsultarFornecedor--INICIO");
		
		
		List<Fornecedor> fornecedor = null;
		try {
			conexao.criarQuery(" SELECT forn FROM Fornecedor forn");
			fornecedor = conexao.getResultList();

			System.out.println("ConsultarFornecedor--FIM");
			return fornecedor;
		} catch (Exception e) {
			System.out.println("ConsultarFornecedor--FIM");
			return fornecedor;
		}

	}

	public boolean editarFornecedor(Fornecedor fornecedor) {
		boolean retorno = false;
		try {
			conexao.merge(fornecedor);
			retorno = true;
		} catch (Exception e) {
			e.printStackTrace();
			retorno = false;
		}
		return retorno;
	}

	public boolean deletarFornecedor(Fornecedor fornecedor) {
		boolean retorno = false;
		try {
			conexao.remove(fornecedor);
			retorno = true;
		} catch (Exception e) {
			e.printStackTrace();
			retorno = false;
		}
		return retorno;
	}

	public boolean removerItem(int codigoItem) {
		try {
			
			conexao.iniciarTransacao();
			conexao.getEm().remove(conexao.getEm().getReference(Fornecedor.class, codigoItem));
			conexao.fecharTransacao();
			return true;
		} catch (Exception e) {
			return false;
		}

	}

}
