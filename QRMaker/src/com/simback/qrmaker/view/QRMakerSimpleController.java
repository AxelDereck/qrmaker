package com.simback.qrmaker.view;

import java.io.File;

import com.simback.qrmaker.MainApp;
import com.simback.qrmaker.controller.QRGenerator;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;

public class QRMakerSimpleController {

	@FXML
	private TextField textToEncode;
	
	@FXML
	private TextField targetDir;
	
	@FXML
	private  TextField fileName;
	
	@SuppressWarnings("unused")
	private MainApp mainApp;

	/**
	 * The Default Constructor.
	 * The constructor is called before the initialize() method. 
	 */
	public QRMakerSimpleController() {

	}
	
	/**
	 * Initializes the controller class. This method is automatically called 
	 * after the fxml file has been loaded.
	 */
	@FXML
	public void initialize() {
		
	}
	
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}
	
	/**
	 * Called when the user clicks on the Generate QR button.
	 */
	@FXML
	private void launchGeneration() {
		String filePath = targetDir.getText() + fileName.getText();
		int result = QRGenerator.generateQR(filePath, textToEncode.getText());
		switch(result) {
		case 0:
			Message.showError("Erreur lors de la génération du fichier !");
			break;
			
		case 1:
			Message.showInformation("Génération du fichier réussi avec succès !");
			break;
		}
	}
	
	/**
	 * Called when the user clicks on the "Parcourir..." button
	 * to selected the target directory where to store the generated file.
	 */
	@FXML
	private void selectTargetDirectory() {
//		System.out.println("Essai DirChooser !");
		DirectoryChooser dirChooser = new DirectoryChooser();
//		System.out.println("dirChooser Ref : " + dirChooser);
//		System.out.println("primaryStage Ref : " + mainApp.getPrimaryStage());
		File selDir = dirChooser.showDialog(null);
//		File selDir = dirChooser.showDialog(mainApp.getPrimaryStage());
		
		if(null != selDir) {
			targetDir.setText(selDir.getPath() + "\\");
		}
	}
}
