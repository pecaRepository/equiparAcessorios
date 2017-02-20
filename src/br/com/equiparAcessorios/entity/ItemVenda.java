package br.com.equiparAcessorios.entity;

public class ItemVenda {

	
	@Override
	public String toString() {
		return "ItemVenda [modelo=" + modelo + ", quantidadeVenda="
				+ quantidadeVenda + ", valor=" + valor + ", garantia="
				+ garantia + ", funcionario=" + getFuncionario() + ", tipo=" + tipo
				+ "]";
	}
	private String modelo;
	private int quantidadeVenda;
	private int quantidade;
	private double valor;
	private int garantia;
	private long funcionario;
	private String noFuncionario;
	private String tipo;
	private Long codigo;

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
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public int getQuantidadeVenda() {
		return quantidadeVenda;
	}
	public void setQuantidadeVenda(int quantidadeVenda) {
		this.quantidadeVenda = quantidadeVenda;
	}
	public long getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(long funcionario) {
		this.funcionario = funcionario;
	}
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public String getNoFuncionario() {
		return noFuncionario;
	}
	public void setNoFuncionario(String noFuncionario) {
		this.noFuncionario = noFuncionario;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	} 
}
