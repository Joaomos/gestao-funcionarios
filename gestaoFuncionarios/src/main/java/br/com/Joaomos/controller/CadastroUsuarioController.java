package br.com.Joaomos.controller;

import java.net.URL;

import org.controlsfx.control.Notifications;

import br.com.Joaomos.service.AuthService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class CadastroUsuarioController {
	@FXML
	private TextField campoNome;
	
	@FXML
	private TextField campoEmail;
	
	@FXML
	private PasswordField campoSenha;
	
	private AuthService as;
	
	public void abrirLogin() {
		try {
			String arquivoCSS = getClass().getResource("/br/com/Joaomos/view/styles.css").toExternalForm();
	        URL arquivoFXML = getClass().getResource("/br/com/Joaomos/view/login.fxml");
	        GridPane raiz = FXMLLoader.load(arquivoFXML);

	        Stage stage = (Stage) campoEmail.getScene().getWindow();

	        Scene cadastroScene = new Scene(raiz);
	        cadastroScene.getStylesheets().add(arquivoCSS);
	        stage.setScene(cadastroScene);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	public void registrarUsuario() {
		as = new AuthService();
		
		if(!as.isValidEmail(campoEmail.getText())) {
			Notifications.create()
				.position(Pos.TOP_CENTER)
				.title("Login")
				.text("E-mail inválido.")
				.showError();
		} else if (as.usuarioExiste(campoEmail.getText())) {
			Notifications.create()
				.position(Pos.TOP_CENTER)
				.title("Login")
				.text("O e-mail já está cadastrado.")
				.showError();
		} else {
			Notifications.create()
				.position(Pos.TOP_CENTER)
				.title("Login")
				.text("Usuario cadastrado com sucesso!")
				.showInformation();
			as.registrarUsuario(campoNome.getText(), campoEmail.getText(), campoSenha.getText());
			abrirLogin();
		}
	}
}