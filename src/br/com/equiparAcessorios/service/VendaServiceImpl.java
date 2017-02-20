package br.com.equiparAcessorios.service;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import br.com.equiparAcessorios.entity.HistoricoMaoDeObra;
import br.com.equiparAcessorios.entity.HistoricoProduto;
import br.com.equiparAcessorios.entity.HistoricoVenda;
import br.com.equiparAcessorios.entity.Orcamento;
import br.com.equiparAcessorios.entity.OrcamentoMaoDeObra;
import br.com.equiparAcessorios.entity.OrcamentoProduto;

public class VendaServiceImpl implements VendaService {

	Conexao conexao;

	public VendaServiceImpl() {
		if (conexao == null) {
			conexao = new Conexao();
		}
	}

	public long registrarVenda(HistoricoVenda hvenda) {
		System.out.println("registrarServico--INICIO");

		try {
			conexao.persist(hvenda);
			System.out.println("registrarServico--FIM");
			return hvenda.getCodigoVenda();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("registrarServico--FIM");
			return hvenda.getCodigoVenda();
		}
	}
	
	public long registrarOrcamento(Orcamento orcamento) {
		System.out.println("registrarServico--INICIO");

		try {
			conexao.persist(orcamento);
			System.out.println("registrarServico--FIM");
			return orcamento.getCodigoOrcamento();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("registrarServico--FIM");
			return orcamento.getCodigoOrcamento();
		}
	}

	public boolean registrarMaoDeObraHistorico(HistoricoMaoDeObra mo) {
		System.out.println("registrarMaoDeObraHistorico--INICIO");

		boolean retorno = false;
		try {
			conexao.persist(mo);
			retorno = true;
			System.out.println("registrarMaoDeObraHistorico--FIM");
		} catch (Exception e) {
			System.out.println("registrarMaoDeObraHistorico--FIM");
		}

		return retorno;
	}

	public boolean registrarProdutoHistorico(HistoricoProduto hProduto) {
		System.out.println("registrarProdutoHistorico--INICIO");

		boolean retorno = false;
		try {
			conexao.persist(hProduto);
			retorno = true;
			System.out.println("registrarProdutoHistorico--FIM");
		} catch (Exception e) {
			System.out.println("registrarProdutoHistorico--FIM");
		}
		return retorno;
	}
	
