package br.com.equiparAcessorios.service;

import java.util.List;

import br.com.equiparAcessorios.entity.Cliente;
import br.com.equiparAcessorios.entity.Ligacao;
import br.com.equiparAcessorios.entity.Usuario;

public class ClienteServiceImpl implements ClienteService {

	Conexao conexao;
	Usuario usuario;
	
	public ClienteServiceImpl(){
		if (conexao == null) {
			conexao = new Conexao();
		}
	}
	
	public boolean registrarLigacao(Ligacao ligacao){
		boolean retorno = false;
		try {
			System.out.println("registrarLigacao--INICIO");
			conexao.persist(ligacao);
			retorno = true;
		} catch (Exception e) {
			e.printStackTrace();
			retorno = false;
		}
		System.out.println("registrarLigacao--FIM");
		return retorno;
	}
	
	public List<Ligacao> consultaLigacoes(long codigo){
		List<Ligacao> retorno = null;
		
		System.out.println("consultaLigacoes--INICIO");
		conexao.criarQuery(" SELECT li FROM Ligacao li where li.cdCliente = :pcdCliente");
		conexao.setParameter("pcdCliente", codigo);
		if(conexao.getResultList()!= null && conexao.getResultList().size() > 0)
			retorno = conexao.getResultList();
		
		System.out.println("consultaLigacoes--FIM");
		conexao.close();
		
		return retorno;
	}

	public List<Cliente> consultarClientes() {
		System.out.println("consultarClientes--INICIO");
		conexao.criarQuery(" SELECT cli FROM Cliente cli");
		List<Cliente> clientes = conexao.getResultList();
		System.out.println("consultarClientes--FIM");
		conexao.close();
		return clientes;
	}

	public boolean cadastraCliente(Cliente cliente) {
		boolean retorno = false;
		try {
			System.out.println("cadastraCliente--INICIO");
			conexao.persist(cliente);
			retorno = true;
		} catch (Exception e) {
			e.printStackTrace();
			retorno = false;
		}
		System.out.println("cadastraCliente--FIM");
		return retorno;
	}

	public boolean editarCliente(Cliente cliente) {
		boolean retorno = false;
		try {
			System.out.println("editarCliente--INICIO");
			conexao.merge(cliente);
			retorno = true;
		} catch (Exception e) {
			e.printStackTrace();
			retorno = false;
		}
		System.out.println("editarCliente--FIM");
		return retorno;
	}

	public boolean deletarCliente(Cliente cliente) {
		boolean retorno = false;
		try {
			System.out.println("deletarCliente--INICIO");
			conexao.remove(cliente);
			retorno = true;
		} catch (Exception e) {
			e.printStackTrace();
			retorno = false;
		}
		System.out.println("deletarCliente--FIM");
		return retorno;
	}

	public boolean removerItem(int codigoItem) {
		try {
			System.out.println("removerItem--INICIO");
			conexao.iniciarTransacao();
			conexao.getEm().remove(conexao.getEm().getReference(Cliente.class, codigoItem));
			conexao.fecharTransacao();
			System.out.println("removerItem--FIM");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("removerItem--FIM");
			return false;
		}

	}

	public static void main(String[] args) {	
		ClienteServiceImpl cli = new ClienteServiceImpl();
		List<Cliente> clientes = cli.consultarClientes();
		for (Cliente cliente : clientes) {
			System.out.println(cliente.getNome());
		}
		Cliente cliente = cli.consultarClientePorCPF("36289740890");
		System.out.println(cliente);
		System.out.println("ok");
	}
	
	public Cliente consultarClientePorCPF(String cpf) {
		System.out.println("ConsultarClientePorCPF--INICIO");
		Cliente retorno = null;
		if (!cpf.equals(null) || !cpf.equals("")) {
			try {
				conexao.criarQuery(" SELECT clie FROM Cliente clie where clie.cpf = :pValidar");
				conexao.setParameter("pValidar", cpf);
				if(conexao.getSingleResult() != null){
					Cliente clie = (Cliente) conexao.getSingleResult();
					retorno = clie;
				}else{
					return null;
				}
				System.out.println("ConsultarClientePorCPF--FIM");
			} catch (Exception e) {
				System.out.println("retorno: " + retorno);
				System.out.println("ConsultarClientePorCPF--FIM");
				return null;
			}

		}
		return retorno;
	}
	
	public Cliente consultarClientePorCodigo(Long codigo) {
		System.out.println("ConsultarClientePorCodigo--INICIO");
		Cliente retorno = null;
		if (!codigo.equals(null) || !codigo.equals("")) {
			try {
				conexao.criarQuery(" SELECT clie FROM Cliente clie where clie.cdCliente = :pValidar");
				conexao.setParameter("pValidar", codigo);
				if(conexao.getSingleResult() != null){
					Cliente clie = (Cliente) conexao.getSingleResult();
					retorno = clie;
				}else{
					return null;
				}
				System.out.println("ConsultarClientePorCodigo--FIM");
			} catch (Exception e) {
				System.out.println("retorno: " + retorno);
				System.out.println("ConsultarClientePorCodigo--FIM");
				return null;
			}

		}
		return retorno;
	}
}
