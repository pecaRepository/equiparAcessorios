package br.com.equiparAcessorios.entity;

public class ProdutoComissao {
	
	private Long codigo;
	private Long cdProduto;
	private Long cdFuncionario;
	private double comissao;
	
	private String modelo;
	private long categoria;
	private String marca;
	private double valor;
	
	
	public Long getCdProduto() {
		return cdProduto;
	}
	public void setCdProduto(Long cdProduto) {
		this.cdProduto = cdProduto;
	}
	public Long getCdFuncionario() {
		return cdFuncionario;
	}
	public void setCdFuncionario(Long cdFuncionario) {
		this.cdFuncionario = cdFuncionario;
	}
	public double getComissao() {
		return comissao;
	}
	public void setComissao(double comissao) {
		this.comissao = comissao;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public long getCategoria() {
		return categoria;
	}
	public void setCategoria(long categoria) {
		this.categoria = categoria;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

}
