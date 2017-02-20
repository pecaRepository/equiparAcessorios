package br.com.equiparAcessorios.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="ORCAMENTO_PRODUTO")
public class OrcamentoProduto {
	
	@Id
	@SequenceGenerator(name="S_ORCAMENTO_PRODUTO", sequenceName="S_ORCAMENTO_PRODUTO", initialValue=1, allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "S_ORCAMENTO_PRODUTO")
	@Column(name="CD_H_PROD")
	private long codHisProd;
	
	@Column(name="CD_HISTORICO_VENDA")
	private long codigoVenda;
	
	@Column(name="CD_PROD")
	private long cdProd;
	
	@Column(name="CD_FUNCIONARIO")
	private long codigoFuncionaio;
	
	@Column(name="VL_VENDA")
	private double vlVenda;
	
	@Column(name="GARANTIA_PROD")
	private int garantiaProd;
	
	@Column(name="QTD_PROD")
	private int qtdProd;

	
	
	@Override
	public String toString() {
		return "HistoricoProduto [codHisProd=" + codHisProd + ", codigoVenda="
				+ codigoVenda + ", cdProd=" + cdProd + ", codigoFuncionaio="
				+ codigoFuncionaio + ", VlBase=" + ", VlVenda="
				+ getVlVenda() + ", garantiaProd=" + garantiaProd + "]";
	}

	public long getCodHisProd() {
		return codHisProd;
	}

	public void setCodHisProd(long codHisProd) {
		this.codHisProd = codHisProd;
	}

	public long getCdProd() {
		return cdProd;
	}

	public void setCdProd(long cdProd) {
		this.cdProd = cdProd;
	}

	public int getGarantiaProd() {
		return garantiaProd;
	}

	public void setGarantiaProd(int garantiaProd) {
		this.garantiaProd = garantiaProd;
	}

	public long getCodigoVenda() {
		return codigoVenda;
	}

	public void setCodigoVenda(long codigoVenda) {
		this.codigoVenda = codigoVenda;
	}

	public long getCodigoFuncionaio() {
		return codigoFuncionaio;
	}

	public void setCodigoFuncionaio(long codigoFuncionaio) {
		this.codigoFuncionaio = codigoFuncionaio;
	}

	public int getQtdProd() {
		return qtdProd;
	}

	public void setQtdProd(int qtdProd) {
		this.qtdProd = qtdProd;
	}

	public double getVlVenda() {
		return vlVenda;
	}

	public void setVlVenda(double vlVenda) {
		this.vlVenda = vlVenda;
	}

	
}
