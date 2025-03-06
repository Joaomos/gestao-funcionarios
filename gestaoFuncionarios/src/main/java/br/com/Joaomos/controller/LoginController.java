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

public class LoginController {
	@FXML
	private TextField campoEmail;
	
	@FXML
	private PasswordField campoSenha;
	
	private AuthService as = new AuthService();
	
	public void entrar() {
		if(!as.isValidEmail(campoEmail.getText())) {
			Notifications.create()
				.position(Pos.TOP_CENTER)
				.title("Login")
				.text("E-mail inválido.")
				.showError();
		} else if(!as.usuarioExiste(campoEmail.getText())) {
			Notifications.create()
				.position(Pos.TOP_CENTER)
				.title("Login")
				.text("Usuário não encontrado")
				.showError();
		} else if(as.isSenhaIncorreta(campoEmail.getText(), campoSenha.getText())) {
			Notifications.create()
				.position(Pos.TOP_CENTER)
				.title("Login")
				.text("Senha Incorreta.")
				.showError();
		} else if(as.autenticar(campoEmail.getText(), campoSenha.getText())) {
			Notifications.create()
				.position(Pos.TOP_CENTER)
				.title("Login")
				.text("Login efetuado com sucesso!")
				.showInformation();
			abrirMenuPrincipal();
		} else {
			Notifications.create()
			.position(Pos.TOP_CENTER)
			.title("Login")
			.text("Usuário não encontrado")
			.showError();
		}
	} 
	
	public void abrirCadastro() {
		try {
			String arquivoCSS = getClass().getResource("/br/com/Joaomos/view/styles.css").toExternalForm();
	        URL arquivoFXML = getClass().getResource("/br/com/Joaomos/view/cadastroUsuario.fxml");
	        GridPane raiz = FXMLLoader.load(arquivoFXML);

	        Stage stage = (Stage) campoEmail.getScene().getWindow();

	        Scene cadastroScene = new Scene(raiz);
	        cadastroScene.getStylesheets().add(arquivoCSS);
	        stage.setScene(cadastroScene);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
    }
	
	public void abrirMenuPrincipal() {
		try {
			
			String arquivoCSS = getClass().getResource("/br/com/Joaomos/view/styles.css").toExternalForm();
	        URL arquivoFXML = getClass().getResource("/br/com/Joaomos/view/main.fxml");
	        GridPane raiz = FXMLLoader.load(arquivoFXML);

	        Stage stage = (Stage) campoEmail.getScene().getWindow();

	        Scene menuPrincipalScene= new Scene(raiz, 370, 500);
	        menuPrincipalScene.getStylesheets().add(arquivoCSS);
	        stage.setScene(menuPrincipalScene);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
}