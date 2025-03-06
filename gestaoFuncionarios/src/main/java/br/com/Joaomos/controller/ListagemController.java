package br.com.Joaomos.controller;

import java.net.URL;
import java.util.List;

import br.com.Joaomos.infra.DAO;
import br.com.Joaomos.model.Funcionario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ListagemController {
	
	@FXML
	private Label idLabel;
	
	@FXML
	private Label cargoLabel;
	
	@FXML
	private Label nomeLabel;
	
	@FXML
	private Label salarioLabel;
	
	@FXML
	private Label cpfLabel;
	
	@FXML
	private Label contratacaoLabel;
	
	@FXML
	private ChoiceBox<Funcionario> choiceBox;

	private DAO<Funcionario> funcionarioDAO = new DAO<>();
	
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
	        stage.centerOnScreen();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	public void atualizarDadosFuncionario(Funcionario funcionario) {
		
		idLabel.setText(" " + String.valueOf(funcionario.getId()));
		cargoLabel.setText(" " + String.valueOf(funcionario.getCargo()));
		nomeLabel.setText(" " + String.valueOf(funcionario.getNome()));
		salarioLabel.setText(" R$" + String.valueOf(funcionario.getSalarioBase()));
		cpfLabel.setText(" " + String.valueOf(funcionario.getCPF()));
		
		if(funcionario.getTipo().equals("FCLT")) {
			contratacaoLabel.setText(" Funcionário CLT");
		} else if(funcionario.getTipo().equals("FCOM")) {
			contratacaoLabel.setText(" Funcionário Comissionado");						
		} else if(funcionario.getTipo().equals("FHOR")){
			contratacaoLabel.setText(" Funcionário Horista");									
		}
		
	}
}