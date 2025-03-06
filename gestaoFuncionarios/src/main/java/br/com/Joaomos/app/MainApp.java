package br.com.Joaomos.app;

import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MainApp extends Application {
	
	@Override
	public void start(Stage primaryStage) throws Exception {
//		String arquivoCSS = getClass().getResource("/br/com/Joaomos/view/styles.css").toExternalForm();
//		URL arquivoFXML = getClass().getResource("/br/com/Joaomos/view/login.fxml");
//		GridPane raiz = FXMLLoader.load(arquivoFXML);
//		
//		Scene cena = new Scene(raiz, 350, 420);
//		cena.getStylesheets().add(arquivoCSS);
//		
//		primaryStage.setResizable(false);
//		primaryStage.setTitle("Gestão de Funcionários");
//		primaryStage.setScene(cena);
//		primaryStage.show();
//		
		String arquivoCSS = getClass().getResource("/br/com/Joaomos/view/styles.css").toExternalForm();
		URL arquivoFXML = getClass().getResource("/br/com/Joaomos/view/folhaPagamentos.fxml");
		GridPane raiz = FXMLLoader.load(arquivoFXML);
		
		Scene cena = new Scene(raiz, 950, 500);
		cena.getStylesheets().add(arquivoCSS);
		
		primaryStage.setResizable(false);
		primaryStage.setTitle("Gestão de Funcionários");
		primaryStage.setScene(cena);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	 
//	public static void main(String[] args) {
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestaoFuncionarios");
//		EntityManager em = emf.createEntityManager();
//		
//		FuncionarioService service = new FuncionarioService();
//		Cargo cargo = new Cargo("Programador");
//		
//		Funcionario f = new Funcionario("João", cargo, 5000.00);
//		f.setId(service.gerarId());
//		
//		em.getTransaction().begin();
//		em.persist(cargo);
//		em.persist(f);
//		em.getTransaction().commit();
//		
//		em.close();
//		emf.close();
//		
//		FuncionarioController service = new FuncionarioController();
//		
//		DAO<Object> dao = new DAO<>();
//		
//		Cargo cargo = new Cargo("Programador");
//		Funcionario f = new Funcionario("João", cargo, 5000.00);
//		f.setId(service.gerarId());
//		
//		Cargo cargo2 = new Cargo("Desenvolvedor");
//		FuncionarioCLT f2 = new FuncionarioCLT("Mateus", cargo2, 5000.00);
//		f2.setId(service.gerarId());
//		
//		FuncionarioCLT f3 = new FuncionarioCLT("Norma", cargo, 3800.00);
//		f3.setId(service.gerarId());
//		
//
//		FuncionarioCLT f4 = new FuncionarioCLT("Marizan", cargo2, 7400.00);
//		f4.setId(service.gerarId());
//		
//		dao.incluirAtomico(cargo);
//		dao.incluirAtomico(cargo2);
//		dao.incluirAtomico(f);
//		dao.incluirAtomico(f2);
//		dao.incluirAtomico(f3);
//		dao.incluirAtomico(f4);
//		dao.fechar();
//		
//		
//	}
}
