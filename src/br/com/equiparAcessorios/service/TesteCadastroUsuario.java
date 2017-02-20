package br.com.equiparAcessorios.service;

import java.sql.SQLException;

import br.com.equiparAcessorios.entity.Usuario;

public class TesteCadastroUsuario {

	/**
	 * @param args
	 * @throws Exception 
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException, Exception {
		Usuario usuario = new Usuario();
		usuario.setNome("Tiago Peca");
		usuario.setSenha("251");
		usuario.setEmail("tiagopeca7@gmail.com");
		new UsuarioServiceImpl().CadastrarUsuario(usuario);

	}
	
	

}
