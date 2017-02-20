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
@Table(name="HISTORICO_LIGACAO")
public class HistoricoLigacao {
	
	@Id
	@SequenceGenerator(name="S_HISTORICO_LIGACAO", sequenceName="S_HISTORICO_LIGACAO", initialValue=1, allocationSize=00001)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "S_HISTORICO_LIGACAO")
	@Column(name="CD_LIGACAO")
	private long cdLigacao;
	
	@Column(name="CD_CLIENTE")
	private long cdCliente;
	
	@Column(name="DATA")
	private Date data;
	
	@Column(name="TITULO")
	private String titulo;
	
	@Column(name="DESCRICAO")
	private String descricao;

	public long getCdLigacao() {
		return cdLigacao;
	}

	public void setCdLigacao(long cdLigacao) {
		this.cdLigacao = cdLigacao;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public long getCdCliente() {
		return cdCliente;
	}

	public void setCdCliente(long cdCliente) {
		this.cdCliente = cdCliente;
	}
	


		
}
