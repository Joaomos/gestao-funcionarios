package br.com.Joaomos.service;

import java.util.List;
import java.util.Random;

import br.com.Joaomos.infra.DAO;
import br.com.Joaomos.model.Cargo;
import br.com.Joaomos.model.Funcionario;
import br.com.Joaomos.model.FuncionarioCLT;
import br.com.Joaomos.model.FuncionarioComissionado;
import br.com.Joaomos.model.FuncionarioHorista;

public class FuncionarioService {
	
	private final DAO<Funcionario> funcionarioDAO = new DAO<>();
	
	public void registrarFuncionario(String nome, Long CPF, Cargo cargo, Double salario, String TipoFuncionario) {
		if(funcionarioDAO.buscarPorCPF(CPF) != null) {
			throw new IllegalArgumentException("Funcionário já cadastrado!");
		}
		
		if(TipoFuncionario == "Funcionário CLT") {
			FuncionarioCLT funcionario = new FuncionarioCLT(nome, CPF, cargo, salario);
			funcionario.setId(gerarId());
			funcionarioDAO.incluirAtomico(funcionario);
			funcionarioDAO.fechar();
		} else if(TipoFuncionario == "Funcionário Horista") {
			FuncionarioHorista funcionario = new FuncionarioHorista(nome, CPF, cargo, salario);			
			funcionario.setId(gerarId());
			funcionarioDAO.incluirAtomico(funcionario);
			funcionarioDAO.fechar();
		} else {
			FuncionarioComissionado funcionario = new FuncionarioComissionado(nome, CPF, cargo, salario);						
			funcionario.setId(gerarId());
			funcionarioDAO.incluirAtomico(funcionario);
			funcionarioDAO.fechar();
		}
	}
	
	public void demicaoFuncionario(Long id) {
		Funcionario f = funcionarioDAO.buscarPorId(id);
		funcionarioDAO.removerAtomico(f);
		funcionarioDAO.fechar();
	}
	
	public boolean funcionarioExiste(Long CPF) {
		Funcionario f = funcionarioDAO.buscarPorCPF(CPF);
		return f != null;
	}
	
	public Double calcularMedia() {
		List<Funcionario> funcionarios = funcionarioDAO.listarTodosFuncionarios();

	    if (funcionarios.isEmpty()) {
	        return 0.0; 
	    }

	    double somaSalarios = funcionarios.stream()
	                                      .mapToDouble(Funcionario::getSalarioBase)
	                                      .sum();

	    return somaSalarios / funcionarios.size();
	}
	
	public Double calcularSomatorioSalarios() {
		List<Funcionario> funcionarios = funcionarioDAO.listarTodosFuncionarios();
		
		if (funcionarios.isEmpty()) {
	        return 0.0; 
	    }

	    double somaSalarios = funcionarios.stream()
	                                      .mapToDouble(Funcionario::getSalarioBase)
	                                      .sum();

	    return somaSalarios;
	}
	
	private Long gerarId() {
		Random random = new Random();
		Long novoId;
        do {
            novoId = (random.nextLong(9000) + 1000); 
        } while (idExisteNoBanco(novoId));
        return novoId;
	}
	
	private boolean idExisteNoBanco(Long id) {
		Funcionario f = funcionarioDAO.buscarPorId(id);
		return f != null;
	}
}