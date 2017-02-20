package br.com.equiparAcessorios.service;

import java.util.List;

import br.com.equiparAcessorios.entity.Funcionario;

public class FuncionarioServiceImpl implements FuncionarioService {

	Conexao conexao;
	
	public FuncionarioServiceImpl() {
		if (conexao == null) {
			conexao = new Conexao();
		}
	}
	

	public List<Funcionario> consultarFuncionarios() {
		conexao.criarQuery(" SELECT func FROM Funcionario func");
		List<Funcionario> funcionarios = conexao.getResultList();
		return funcionarios;
	}
	
	public String consultarNomeFuncionario(Long codigoFuncionario){
		System.out.println("ConsultarProduto--INICIO");
		try {

			conexao.criarQuery(" SELECT fun.nome FROM Funcionario fun where fun.codigo = :pcodigoFuncionario");
			conexao.setParameter("pcodigoFuncionario", codigoFuncionario);
			String funcionario = (String) conexao.getSingleResult();
			System.out.println("ConsultarProduto--FIM");
			return funcionario;

		} catch (Exception e) {
			return null;
		}
	}
	
	public Funcionario consultarFuncionario(Long codigo){
		System.out.println("ConsultarProduto--INICIO");
		try {

			conexao.criarQuery(" SELECT fun FROM Funcionario fun where fun.codigo = :pcodigoFuncionario");
			conexao.setParameter("pcodigoFuncionario", codigo);
			Funcionario funcionario = (Funcionario) conexao.getSingleResult();
			System.out.println("ConsultarProduto--FIM");
			return funcionario;

		} catch (Exception e) {
			return null;
		}
	}
	
	public boolean removerItem(long codigo) {
		try {
			conexao.iniciarTransacao();
			conexao.getEm().remove(
					conexao.getEm().getReference(Funcionario.class, codigo));
			conexao.fecharTransacao();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean cadastraFuncionario(Funcionario funcionario) {
		boolean retorno = false;
		try {
			conexao.persist(funcionario);
			retorno = true;
		} catch (Exception e) {
			e.printStackTrace();
			retorno = false;
		}
		return retorno;
	}


	public boolean editarFuncionario(Funcionario funcionario) {
		boolean retorno = false;
		try {
			conexao.merge(funcionario);
			retorno = true;
		} catch (Exception e) {
			e.printStackTrace();
			retorno = false;
		}
		return retorno;
	}
	
	


	public boolean deletarFuncionario(Funcionario funcionario) {
		boolean retorno = false;
		try {
			conexao.remove(funcionario);
			retorno = true;
		} catch (Exception e) {
			e.printStackTrace();
			retorno = false;
		}
		return retorno;
	}

}
