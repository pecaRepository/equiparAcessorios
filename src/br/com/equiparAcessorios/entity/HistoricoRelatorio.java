package br.com.equiparAcessorios.entity;

import java.util.Date;



public class HistoricoRelatorio {

	private String nomeProduto;
	private String nomeUsuario;
	private String nomeServico;
	private Date dataServico;
	private String cliente;
	private float valorServico;
	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}
	public String getNomeProduto() {
		return nomeProduto;
	}
	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}
	public String getNomeUsuario() {
		return nomeUsuario;
	}
	public void setNomeServico(String nomeServico) {
		this.nomeServico = nomeServico;
	}
	public String getNomeServico() {
		return nomeServico;
	}
	public void setDataServico(Date dataServico) {
		this.dataServico = dataServico;
	}
	public Date getDataServico() {
		return dataServico;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	public String getCliente() {
		return cliente;
	}
	public void setValorServico(float valorServico) {
		this.valorServico = valorServico;
	}
	public float getValorServico() {
		return valorServico;
	}

	
}
