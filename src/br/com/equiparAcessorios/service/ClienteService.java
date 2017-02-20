package br.com.equiparAcessorios.service;

import java.util.List;

import br.com.equiparAcessorios.entity.Cliente;

public interface ClienteService {

	public List<Cliente> consultarClientes();
	public boolean cadastraCliente(Cliente cliente);
	public boolean editarCliente(Cliente cliente);
	public boolean deletarCliente(Cliente cliente);
	
	
}
