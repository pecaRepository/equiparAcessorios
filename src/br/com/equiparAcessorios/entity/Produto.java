package br.com.equiparAcessorios.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="PRODUTO")
public class Produto {

	@Id
	@SequenceGenerator(name="S_PRODUTO", sequenceName="produto_seq", allocationSize=1 , initialValue=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "S_PRODUTO")
	@Column(name="CD_PRODUTO")
	private long codigo;
	
	@Column(name="MODELO")
	private String modelo;
	
	@Column(name="CATEGORIA")
	private long categoria;
	
	@Column(name="MARCA")
	private String marca;
	
	@Column(name="VALOR")
	private double valor;
	
	@Column(name="QUANTIDADE")
	private long quantidade;
	
	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}
	public long getCodigo() {
		return codigo;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getMarca() {
		return marca;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public long getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(long quantidade) {
		this.quantidade = quantidade;
	}
	public long getCategoria() {
		return categoria;
	}
	public void setCategoria(long categoria) {
		this.categoria = categoria;
	}
	
	
}
