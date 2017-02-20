package br.com.equiparAcessorios.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="LIGACAO")
public class Ligacao {
	
	@Id
	@SequenceGenerator(name="S_LIGACAO", sequenceName="S_LIGACAO", initialValue=1, allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "S_LIGACAO")
	@Column(name="CD_LIGACAO")
	private Long cdLigacao;
	
	@Column(name="CD_CLIENTE")
	private Long cdCliente;
	
	@Column(name="DT_LIGACAO")
	private Date dtLigacao;
	
	@Column(name="TITULO")
	private String titulo;
	
	@Column(name="DESCRICAO")
	private String descricao;

	public Date getDtLigacao() {
		return dtLigacao;
	}

	public void setDtLigacao(Date dtLigacao) {
		this.dtLigacao = dtLigacao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Long getCdCliente() {
		return cdCliente;
	}

	public void setCdCliente(Long cdCliente) {
		this.cdCliente = cdCliente;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Long getCdLigacao() {
		return cdLigacao;
	}

	public void setCdLigacao(Long cdLigacao) {
		this.cdLigacao = cdLigacao;
	}
	
	
}