	public List<HistoricoVenda> consultarHistoricoVenda(HistoricoVenda venda){
		
		StringBuilder sql = new StringBuilder("SELECT A FROM HistoricoVenda A WHERE 1=1 ");
		if(venda.getNumeroOS() != null && venda.getNumeroOS() != 0l)
			sql.append(" AND A.numeroOS = :numeroOS ");
		
		if(venda.getDataVenda() != null)
			sql.append(" AND A.dataVenda between :dataVendaInicial and :dataVendaFinal ");
		
		if(venda.getCpfCliente() != null && !venda.getCpfCliente().equals(""))
			sql.append(" AND A.cpfCliente = :cpfCliente ");
		
		if(venda.getNomeCliente() != null && !venda.getNomeCliente().equals(""))
			sql.append(" AND A.nomeCliente like :cliente");
		
		if(venda.getVeiculoModelo() != null && !venda.getVeiculoModelo().equals(""))
			sql.append("AND A.veiculoModelo = :modelo");
			
		sql.append(" ORDER BY A.dataVenda desc");
		String sql2 = sql.toString();
		System.out.println(sql2);
		conexao.criarQuery(sql2);
		
		if(venda.getNumeroOS() != null && venda.getNumeroOS() != 0l)
			conexao.setParameter("numeroOS", venda.getNumeroOS());
			
		
		if(venda.getDataVenda() != null){
			Date dataNova = new Date(venda.getDataVenda().getTime());
			Calendar dataInicial = new GregorianCalendar();
			dataInicial.setTime(dataNova);
			dataInicial.set(Calendar.HOUR, 01);
			dataInicial.set(Calendar.MINUTE, 00);
			dataInicial.set(Calendar.SECOND, 00);
			SimpleDateFormat dt = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			System.out.println(dt.format(dataInicial.getTime()));
			conexao.setParameter("dataVendaInicial", dataInicial.getTime());	
			Calendar dataFinal = new GregorianCalendar();
			dataFinal.setTime(dataNova);
			dataFinal.set(Calendar.HOUR, 23);
			dataFinal.set(Calendar.MINUTE, 59);
			dataFinal.set(Calendar.SECOND, 59);
			conexao.setParameter("dataVendaFinal", dataFinal.getTime());
			System.out.println(dt.format(dataFinal.getTime()));
		}
			
		
		if(venda.getCpfCliente() != null && !venda.getCpfCliente().equals(""))
			conexao.setParameter("cpfCliente", venda.getCpfCliente());
		
		if(venda.getNomeCliente() != null && !venda.getNomeCliente().equals(""))
			conexao.setParameter("cliente", venda.getNomeCliente().toLowerCase() + "%");
		
		if(venda.getVeiculoModelo() != null && !venda.getVeiculoModelo().equals(""))
			conexao.setParameter("modelo", venda.getVeiculoModelo());
		
		List<HistoricoVenda> lista = conexao.getResultList();
		return lista;
		
	}
	
public List<Orcamento> consultarOrcamento(Orcamento orcamento){
		
		StringBuilder sql = new StringBuilder("SELECT A FROM Orcamento A WHERE 1=1 ");
		
		if(orcamento.getCodigoOrcamento() != 0)
			sql.append(" AND A.codigoOrcamento = :codigoOrcamento ");
		
		if(orcamento.getDataValidade() != null)
			sql.append(" AND A.dataValidade between :dataValidadeInicial and :dataValidadeFinal ");
		
		if(orcamento.getCpfCliente() != null && !orcamento.getCpfCliente().equals(""))
			sql.append(" AND A.cpfCliente = :cpfCliente ");
		
		if(orcamento.getNomeCliente() != null && !orcamento.getNomeCliente().equals(""))
			sql.append(" AND A.nomeCliente like :cliente");
		
		if(orcamento.getVeiculoModelo() != null && !orcamento.getVeiculoModelo().equals(""))
			sql.append("AND A.veiculoModelo = :modelo");
			
		sql.append(" ORDER BY A.dataValidade desc");
		String sql2 = sql.toString();
		conexao.criarQuery(sql2);
		
			
		
		if(orcamento.getDataValidade() != null){
			Date dataNova = new Date(orcamento.getDataValidade().getTime());
			Calendar dataInicial = new GregorianCalendar();
			dataInicial.setTime(dataNova);
			dataInicial.set(Calendar.HOUR, 01);
			dataInicial.set(Calendar.MINUTE, 00);
			dataInicial.set(Calendar.SECOND, 00);
			SimpleDateFormat dt = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			System.out.println(dt.format(dataInicial.getTime()));
			conexao.setParameter("dataValidadeInicial", dataInicial.getTime());	
			Calendar dataFinal = new GregorianCalendar();
			dataFinal.setTime(dataNova);
			dataFinal.set(Calendar.HOUR, 23);
			dataFinal.set(Calendar.MINUTE, 59);
			dataFinal.set(Calendar.SECOND, 59);
			conexao.setParameter("dataValidadeFinal", dataFinal.getTime());
			System.out.println(dt.format(dataFinal.getTime()));
		}
			
		
		if(orcamento.getCodigoOrcamento()!= 0)
			conexao.setParameter("codigoOrcamento", orcamento.getCodigoOrcamento());
		
		if(orcamento.getCpfCliente() != null && !orcamento.getCpfCliente().equals(""))
			conexao.setParameter("cpfCliente", orcamento.getCpfCliente());
		
		if(orcamento.getNomeCliente() != null && !orcamento.getNomeCliente().equals(""))
			conexao.setParameter("cliente", orcamento.getNomeCliente().toLowerCase() + "%");
		
		if(orcamento.getVeiculoModelo() != null && !orcamento.getVeiculoModelo().equals(""))
			conexao.setParameter("modelo", orcamento.getVeiculoModelo());
		
		List<Orcamento> lista = conexao.getResultList();
		return lista;
		
	}

