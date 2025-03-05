package br.com.Joaomos.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "funcionarios")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "tipo", length = 4, discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("FNOR")
public class Funcionario {

	@Id
	private Long id;
	
	private String nome;
	
	@ManyToOne
	private Cargo cargo;
	
	@Column(name = "CPF")
	private Long CPF;
	
	
	@Column(name = "cargo")
	private String nomeCargo;
	
	@Column(nullable = false)
	private Double salarioBase;
	
	public Funcionario() {
		
	}

	public Funcionario(String nome, Long CPF, Cargo cargo, Double salarioBase) {
		super();
		this.nome = nome;
		this.CPF = CPF;
		this.cargo = cargo;
		this.salarioBase = salarioBase;
		this.nomeCargo = cargo.getCargo();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public Double getSalarioBase() {
		return salarioBase;
	}

	public void setSalarioBase(Double salarioBase) {
		this.salarioBase = salarioBase;
	}

	public String getNomeCargo() {
		return nomeCargo;
	}

	public void setNomeCargo(String nomeCargo) {
		this.nomeCargo = nomeCargo;
	}

	public Long getCPF() {
		return CPF;
	}

	public void setCPF(Long cPF) {
		CPF = cPF;
	}
	
	
	
}
