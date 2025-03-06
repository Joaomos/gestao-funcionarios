package br.com.Joaomos.service;

import java.util.List;

import br.com.Joaomos.infra.DAO;
import br.com.Joaomos.model.Funcionario;
import br.com.Joaomos.model.FuncionarioHorista;

public class FuncionarioHorService extends FuncionarioService {
	
private final DAO<FuncionarioHorista> funcionarioDAO = new DAO<>();
	
	@Override
	public Double calcularMedia() {
	    List<Funcionario> funcionarios = funcionarioDAO.listarFuncionariosHOR();

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
		List<Funcionario> funcionarios = funcionarioDAO.listarFuncionariosHOR();
		
		if (funcionarios.isEmpty()) {
	        return 0.0; 
	    }

	    double somaSalarios = funcionarios.stream()
	                                      .mapToDouble(Funcionario::getSalarioBase)
	                                      .sum();
	    return somaSalarios;
	}
}