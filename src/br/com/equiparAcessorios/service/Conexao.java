package br.com.equiparAcessorios.service;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Conexao {

	static private EntityManagerFactory factory;
	static private EntityManager em;
	private Query query;

	public Conexao() {
		if (getFactory() == null || !getFactory().isOpen()) {
			setFactory(Persistence
					.createEntityManagerFactory("equiparAcessorios"));
			setEm(getFactory().createEntityManager());

		}
	}
	
	public void persist(Object classe){
		getEm().persist(classe);
		iniciarTransacao();
		fecharTransacao();
	}
	public void persist2(Object classe){
		getEm().persist(classe);
	}
	public void merge(Object classe){
		getEm().merge(classe);
		iniciarTransacao();
		fecharTransacao();
	}
	public void remove(Object classe){
		getEm().remove(em.contains(classe)? classe : em.merge(classe));
		iniciarTransacao();
		fecharTransacao();
	}
	
	public void iniciarTransacao(){
		em.getTransaction().begin();
	}
	public void fecharTransacao(){
		em.getTransaction().commit();
	}
	
	public void close(){
		
	}
	
	public void setParameter(String nome, String valor){
		query.setParameter(nome, valor);
	}
	
	public void setParameter(String nome, Date valor){
		query.setParameter(nome, valor);
	}
	
	public void setParameter(String nome, int valor){
		query.setParameter(nome, valor);
	}
	
	public void setParameter(String nome, long valor) {
		query.setParameter(nome, valor);
		
	}
	
	@SuppressWarnings("unchecked")
	public <E> List<E> getResultList(){
		return query.getResultList();
	}
	
	
	public Object getSingleResult() {
		if(query != null){
			if(!query.getSingleResult().equals(null)){
				return query.getSingleResult();
			}else{
				return null;
			}
		}else{
			return null;
		}
	}
	
	public void criarQuery(String query){
		setQuery(getEm().createQuery(query));
	}
	public void executaQuery(){
		iniciarTransacao();
		this.query.executeUpdate();
		fecharTransacao();
	}

	public EntityManagerFactory getFactory() {
		return factory;
	}

	public void setFactory(EntityManagerFactory factory) {
		this.factory = factory;
	}

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	public Query getQuery() {
		return query;
	}

	public void setQuery(Query query) {
		this.query = query;
	}

}
