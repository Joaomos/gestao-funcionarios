package br.com.Joaomos.controller;

import java.net.URL;
import java.util.List;

import org.controlsfx.control.Notifications;

import br.com.Joaomos.infra.DAO;
import br.com.Joaomos.model.Funcionario;
import br.com.Joaomos.service.FuncionarioService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class DemissaoController {
	
	@FXML
	private Label idLabel;
	
	@FXML
	private Label nomeLabel;
	
	@FXML
	private ChoiceBox<Funcionario> choiceBox;
	
	private DAO<Funcionario> funcionarioDAO = new DAO<>();
	
	private FuncionarioService fs;
	
	@SuppressWarnings("unused")
	@FXML
    public void initialize() {
		funcionarioDAO = new DAO<>();
        carregarFuncionarios();
        
        choiceBox.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal != null) {
                atualizarDadosFuncionario(newVal);
            }
        });

        if (!choiceBox.getItems().isEmpty()) {
            atualizarDadosFuncionario(choiceBox.getValue());
        }
    }
	
	public void atualizarDadosFuncionario(Funcionario funcionario) {
		
		idLabel.setText(" " + String.valueOf(funcionario.getId()));
		nomeLabel.setText(" " + String.valueOf(funcionario.getNome()));
	}
	
	private void carregarFuncionarios() {
        List<Funcionario> listaFuncionarios = funcionarioDAO.listarTodosFuncionarios();
        ObservableList<Funcionario> funcionariosObservable = FXCollections.observableArrayList(listaFuncionarios);
        choiceBox.setItems(funcionariosObservable);

        if (!listaFuncionarios.isEmpty()) {
            choiceBox.setValue(listaFuncionarios.get(0)); 
        }
    }
	
	public void abrirMenuPrincipal() {
		try {
			
			String arquivoCSS = getClass().getResource("/br/com/Joaomos/view/styles.css").toExternalForm();
	        URL arquivoFXML = getClass().getResource("/br/com/Joaomos/view/main.fxml");
	        GridPane raiz = FXMLLoader.load(arquivoFXML);

	        Stage stage = (Stage) choiceBox.getScene().getWindow();

	        Scene menuPrincipalScene= new Scene(raiz, 370, 500);
	        menuPrincipalScene.getStylesheets().add(arquivoCSS);
	        stage.setScene(menuPrincipalScene);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	public void demitirFuncionario() {
		fs = new FuncionarioService();
		Funcionario funcionarioSelecionado = choiceBox.getValue();
		
		fs.demicaoFuncionario(funcionarioSelecionado.getId());
		Notifications.create()
        	.position(Pos.TOP_CENTER)
        	.title("Sucesso")
        	.text("Funcionário demitido com sucesso!")
        	.showInformation();
		abrirMenuPrincipal();
		
	}
}