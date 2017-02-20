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
@Table(name="HISTORICO_VENDA")
public class HistoricoVenda {
	
	@Id
	@SequenceGenerator(name="S_HISTORICO_VENDA", sequenceName="S_HISTORICO_VENDA", initialValue=1, allocationSize=00001)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "S_HISTORICO_VENDA")
	@Column(name="CD_VENDA")
	private long codigoVenda;
	
	@Column(name="NUMERO_OS")
	private Long numeroOS;
	
	@Column(name="DT_VENDA")
	private Date dataVenda;
	
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

	public long getCodigoVenda() {
		return codigoVenda;
	}

	public void setCodigoVenda(long codigoVenda) {
		this.codigoVenda = codigoVenda;
	}

	public Date getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(Date dataVenda) {
		this.dataVenda = dataVenda;
	}

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

	public Long getNumeroOS() {
		return numeroOS;
	}

	public void setNumeroOS(Long numeroOS) {
		this.numeroOS = numeroOS;
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

	@Override
	public String toString() {
		return "HistoricoVenda [codigoVenda=" + codigoVenda + ", numeroOS="
				+ numeroOS + ", dataVenda=" + dataVenda + ", cpfCliente="
				+ cpfCliente + ", nomeCliente=" + nomeCliente
				+ ", veiculoPlaca=" + veiculoPlaca + ", veiculoMarca="
				+ veiculoMarca + ", veiculoModelo=" + veiculoModelo
				+ ", valorTotal=" + valorTotal + "]";
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
	
	
}
