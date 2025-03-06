package br.com.Joaomos.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.controlsfx.control.Notifications;

import br.com.Joaomos.infra.DAO;
import br.com.Joaomos.model.Cargo;
import br.com.Joaomos.service.FuncionarioService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class CadastroFuncionarioController {
	@FXML
	private TextField campoNomeFuncionario;
	
	@FXML
	private TextField campoCPFFuncionario;
	
	@FXML
	private ChoiceBox<Cargo> choiceBox;

	@FXML
	private ChoiceBox<String> choiceBox2;
	
	@FXML
	private TextField campoSalario;
	
	private DAO<Cargo> cargoDAO;
	
	private FuncionarioService fc;
	
	@FXML
    public void initialize() {
        cargoDAO = new DAO<>();
        carregarCargos();
        carregarTipos();
    }
	
	private void carregarCargos() {
        List<Cargo> listaCargos = cargoDAO.listarTodos();
        ObservableList<Cargo> cargosObservable = FXCollections.observableArrayList(listaCargos);
        choiceBox.setItems(cargosObservable);

        if (!listaCargos.isEmpty()) {
            choiceBox.setValue(listaCargos.get(0)); 
        }
    }
	
	private void carregarTipos() {
		List<String> listaTipoFuncionario = new ArrayList<String>();
		String tipo1 = "Funcionário CLT";
		String tipo2 = "Funcionário Horista";
		String tipo3 = "Funcionário Comissionado";
		
		listaTipoFuncionario.add(tipo1);
		listaTipoFuncionario.add(tipo2);
		listaTipoFuncionario.add(tipo3);
		
		ObservableList<String> cargosObservable = FXCollections.observableArrayList(listaTipoFuncionario);
		choiceBox2.setItems(cargosObservable);
		
		if (!listaTipoFuncionario.isEmpty()) {
            choiceBox2.setValue(listaTipoFuncionario.get(0)); 
        }
	}
	
	public void abrirMenuPrincipal() {
		try {
			
			String arquivoCSS = getClass().getResource("/br/com/Joaomos/view/styles.css").toExternalForm();
	        URL arquivoFXML = getClass().getResource("/br/com/Joaomos/view/main.fxml");
	        GridPane raiz = FXMLLoader.load(arquivoFXML);

	        Stage stage = (Stage) campoNomeFuncionario.getScene().getWindow();

	        Scene menuPrincipalScene= new Scene(raiz, 370, 500);
	        menuPrincipalScene.getStylesheets().add(arquivoCSS);
	        stage.setScene(menuPrincipalScene);
	        stage.centerOnScreen();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	public void registrarFuncionario() {
		fc = new FuncionarioService();
		
		if(campoNomeFuncionario.getText().isEmpty()) {
			Notifications.create()
				.position(Pos.TOP_CENTER)
				.title("Login")
				.text("O nome do funcionário deve estar preenchido.")
				.showError();
		} else if(campoCPFFuncionario.getText().isEmpty()) {
			Notifications.create()
				.position(Pos.TOP_CENTER)
				.title("Login")
				.text("O CPF do funcionário deve estar preenchido.")
				.showError();
		} else if(campoSalario.getText().isEmpty()) {
			Notifications.create()
				.position(Pos.TOP_CENTER)
				.title("Login")
				.text("O salário do funcionário deve estar preenchido.")
				.showError();
		} else if(fc.funcionarioExiste(Long.parseLong(campoCPFFuncionario.getText()))) {
			Notifications.create()
				.position(Pos.TOP_CENTER)
				.title("Login")
				.text("O funcionário já está cadastrado.")
				.showError();
		} else {
			Cargo cargoSelecionado = choiceBox.getValue();
			String tipoFuncionarioSelecionado = choiceBox2.getValue();

	        if (cargoSelecionado == null) {
	            Notifications.create()
	                .position(Pos.TOP_CENTER)
	                .title("Erro")
	                .text("É necessário selecionar um cargo.")
	                .showError();
	            return;
	        }

	        fc.registrarFuncionario(
	            campoNomeFuncionario.getText(),
	            Long.parseLong(campoCPFFuncionario.getText()),
	            cargoSelecionado,
	            Double.parseDouble(campoSalario.getText()),
	            tipoFuncionarioSelecionado
	        );

	        Notifications.create()
	            .position(Pos.TOP_CENTER)
	            .title("Sucesso")
	            .text("Funcionário cadastrado com sucesso!")
	            .showInformation();
	        abrirMenuPrincipal();
		}
	}
}