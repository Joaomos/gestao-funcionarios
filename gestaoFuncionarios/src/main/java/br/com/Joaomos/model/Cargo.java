package br.com.Joaomos.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "cargos")
public class Cargo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false)
	private String cargo;
	
	private String nivelExperiencia;
	
	@OneToMany(mappedBy = "cargo", fetch = FetchType.LAZY)
	private List<Funcionario> funcionarios;
	
	public Cargo() {

	}

	public Cargo(String cargo, String nivelExperiencia) {
		super();
		this.cargo = cargo;
		this.nivelExperiencia = nivelExperiencia;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String nome) {
		this.cargo = nome;
	}

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

	public String getNivelExperiencia() {
		return nivelExperiencia;
	}

	public void setNivelExperiencia(String nivelExperiencia) {
		this.nivelExperiencia = nivelExperiencia;
	}
	
	@Override
	public String toString() {
		return cargo + " " + nivelExperiencia;
	}
	
}