package br.com.equiparAcessorios.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="PARAMETRIZACAO")
public class Parametrizacao {
	
	@Id
	@SequenceGenerator(name="S_PARAMETRIZACAO", sequenceName="param_seq", initialValue=1, allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "S_PARAMETRIZACAO")
	@Column(name="CD_PARAMETRO")
	private int cdParametro;
	
	@Column(name="DC_PARAMETRO")
	private String descricaoParametro;
	
	@Column(name="VL_PARAMETRO")
	private String valorParametro;
	
	public static String consultarParametro(String descricaoParametro){
		EntityManagerFactory factory;
		EntityManager em;
		Query query;
		
		factory = Persistence
				.createEntityManagerFactory("equiparAcessorios");
		em = factory.createEntityManager();
		query = em
				.createQuery(" SELECT param.valorParametro FROM Parametrizacao param where param.descricaoParametro = :pValidar");
		query.setParameter("pValidar", descricaoParametro);
		return  (String) query.getSingleResult();
	}

	public int getCdParametro() {
		return cdParametro;
	}

	public void setCdParametro(int cdParametro) {
		this.cdParametro = cdParametro;
	}

	public String getDescricaoParametro() {
		return descricaoParametro;
	}

	public void setDescricaoParametro(String descricaoParametro) {
		this.descricaoParametro = descricaoParametro;
	}

	public String getValorParametro() {
		return valorParametro;
	}

	public void setValorParametro(String valorParametro) {
		this.valorParametro = valorParametro;
	}

}
