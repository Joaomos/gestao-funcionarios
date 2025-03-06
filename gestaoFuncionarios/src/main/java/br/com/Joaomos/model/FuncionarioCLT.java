package br.com.Joaomos.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("FCLT")
public class FuncionarioCLT extends Funcionario {

	public FuncionarioCLT() {

	}

	public FuncionarioCLT(String nome, Long CPF, Cargo cargo, Double salarioBase) {
		super(nome, CPF,cargo, salarioBase);
	}
}