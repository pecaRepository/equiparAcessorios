package br.com.equiparAcessorios.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="PERMISSAO")
public class Permissao {

	@Id
	@SequenceGenerator(name="S_PERMISSAO", sequenceName="permissao_seq", initialValue=1, allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "S_PERMISSAO")
	@Column(name="CD_PERMISSAO")
	private int codigo;
	
	@Column(name="NOME_PERMISSAO")
	private String nome;
	
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
}
