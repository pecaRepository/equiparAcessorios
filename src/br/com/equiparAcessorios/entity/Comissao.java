package br.com.equiparAcessorios.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="COMISSAO")
public class Comissao {

	@Id
	@SequenceGenerator(name="S_COMISSAO", sequenceName="S_COMISSAO", initialValue=1, allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "S_COMISSAO")
	@Column(name="CD_COMISSAO")
	private long codigo;
	
	@Column(name="CD_PRODUTO")
	private Long cdProduto;
	
	@Column(name="CD_FUNCIONARIO")
	private Long cdFuncionario;

	@Column(name="COMISSAO")
	private double comissao;
	
	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

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
	
	
}
