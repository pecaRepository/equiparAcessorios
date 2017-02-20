package br.com.equiparAcessorios.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="HISTORICO_MAO_OBRA")
public class HistoricoMaoDeObra {
	
	@Id
	@SequenceGenerator(name="S_HISTORICO_MAO_OBRA", sequenceName="S_HISTORICO_MAO_OBRA", initialValue=1, allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "S_HISTORICO_MAO_OBRA")
	@Column(name="CD_H_MO")
	private long cdHisMO;
	
	@Column(name="CD_HISTORICO_VENDA")
	private long codigoVenda;
	
	@Column(name="CD_FUNCIONARIO")
	private long codigoFuncionaio;
	
	@Column(name="VALOR_MO")
	private double valorMO;
	
	@Column(name="DESCRICAO_MO")
	private String descMO;
	
	

	@Override
	public String toString() {
		return "HistoricoMaoDeObra [cdHisMO=" + cdHisMO + ", codigoVenda="
				+ codigoVenda + ", codigoFuncionaio=" + codigoFuncionaio
				+ ", valorMO=" + valorMO + ", descMO=" + descMO + "]";
	}

	public long getCdHisMO() {
		return cdHisMO;
	}

	public void setCdHisMO(long cdHisMO) {
		this.cdHisMO = cdHisMO;
	}

	public double getValorMO() {
		return valorMO;
	}

	public void setValorMO(double valorMO) {
		this.valorMO = valorMO;
	}

	public String getDescMO() {
		return descMO;
	}

	public void setDescMO(String descMO) {
		this.descMO = descMO;
	}

	public long getCodigoFuncionaio() {
		return codigoFuncionaio;
	}

	public void setCodigoFuncionaio(long codigoFuncionaio) {
		this.codigoFuncionaio = codigoFuncionaio;
	}

	public long getCodigoVenda() {
		return codigoVenda;
	}

	public void setCodigoVenda(long codigoVenda) {
		this.codigoVenda = codigoVenda;
	}
	
}
