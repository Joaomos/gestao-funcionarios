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
	
	@OneToMany(mappedBy = "cargo", fetch = FetchType.LAZY)
	private List<Funcionario> funcionarios;
	
	// private int tipoFuncionario; // Se é CLT...
	
	public Cargo() {

	}

	public Cargo(String cargo) {
		super();
		this.cargo = cargo;
	//	this.descricao = descricao;
	//	this.tipoFuncionario = tipoFuncionario;
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

//	public int getTipoFuncionario() {
//		return tipoFuncionario;
//	}

//	public void setTipoFuncionario(int tipoFuncionario) {
//		this.tipoFuncionario = tipoFuncionario;
//	}
	
}
