package br.com.Joaomos.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("FCOM")
public class FuncionarioComissionado extends Funcionario {

	public FuncionarioComissionado() {

	}

	public FuncionarioComissionado(String nome, Long CPF, Cargo cargo, Double salarioBase) {
		super(nome, CPF,cargo, salarioBase);
	}
}