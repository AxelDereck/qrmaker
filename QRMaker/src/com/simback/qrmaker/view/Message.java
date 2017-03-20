package com.simback.qrmaker.view;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Message {

	public static void showInformation(String message) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("SBK QR Maker - Information");
		alert.setHeaderText(null);
		alert.setContentText(message);
		
		alert.showAndWait();
	}
	
	public static void showError(String message) {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("SBK QR Maker - Erreur");
		alert.setHeaderText(null);
		alert.setContentText(message);
		
		alert.showAndWait();
	}
}
