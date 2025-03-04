package br.com.Joaomos.infra;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.Joaomos.model.Cargo;
import br.com.Joaomos.model.Usuario;

public class DAO<E> {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private Class<E> classe;
	
	static {
		try {
			emf = Persistence.createEntityManagerFactory("gestaoFuncionarios");
		} catch (Exception e) {
			// logar log4j
		}
	}
	
	public DAO() {
		this(null);
	}
	
	public DAO(Class<E> classe) {
		this.classe = classe;
		em = emf.createEntityManager();
	}
	
	public DAO<E> abrirT() {
		em.getTransaction().begin();
		return this;
	}
	
	public DAO<E> fecharT() {
		em.getTransaction().commit();
		return this;
	}
	
	public DAO<E> incluir(E entidade) {
		em.persist(entidade);
		return this;
	}
	
	public DAO<E> incluirAtomico(E entidade) {
		return this.abrirT().incluir(entidade).fecharT();
	}
	
	public E obterPorID(Object id) {
		return em.find(classe, id);
	}
	
	public Usuario buscarPorEmail(String email) {
		try {
			TypedQuery<Usuario> query = em.createQuery("SELECT u FROM Usuario u WHERE u.email = :email", Usuario.class);
			query.setParameter("email", email);
			return query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		} 
	}
	
	public Cargo buscarPorNome(String nome) {
		try {
			TypedQuery<Cargo> query = em.createQuery("SELECT u FROM Cargo u WHERE u.cargo = :cargo", Cargo.class);
			query.setParameter("cargo", nome);
			return query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		} 
	}
	
	public Cargo buscarPorNivelExperiencia(String nivelExperiencia) {
		try {
			TypedQuery<Cargo> query = em.createQuery("SELECT u FROM Cargo u WHERE u.nivelExperiencia = :nivelExperiencia", Cargo.class);
			query.setParameter("nivelExperiencia", nivelExperiencia);
			return query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		} 
	}
	
	public void fechar() {
		em.close();
	}
}
