package br.com.Joaomos.infra;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.Joaomos.model.Cargo;
import br.com.Joaomos.model.Funcionario;
import br.com.Joaomos.model.FuncionarioCLT;
import br.com.Joaomos.model.FuncionarioComissionado;
import br.com.Joaomos.model.FuncionarioHorista;
import br.com.Joaomos.model.Usuario;

public class DAO<E> {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private Class<E> classe;
	
	static {
		try {
			emf = Persistence.createEntityManagerFactory("gestaoFuncionarios");
		} catch (Exception e) {
			
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
	
	public DAO<E> remover(E entidade) {
		em.remove(entidade);
		return this;
	}
	
	public DAO<E> incluirAtomico(E entidade) {
		return this.abrirT().incluir(entidade).fecharT();
	}
	
	public DAO<E> removerAtomico(E entidade) {
		return this.abrirT().remover(entidade).fecharT();
	}
	
	public E obterPorID(Object id) {
		return em.find(classe, id);
	}
	
	public Funcionario buscarPorCPF(Long CPF) {
		try {
			TypedQuery<Funcionario> query = em.createQuery("SELECT u FROM Funcionario u WHERE u.CPF = :cpf", Funcionario.class);
			query.setParameter("cpf", CPF);
			return query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		} 
	}
	
	public Funcionario buscarPorId(Long id) {
		try {
			TypedQuery<Funcionario> query = em.createQuery("SELECT u FROM Funcionario u WHERE u.id = :id", Funcionario.class);
			query.setParameter("id", id);
			return query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		} 
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
	
	public List<Cargo> listarTodos() {
		return em.createQuery("SELECT c FROM Cargo c", Cargo.class).getResultList();
	}
	
	public List<Funcionario> listarTodosFuncionarios() {
		return em.createQuery("SELECT f FROM Funcionario f", Funcionario.class).getResultList();
	}
	
	public List<Funcionario> listarFuncionariosCLT() {
	    return em.createQuery("SELECT f FROM Funcionario f WHERE TYPE(f) = :tipo", Funcionario.class)
	             .setParameter("tipo", FuncionarioCLT.class)
	             .getResultList();
	}
	
	public List<Funcionario> listarFuncionariosCOM() {
		return em.createQuery("SELECT f FROM Funcionario f WHERE TYPE(f) = :tipo", Funcionario.class)
	             .setParameter("tipo", FuncionarioComissionado.class)
	             .getResultList();
	}
	
	public List<Funcionario> listarFuncionariosHOR() {
		return em.createQuery("SELECT f FROM Funcionario f WHERE TYPE(f) = :tipo", Funcionario.class)
	             .setParameter("tipo", FuncionarioHorista.class)
	             .getResultList();
	}
	
	public void fechar() {
		em.close();
	}
}