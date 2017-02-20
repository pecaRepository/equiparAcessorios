package br.com.equiparAcessorios.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="ORCAMENTO")
public class Orcamento {
	
	@Override
	public String toString() {
		return "Orcamento [codigoOrcamento=" + codigoOrcamento
				+ ", dataValidade=" + dataValidade + ", cpfCliente="
				+ cpfCliente + ", nomeCliente=" + nomeCliente
				+ ", telefoneCliente=" + telefoneCliente + ", veiculoPlaca="
				+ veiculoPlaca + ", veiculoMarca=" + veiculoMarca
				+ ", veiculoModelo=" + veiculoModelo + ", valorTotal="
				+ valorTotal + ", listaItem=" + listaItem + "]";
	}

	@Id
	@SequenceGenerator(name="S_ORCAMENTO", sequenceName="S_ORCAMENTO", initialValue=1, allocationSize=00001)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "S_ORCAMENTO")
	@Column(name="CD_ORCAMENTO")
	private long codigoOrcamento;
	
	@Column(name="DT_VALIDADE")
	private Date dataValidade;
	
	@Column(name="CPF_CLIENTE")
	private String cpfCliente;
	
	@Column(name="NOME_CLIENTE")
	private String nomeCliente;
	
	@Column(name="TELEFONE_CLIENTE")
	private long telefoneCliente;
	
	@Column(name="VEICULO_PLACA")
	private String veiculoPlaca;
	
	@Column(name="VEICULO_MARCA")
	private String veiculoMarca;
	
	@Column(name="VEICULO_MODELO")
	private String veiculoModelo;
	
	@Column(name="VALOR_TOTAL")
	private double valorTotal;
	
	@Transient
	private List<ItemVenda> listaItem;

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public String getCpfCliente() {
		return cpfCliente;
	}

	public void setCpfCliente(String cpfCliente) {
		this.cpfCliente = cpfCliente;
	}

	public String getVeiculoPlaca() {
		return veiculoPlaca;
	}

	public void setVeiculoPlaca(String veiculoPlaca) {
		this.veiculoPlaca = veiculoPlaca;
	}

	public String getVeiculoMarca() {
		return veiculoMarca;
	}

	public void setVeiculoMarca(String veiculoMarca) {
		this.veiculoMarca = veiculoMarca;
	}

	public String getVeiculoModelo() {
		return veiculoModelo;
	}

	public void setVeiculoModelo(String veiculoModelo) {
		this.veiculoModelo = veiculoModelo;
	}

	public long getTelefoneCliente() {
		return telefoneCliente;
	}

	public void setTelefoneCliente(long telefoneCliente) {
		this.telefoneCliente = telefoneCliente;
	}

	public List<ItemVenda> getListaItem() {
		return listaItem;
	}

	public void setListaItem(List<ItemVenda> listaItem) {
		this.listaItem = listaItem;
	}

	public long getCodigoOrcamento() {
		return codigoOrcamento;
	}

	public void setCodigoOrcamento(long codigoOrcamento) {
		this.codigoOrcamento = codigoOrcamento;
	}

	public Date getDataValidade() {
		return dataValidade;
	}

	public void setDataValidade(Date dataValidade) {
		this.dataValidade = dataValidade;
	}
	
	
}
