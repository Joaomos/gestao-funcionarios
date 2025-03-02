package br.com.Joaomos.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("FCOM")
public class FuncionarioComissionado extends Funcionario{
	public FuncionarioComissionado() {

	}

	public FuncionarioComissionado(String nome, Cargo cargo, Double salarioBase) {
		super(nome, cargo, salarioBase);
	}
}