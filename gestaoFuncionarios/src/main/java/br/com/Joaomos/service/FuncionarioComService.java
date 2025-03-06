package br.com.Joaomos.service;

import java.util.List;

import br.com.Joaomos.infra.DAO;
import br.com.Joaomos.model.Funcionario;
import br.com.Joaomos.model.FuncionarioComissionado;

public class FuncionarioComService extends FuncionarioService{
	
	private final DAO<FuncionarioComissionado> funcionarioDAO = new DAO<>();
	
	@Override
	public Double calcularMedia() {
	    List<Funcionario> funcionarios = funcionarioDAO.listarFuncionariosCOM();

	    if (funcionarios.isEmpty()) {
	        return 0.0; 
	    }

	    double somaSalarios = funcionarios.stream()
	                                      .mapToDouble(Funcionario::getSalarioBase)
	                                      .sum();

	    return somaSalarios / funcionarios.size();
	}
	
	@Override
	public Double calcularSomatorioSalarios() {
		List<Funcionario> funcionarios = funcionarioDAO.listarFuncionariosCOM();
		
		if (funcionarios.isEmpty()) {
	        return 0.0; 
	    }

	    double somaSalarios = funcionarios.stream()
	                                      .mapToDouble(Funcionario::getSalarioBase)
	                                      .sum();

	    return somaSalarios;
	}
}