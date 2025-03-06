package br.com.Joaomos.controller;

import java.net.URL;

import br.com.Joaomos.service.FuncionarioCLTService;
import br.com.Joaomos.service.FuncionarioComService;
import br.com.Joaomos.service.FuncionarioHorService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class FolhaPagamentoController {
	
	@FXML
	private Label FCLTSMLabel;
	
	@FXML
	private Label FCOMSMLabel;
	
	@FXML
	private Label FHORSMLabel;
	
	@FXML
	private Label TotalSMLabel;
	
	@FXML
	private Label FCLTSSLabel;
	
	@FXML
	private Label FCOMSSLabel;
	
	@FXML
	private Label FHORSSLabel;
	
	@FXML
	private Label TotalSSLabel;
		
	private FuncionarioCLTService fCLTS;
	
	private FuncionarioComService fComS;
	
	private FuncionarioHorService fHorS;
	
	@FXML
    public void initialize() {
		atualizarDadosFolhaPagamento();
    }
	

	

	public void abrirMenuPrincipal() {
		try {
			
			String arquivoCSS = getClass().getResource("/br/com/Joaomos/view/styles.css").toExternalForm();
	        URL arquivoFXML = getClass().getResource("/br/com/Joaomos/view/main.fxml");
	        GridPane raiz = FXMLLoader.load(arquivoFXML);

	        Stage stage = (Stage) FCLTSMLabel.getScene().getWindow();

	        Scene menuPrincipalScene= new Scene(raiz, 370, 500);
	        menuPrincipalScene.getStylesheets().add(arquivoCSS);
	        stage.setScene(menuPrincipalScene);
	        stage.centerOnScreen();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	public void atualizarDadosFolhaPagamento() {
		fCLTS = new FuncionarioCLTService();
		
		FCLTSMLabel.setText(" R$ " + String.format("%.2f", fCLTS.calcularMedia()));
		FCLTSSLabel.setText(" R$ " + String.format("%.2f", fCLTS.calcularSomatorioSalarios()));
		
		fComS = new FuncionarioComService();
		
		FCOMSMLabel.setText(" R$ " + String.format("%.2f", fComS.calcularMedia()));
		FCOMSSLabel.setText(" R$ " + String.format("%.2f", fComS.calcularSomatorioSalarios()));
		
		fHorS = new FuncionarioHorService();
		
		FHORSMLabel.setText(" R$ " + String.format("%.2f", fHorS.calcularMedia()));
		FHORSSLabel.setText(" R$ " + String.format("%.2f" ,fHorS.calcularSomatorioSalarios()));
		
		Double mediaTotal = (fCLTS.calcularMedia() + fComS.calcularMedia() + fHorS.calcularMedia()) / 3;
		Double somatorioTotal = fCLTS.calcularSomatorioSalarios() + fComS.calcularSomatorioSalarios() + fHorS.calcularSomatorioSalarios();
		
		TotalSMLabel.setText("R$ " + String.format("%.2f", mediaTotal));
		TotalSSLabel.setText("R$ " + String.format("%.2f", somatorioTotal));
	}
}