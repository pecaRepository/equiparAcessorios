package br.com.equiparAcessorios.service;

import java.util.List;

import br.com.equiparAcessorios.entity.Fornecedor;

public interface FornecedorService {

	public boolean cadastrarFornecedor(Fornecedor fornecedor);

	public List<Fornecedor> consultarFornecedores();

	public boolean editarFornecedor(Fornecedor fornecedor);

	public boolean deletarFornecedor(Fornecedor fornecedor);
}