	public Long consultarNumeroOS() {
		System.out.println("ConsultarServico--INICIO");
		long retorno = 0;
		try {
			conexao.criarQuery("select max(h.numeroOS)+1 from HistoricoVenda h order by h.numeroOS desc");
			Long sequenciaOS = Long.parseLong(conexao.getSingleResult().toString());
			if (!sequenciaOS.equals(null)) {
				retorno = sequenciaOS;
			}

		} catch (Exception e) {
			System.out.println("Primeira OS");
			return retorno;
		}
		System.out.println("ConsultarServico--FIM");
		return retorno;
	}
	
	public HistoricoVenda consultarHistoricoVendaPorCodigo(Long codigovenda) {
		System.out.println("ConsultarServico--INICIO");
		try {
			conexao.criarQuery("SELECT A FROM HistoricoVenda A WHERE A.codigoVenda = :pCodigoVenda ");
			conexao.setParameter("pCodigoVenda", codigovenda);
			HistoricoVenda retorno = (HistoricoVenda) conexao.getSingleResult();
			System.out.println("ConsultarServico--FIM");
			return retorno;

		} catch (Exception e) {
			
			return null;
		}
	}

	public boolean preparaRelatorio(String relatorio) throws IOException {

		System.out.println("preparaRelatorio--INICIO");
		boolean retorno = false;
		// factory =
		// Persistence
		//
		//
		// query =
		// emconexao.criarQuery(" SELECT historico FROM HistoricoServico historico order by historico.dataServico asc");
		//
		// List<HistoricoVenda> historico conexao.getResultList();
		//
		// ProdutoServiceImpl produto = new ProdutoServiceImpl();
		// UsuarioServiceImpl usuario = new UsuarioServiceImpl();
		//
		// List<HistoricoRelatorio> listaRelatorio = new
		// ArrayList<HistoricoRelatorio>();
		// for (HistoricoVenda his : historico) {
		//
		// HistoricoRelatorio historicoRelatorio = new HistoricoRelatorio();
		//
		// if(produto.consultarNomeProduto(his.getCodigoProduto()) != null){
		// historicoRelatorio.setNomeProduto(produto.consultarNomeProduto(his.getCodigoProduto()));
		// }else{
		// historicoRelatorio.setNomeProduto("N/A");
		// }
		//
		// historicoRelatorio.setNomeUsuario(usuario.consultarUsuario(his.getCodigoFuncionario()));
		// historicoRelatorio.setNomeServico(new
		// VendaServiceImpl().consultarNomeServico(his.getCodigoServico()));
		// historicoRelatorio.setValorServico(his.getValor());
		// historicoRelatorio.setDataServico(his.getDataServico());
		// historicoRelatorio.setCliente(his.getNomeCliente());
		// historicoRelatorio.setValorServico(his.getValor());
		// listaRelatorio.add(historicoRelatorio);
		// }
		// String diretorio =
		// "C:/Users/tpeca/Documents/arquivos/RelatorioEquipar";
		// String nomeArquivo = "volumetriDeVendas";
		// retorno = new GeradorArquivo().gravaRelatorio(listaRelatorio,
		// diretorio, nomeArquivo);
		System.out.println("preparaRelatorio--FIM");
		return retorno;

	}

	
	public List<HistoricoProduto> consultarHistoricoProdutoPorCodigoVenda(Long codigoVenda){
		conexao.criarQuery(" SELECT H FROM HistoricoProduto H where H.codigoVenda = :codigoVenda");
		conexao.setParameter("codigoVenda", codigoVenda);
		List<HistoricoProduto> produtos = conexao.getResultList();
		for (HistoricoProduto historicoProduto : produtos) {
			System.out.println(historicoProduto.toString());
			System.out.println(new ProdutoServiceImpl().consultarModeloProduto(historicoProduto.getCdProd()));
		}
		return produtos;
	}
	
