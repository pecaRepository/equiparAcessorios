package br.com.equiparAcessorios.service;

public class VendaBean {

	
	@Override
	public String toString() {
		return "VendaBean [Nome=" + Nome + ", valor=" + valor + ", garantia="
				+ garantia + ", funcionario=" + funcionario + ", tipo=" + tipo
				+ ", editavel=" + editavel + ", nomeFuncionario="
				+ nomeFuncionario + "]";
	}
	private String Nome;
	private double valor;
	private int garantia;
	private long funcionario;
	private String tipo;
	private boolean editavel;
	private String nomeFuncionario;
	
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public int getGarantia() {
		return garantia;
	}
	public void setGarantia(int garantia) {
		this.garantia = garantia;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public boolean isEditavel() {
		return editavel;
	}
	public void setEditavel(boolean editavel) {
		this.editavel = editavel;
	}
	public long getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(long funcionario) {
		this.funcionario = funcionario;
	}
	public String getNomeFuncionario() {
		return nomeFuncionario;
	}
	public void setNomeFuncionario(String nomeFuncionario) {
		this.nomeFuncionario = nomeFuncionario;
	}
}
