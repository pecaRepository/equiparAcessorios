package br.com.equiparAcessorios.service;

import java.util.List;

import br.com.equiparAcessorios.entity.Produto;

public interface ProdutoService {

	public List<Produto> consultarProduto();
	public boolean cadastrarProduto(Produto produto);
	public boolean editarProduto(Produto produto);
	public boolean removerItem(Object objeto);
	public boolean cadastrarProdutoFornecedor(int codigoProduto, int codigoFornecedor, float valor);
	public boolean saidaProdutoEstoque(long codigoProduto, int quantidade);
	
}
