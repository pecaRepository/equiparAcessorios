package br.com.equiparAcessorios.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import br.com.equiparAcessorios.entity.Cliente;
import br.com.equiparAcessorios.entity.Permissao;
import br.com.equiparAcessorios.entity.Usuario;


public class UsuarioServiceImpl implements UsuarioService {

	Cliente cliente;
	Conexao conexao;
	private Logger log = Logger.getLogger(UsuarioServiceImpl.class);

	public UsuarioServiceImpl() {
		if (conexao == null) {
			conexao = new Conexao();
		}
	}

	public int consultarCodigoUsuario(String login, String senha) {
		System.out.println("ConsultarUsuario--INICIO");
		try {
			conexao.iniciarTransacao();
			conexao.fecharTransacao();
			conexao.criarQuery(" SELECT user.codigo FROM Usuario user where user.login = :pValidar AND user.senha = :pValidar2");
			conexao.setParameter("pValidar", login);
			conexao.setParameter("pValidar2", senha);
			List<Integer> usuario = conexao.getResultList();

			for (Integer user : usuario) {
				System.out.println("\nCliente:\n" + user);
			}
			int retorno = Integer.parseInt(usuario.get(0).toString());
			System.out.println("ConsultarUsuario--FIM");
			return retorno;

		} catch (Exception e) {
			System.out.println("ConsultarUsuario--FIM");
			return 0;
		}
	}

	public int consultarUsuario(String login) {
		System.out.println("ConsultarUsuario--INICIO");
		try {
			String validar = login;
			conexao.criarQuery(" SELECT user.codigo FROM Usuario user where user.login = :pValidar");
			conexao.setParameter("pValidar", validar);
			List<Integer> usuario = conexao.getResultList();

			int retorno = Integer.parseInt(usuario.get(0).toString());
			System.out.println("ConsultarUsuario--FIM");
			return retorno;

		} catch (Exception e) {
			System.out.println("ConsultarUsuario--FIM");
			return 0;
		}
	}

	public String consultarNomeUsuario(int codigoLogin) {
		System.out.println("ConsultarUsuario--INICIO");
		try {
			conexao.criarQuery(" SELECT user.nome FROM Usuario user where user.codigo = :pValidar");
			conexao.setParameter("pValidar", codigoLogin);
			List<String> usuario = conexao.getResultList();

			String retorno = usuario.get(0);
			System.out.println("ConsultarUsuario--FIM");
			return retorno;

		} catch (Exception e) {
			System.out.println("ConsultarUsuario--FIM");
			return null;
		}
	}

	public boolean CadastrarUsuario(Usuario usuario) throws SQLException,
			Exception {

		log.info(this.getClass().getName() + " - cadastrarUsuario - INICIO");

		boolean retorno = false;
		if (!usuario.equals(null)) {
			UsuarioServiceImpl servico = new UsuarioServiceImpl();
			if (servico.validarUsuario(usuario.getLogin(), usuario.getSenha()) == 0) {
				conexao.getEm().persist(usuario);
				conexao.iniciarTransacao();
				conexao.fecharTransacao();
				retorno = true;
			} else {
				System.out.println("Usuario: " + usuario.getLogin()
						+ " ja cadastrado!");
			}
		}

		log.info(this.getClass().getName() + " - cadastrarUsuario - FIM");
		return retorno;
	}

	public int validarUsuario(String login, String senha) throws Exception {

		// System.out.println("LogarUsuario--INICIO");
		log.info(this.getClass().getName() + " - logarUsuario - INICIO");

		int retorno = 0;
		try {
			conexao.criarQuery(" SELECT user FROM Usuario user where user.login = :pValidar and user.senha = :pValidar2");
			login = login.toLowerCase();
			senha = senha.toLowerCase();
			conexao.setParameter("pValidar", login);
			conexao.setParameter("pValidar2", senha);
			List<Usuario> usuarios = conexao.getResultList();
			if (usuarios.size() != 0) {
				retorno = 1;
			} else {
				retorno = 0;
			}
			return retorno;
		} catch (Exception e) {
			e.printStackTrace();
		}
		// System.out.println("LogarUsuario--FIM");
		log.info(this.getClass().getName() + " - logarUsuario - FIM");
		return 0;
	}

	public boolean editarUsuario(Usuario usuario) {
		log.info(this.getClass().getName() + " - editarUsuario - INICIO");
		boolean retorno = false;
		try {
			conexao.getEm().merge(usuario);
			conexao.iniciarTransacao();
			conexao.fecharTransacao();
			retorno = true;
		} catch (Exception e) {
			e.printStackTrace();

		}
		// System.out.println("LogarUsuario--FIM");
		log.info(this.getClass().getName() + " - logarUsuario - FIM");
		return retorno;
	}

	public boolean deletarUsuario(Usuario usuario) {
		return false;
	}

	public boolean cadastrarPermissaoUsuario(Permissao permissao) {
		return false;
	}

	public boolean removerItem(int codigoItem) {
		try {
			conexao.iniciarTransacao();
			conexao.getEm().remove(conexao.getEm().getReference(Usuario.class, codigoItem));
			conexao.fecharTransacao();
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public static void main(String[] args) {
		try {

			Usuario usuario = new Usuario();
			usuario.setNome("Administrador");
			usuario.setLogin("tpeca");
			usuario.setSenha("251");
			usuario.setEmail("admin@gmail.com.br");
			UsuarioServiceImpl servico = new UsuarioServiceImpl();
			servico.consultarCodigoUsuario(usuario.getLogin(),
					usuario.getSenha());
			System.out.println(servico.consultarUsuario(usuario.getLogin()));
			System.out.println(servico.consultarNomeUsuario(1));
			System.out.println(servico.validarUsuario(usuario.getLogin(),
					usuario.getSenha()));
			System.out.println(servico.editarUsuario(usuario));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
