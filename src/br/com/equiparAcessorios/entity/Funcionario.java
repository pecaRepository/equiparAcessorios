package br.com.equiparAcessorios.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="FUNCIONARIO")
public class Funcionario {

	@Id
	@SequenceGenerator(name="S_FUNCIONARIO", sequenceName="S_FUNCIONARIO", initialValue=1, allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "S_FUNCIONARIO")
	@Column(name="CD_FUNCIONARIO")
	private long codigo;
	
	@Column(name="NOME")
	private String nome;
	
	@Column(name="APELIDO")
	private String apelido;
	
	@Column(name="CARGO")
	private String cargo;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="TELEFONE")
	private long telefone;
	
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
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public String getCargo() {
		return cargo;
	}
	public void setTelefone(long telefone) {
		this.telefone = telefone;
	}
	public long getTelefone() {
		return telefone;
	}
	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}
	public long getCodigo() {
		return codigo;
	}
	public String getApelido() {
		return apelido;
	}
	public void setApelido(String apelido) {
		this.apelido = apelido;
	}
	
}
