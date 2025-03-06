package br.com.Joaomos.controller;

import java.net.URL;

import org.controlsfx.control.Notifications;

import br.com.Joaomos.service.CargoService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class CargoController {
	@FXML
	private TextField campoNomeCargo;
	
	@FXML
	private TextField campoNivelExperiencia;
	
	private CargoService cs;
	
	public void registrarCargo() {
		cs = new CargoService();
		
		if(cs.nomeCargoExiste(campoNomeCargo.getText()) && cs.nivelExperienciaExiste(campoNivelExperiencia.getText())) {
			Notifications.create()
				.position(Pos.TOP_CENTER)
				.title("Login")
				.text("O cargo já está cadastrado.")
				.showError();
		} else if (campoNomeCargo.getText().isEmpty()) {
			Notifications.create()
				.position(Pos.TOP_CENTER)
				.title("Login")
				.text("O nome do cargo deve estar preenchido.")
				.showError();
		} else if (campoNivelExperiencia.getText().isEmpty()) {
			Notifications.create()
				.position(Pos.TOP_CENTER)
				.title("Login")
				.text("O nível de experiência deve estar preenchido.")
				.showError();
		} else {
			Notifications.create()
				.position(Pos.TOP_CENTER)
				.title("Login")
				.text("Cargo cadastrado com sucesso!")
				.showInformation();
			cs.registrarCargo(campoNomeCargo.getText(), campoNivelExperiencia.getText());
			abrirMenuPrincipal();
		}
	}
	
	public void abrirMenuPrincipal() {
		try {
			
			String arquivoCSS = getClass().getResource("/br/com/Joaomos/view/styles.css").toExternalForm();
	        URL arquivoFXML = getClass().getResource("/br/com/Joaomos/view/main.fxml");
	        GridPane raiz = FXMLLoader.load(arquivoFXML);

	        Stage stage = (Stage) campoNomeCargo.getScene().getWindow();

	        Scene menuPrincipalScene= new Scene(raiz, 370, 500);
	        menuPrincipalScene.getStylesheets().add(arquivoCSS);
	        stage.setScene(menuPrincipalScene);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
}