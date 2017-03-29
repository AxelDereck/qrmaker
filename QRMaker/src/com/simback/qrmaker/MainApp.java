package com.simback.qrmaker;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TitledPane;
import javafx.stage.Stage;

public class MainApp extends Application {
	private Stage primaryStage;
	private TitledPane rootLayout;

	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("SBK QRMaker");
		
		initRootLayout();
	}
	
	/**
	 * Initializes the root layout.
	 * @param args
	 */
	public void initRootLayout() {
		try {
			// Load root layout from FXML file
			FXMLLoader loader = new FXMLLoader();
//			loader.setLocation(MainApp.class.getResource("view/qrmaker_simple.fxml"));
			loader.setLocation(MainApp.class.getResource("view/qrmaker_batch.fxml"));
			rootLayout = (TitledPane) loader.load();
			
			// Show the scene containing the root layout.
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(IOException ex) {
			ex.printStackTrace();
		}
	}
	
	/**
	 * Returns the primaryStage
	 */
	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public static void main(String[] args) {
		launch(args);
	}
}
