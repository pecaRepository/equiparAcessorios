package br.com.equiparAcessorios.service;

import java.sql.SQLException;

import br.com.equiparAcessorios.entity.Permissao;
import br.com.equiparAcessorios.entity.Usuario;

public interface UsuarioService {

	public int validarUsuario(String usuario, String senha) throws Exception;
	public boolean CadastrarUsuario(Usuario usuario)throws SQLException,
	Exception;
	public boolean editarUsuario(Usuario usuario);
	public boolean deletarUsuario(Usuario usuario);
	public boolean cadastrarPermissaoUsuario(Permissao permissao);
}
