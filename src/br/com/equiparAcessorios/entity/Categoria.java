package br.com.equiparAcessorios.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="CATEGORIA")
public class Categoria {

	@Id
	@SequenceGenerator(name="S_CATEGORIA", sequenceName="S_CATEGORIA", initialValue=1, allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "S_CATEGORIA")
	@Column(name="CD_CATEGORIA")
	private long codigo;
	
	@Column(name="NOME_CATEGORIA")
	private String nome;
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNome() {
		return nome;
	}
	public long getCodigo() {
		return codigo;
	}
	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

}
