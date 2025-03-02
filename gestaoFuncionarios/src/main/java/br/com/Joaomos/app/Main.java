package br.com.Joaomos.app;

import br.com.Joaomos.infra.DAO;
import br.com.Joaomos.model.Cargo;
import br.com.Joaomos.model.Funcionario;
import br.com.Joaomos.model.FuncionarioCLT;
import br.com.Joaomos.service.FuncionarioService;

public class Main {
	 
	public static void main(String[] args) {
		/*EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestaoFuncionarios");
		EntityManager em = emf.createEntityManager();
		
		FuncionarioService service = new FuncionarioService();
		Cargo cargo = new Cargo("Programador");
		
		Funcionario f = new Funcionario("João", cargo, 5000.00);
		f.setId(service.gerarId());
		
		em.getTransaction().begin();
		em.persist(cargo);
		em.persist(f);
		em.getTransaction().commit();
		
		em.close();
		emf.close();*/
		
		FuncionarioService service = new FuncionarioService();
		
		DAO<Object> dao = new DAO<>();
		
		Cargo cargo = new Cargo("Programador");
		Funcionario f = new Funcionario("João", cargo, 5000.00);
		f.setId(service.gerarId());
		
		Cargo cargo2 = new Cargo("Desenvolvedor");
		FuncionarioCLT f2 = new FuncionarioCLT("Mateus", cargo2, 5000.00);
		f2.setId(service.gerarId());
		
		FuncionarioCLT f3 = new FuncionarioCLT("Norma", cargo, 3800.00);
		f3.setId(service.gerarId());
		

		FuncionarioCLT f4 = new FuncionarioCLT("Marizan", cargo2, 7400.00);
		f4.setId(service.gerarId());
		
		dao.incluirAtomico(cargo);
		dao.incluirAtomico(cargo2);
		dao.incluirAtomico(f);
		dao.incluirAtomico(f2);
		dao.incluirAtomico(f3);
		dao.incluirAtomico(f4);
		dao.fechar();
	}
}
