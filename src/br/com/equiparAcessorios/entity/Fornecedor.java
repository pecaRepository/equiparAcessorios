package br.com.equiparAcessorios.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="FORNECEDOR")
public class Fornecedor {

	@Id
	@SequenceGenerator(name="S_FORNECEDOR", sequenceName="fornecedor_seq", initialValue=1, allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "S_FORNECEDOR")
	@Column(name="CD_FORNECEDOR")
	private long codigo;
	
	@Column(name="NOME_FORNECEDOR")
	private String nome;
	
	@Column(name="ENDERECO_FORNECEDOR")
	private String endereco;
	
	@Column(name="CNPJ_FORNECEDOR")
	private String cnpj;
	
	@Column(name="EMAIL_FORNECEDOR")
	private String email;
	
	@Column(name="TELEFONE_FORNECEDOR")
	private long telefone;
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNome() {
		return nome;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}
	public long getCodigo() {
		return codigo;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmail() {
		return email;
	}
	public void setTelefone(long telefone) {
		this.telefone = telefone;
	}
	public long getTelefone() {
		return telefone;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getEndereco() {
		return endereco;
	}
	
}
