package br.com.equiparAcessorios.service;

import java.util.List;

import br.com.equiparAcessorios.entity.Funcionario;

public interface FuncionarioService {

	public List<Funcionario> consultarFuncionarios();
	public boolean cadastraFuncionario(Funcionario funcionario);
	public boolean editarFuncionario(Funcionario funcionario);
	public boolean deletarFuncionario(Funcionario funcionario);
	
}
