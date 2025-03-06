package br.com.Joaomos.controller;

import java.net.URL;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class PrincipalController {
	@FXML
	private Button btnCadastrarFuncionario;

	@FXML
	private Button btnCadastrarCargo;
	
	@FXML
	private Button btnListaFuncionarios;
	
	@FXML
	private Button btnBuscarFuncionario;
	
	@FXML
	private Button btnFolhaSalarial;
	
	public void abrirCadastrarFuncionario() {
		try {
			String arquivoCSS = getClass().getResource("/br/com/Joaomos/view/styles.css").toExternalForm();
	        URL arquivoFXML = getClass().getResource("/br/com/Joaomos/view/cadastroFuncionario.fxml");
	        GridPane raiz = FXMLLoader.load(arquivoFXML);

	        Stage stage = (Stage) btnCadastrarFuncionario.getScene().getWindow();

	        Scene cadastroScene = new Scene(raiz, 420, 750);
	        cadastroScene.getStylesheets().add(arquivoCSS);
	        stage.setScene(cadastroScene);
	        stage.centerOnScreen();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	public void abrirCadastrarCargo() {
		try {
			String arquivoCSS = getClass().getResource("/br/com/Joaomos/view/styles.css").toExternalForm();
			URL arquivoFXML = getClass().getResource("/br/com/Joaomos/view/cadastroCargo.fxml");
			GridPane raiz = FXMLLoader.load(arquivoFXML);
			
			Stage stage = (Stage) btnCadastrarCargo.getScene().getWindow();
			
			Scene cadastroCargo = new Scene(raiz);
			cadastroCargo.getStylesheets().add(arquivoCSS);
			stage.setScene(cadastroCargo);
			stage.centerOnScreen();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void abrirListaFuncionarios() {
		try {
			String arquivoCSS = getClass().getResource("/br/com/Joaomos/view/styles.css").toExternalForm();
			URL arquivoFXML = getClass().getResource("/br/com/Joaomos/view/listagemFuncionarios.fxml");
			GridPane raiz = FXMLLoader.load(arquivoFXML);
			
			Stage stage = (Stage) btnCadastrarCargo.getScene().getWindow();
			
			Scene cadastroCargo = new Scene(raiz, 1020, 600);
			cadastroCargo.getStylesheets().add(arquivoCSS);
			stage.setScene(cadastroCargo);
			stage.centerOnScreen();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void abrirDemissaoFuncionario() {
		try {
			String arquivoCSS = getClass().getResource("/br/com/Joaomos/view/styles.css").toExternalForm();
			URL arquivoFXML = getClass().getResource("/br/com/Joaomos/view/demissaoFuncionario.fxml");
			GridPane raiz = FXMLLoader.load(arquivoFXML);
			
			Stage stage = (Stage) btnCadastrarCargo.getScene().getWindow();
			
			Scene cadastroCargo = new Scene(raiz, 350, 500);
			cadastroCargo.getStylesheets().add(arquivoCSS);
			stage.setScene(cadastroCargo);
			stage.centerOnScreen();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void abrirFolhaPagamento() {
		try {
			String arquivoCSS = getClass().getResource("/br/com/Joaomos/view/styles.css").toExternalForm();
			URL arquivoFXML = getClass().getResource("/br/com/Joaomos/view/folhaPagamentos.fxml");
			GridPane raiz = FXMLLoader.load(arquivoFXML);
			
			Stage stage = (Stage) btnCadastrarCargo.getScene().getWindow();
			
			Scene cadastroCargo = new Scene(raiz, 1120, 400);
			cadastroCargo.getStylesheets().add(arquivoCSS);
			stage.setScene(cadastroCargo);
			stage.centerOnScreen();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}