

package br.com.equiparAcessorios.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="USUARIO")
public class Usuario{
	
	@Id
	@SequenceGenerator(name="S_USUARIO", sequenceName="usuario_seq", allocationSize=1 , initialValue=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "S_USUARIO")
	@Column(name="CD_USUARIO")
	private int codigo;
	
	@Column(name="NOME_USUARIO")
	private String nome;
	
	@Column(name="EMAIL_USUARIO")
	private String email;
	
	@Column(name="LOGIN_USUARIO")
	private String login;
	
	@Column(name="SENHA_USUARIO")
	private String senha;
	
	@Column(name="CD_PERMISSAO")
	private int codigoPermissao;
	

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getLogin() {
		return login;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getSenha() {
		return senha;
	}

	public void setCodigoPermissao(int codigoPermissao) {
		this.codigoPermissao = codigoPermissao;
	}

	public int getCodigoPermissao() {
		return codigoPermissao;
	}
}