	public List<HistoricoMaoDeObra> consultarHistoricoMaoObraPorCodigoVenda(Long codigoVenda){
		conexao.criarQuery(" SELECT H FROM HistoricoMaoDeObra H where H.codigoVenda = :codigoVenda");
		conexao.setParameter("codigoVenda", codigoVenda);
		List<HistoricoMaoDeObra> mos = conexao.getResultList();
		for (HistoricoMaoDeObra historicoMaoDeObra : mos) {
			System.out.println(historicoMaoDeObra.toString());		
		}
		return mos;
	}
	public List<OrcamentoProduto> consultarOrcamentoProdutoPorCodigoVenda(Long codigoOrcamento){
		conexao.criarQuery(" SELECT H FROM OrcamentoProduto H where H.codigoVenda = :codigoVenda");
		conexao.setParameter("codigoVenda", codigoOrcamento);
		List<OrcamentoProduto> produtos = conexao.getResultList();
		for (OrcamentoProduto historicoProduto : produtos) {
			System.out.println(historicoProduto.toString());
			System.out.println(new ProdutoServiceImpl().consultarModeloProduto(historicoProduto.getCdProd()));
		}
		return produtos;
	}
	
	public List<OrcamentoMaoDeObra> consultarOrcamentoMaoObraPorCodigoVenda(Long codigoVenda){
		conexao.criarQuery(" SELECT H FROM OrcamentoMaoDeObra H where H.codigoVenda = :codigoVenda");
		conexao.setParameter("codigoVenda", codigoVenda);
		List<OrcamentoMaoDeObra> mos = conexao.getResultList();
		for (OrcamentoMaoDeObra orcamentoMaoDeObra : mos) {
			System.out.println(orcamentoMaoDeObra.toString());		
		}
		return mos;
	}
	
	public boolean registrarMaoDeObraOrcamento(OrcamentoMaoDeObra mo) {
		System.out.println("registrarMaoDeObraOrcamento--INICIO");

		boolean retorno = false;
		try {
			conexao.persist(mo);
			retorno = true;
			System.out.println("registrarMaoDeObraOrcamento--FIM");
		} catch (Exception e) {
			System.out.println("registrarMaoDeObraOrcamento--FIM");
		}

		return retorno;
	}

	public boolean registrarProdutoOrcamento(OrcamentoProduto hProduto) {
		System.out.println("registrarProdutoOrcamento--INICIO");

		boolean retorno = false;
		try {
			conexao.persist(hProduto);
			retorno = true;
			System.out.println("registrarProdutoOrcamento--FIM");
		} catch (Exception e) {
			System.out.println("registrarProdutoOrcamento--FIM");
		}
		return retorno;
	}
	
	public boolean removerItem(Object objeto) {
		boolean retorno = false;
		try {
			conexao.remove(objeto);
			retorno = true;
		} catch (Exception e) {
			e.printStackTrace();
			retorno = false;
		}
		return retorno;
	}
	

	public static void main(String[] args) throws IOException {
//		 new VendaServiceImpl().preparaRelatorio("volumetriDeVendas");
//		HistoricoVenda venda = new HistoricoVenda();
//		VendaServiceImpl servico = new VendaServiceImpl();
//		System.out.println(servico.consultarNumeroOS());
//		venda.setDataVenda(new Date());
////		venda.setNumeroOS(18l);
////		venda.setNomeCliente("Danielle Cardoso");
////		venda.setCpfCliente("41159898820");
//
//		List<HistoricoVenda> lista = servico.consultarHistoricoVenda(venda);
//		for (HistoricoVenda historicoVenda : lista) {
//			System.out.println(historicoVenda.toString());
//			servico.consultarHistoricoProdutoPorCodigoVenda(historicoVenda.getCodigoVenda());
//			servico.consultarHistoricoMaoObraPorCodigoVenda(historicoVenda.getCodigoVenda());
//			System.out.println("\n");
		}
		

//	}
}