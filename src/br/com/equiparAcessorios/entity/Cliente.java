package br.com.equiparAcessorios.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="CLIENTE")
public class Cliente {
	
	@Override
	public String toString() {
		return "Cliente [cdCliente=" + getCdCliente() + ", nome=" + nome + ", cpf="
				+ cpf + ", endereco=" + endereco + ", cidade=" + cidade
				+ ", email=" + email + ", telefone=" + telefone + ", sexo="
				+ sexo + ", placa=" + placa + ", marca=" + marca + ", modelo="
				+ modelo + "]";
	}

	@Id
	@SequenceGenerator(name="S_CLIENTE", sequenceName="S_CLIENTE", initialValue=1, allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "S_CLIENTE")
	@Column(name="CD_CLIENTE")
	private long cdCliente;
	
	@Column(name="NOME")
	private String nome;
	
	@Column(name="CPF")
	private String cpf;
	
	@Column(name="ENDERECO")
	private String endereco;
	
	@Column(name="CIDADE")
	private String cidade;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="TELEFONE")
	private long telefone;
	
	@Column(name="SEXO")
	private String sexo;

	@Column(name="VEICULO_PLACA")
	private String placa;
	
	@Column(name="VEICULO_MARCA")
	private String marca;
	
	@Column(name="VEICULO_MODELO")
	private String modelo;


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getTelefone() {
		return telefone;
	}

	public void setTelefone(long telefone) {
		this.telefone = telefone;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public long getCdCliente() {
		return cdCliente;
	}

	public void setCdCliente(long cdCliente) {
		this.cdCliente = cdCliente;
	}

	
}
