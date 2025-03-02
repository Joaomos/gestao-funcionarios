package br.com.Joaomos.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("FHOR")
public class FuncionarioHorista extends Funcionario {

	public FuncionarioHorista() {

	}

	public FuncionarioHorista(String nome, Cargo cargo, Double salarioBase) {
		super(nome, cargo, salarioBase);
	}
}