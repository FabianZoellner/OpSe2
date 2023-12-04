package main;

import business.BuergeraemterModel;
import gui.guiBuergeraemter.BuergeraemterControl;
import gui.guiStaedtischeEinrichtungen.StaedtischeEinrichtungControl;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		new BuergeraemterControl(primaryStage);
		
		Stage fenster2 = new Stage();
		
		new StaedtischeEinrichtungControl(fenster2, BuergeraemterModel.getInstance());
	}	
	
	public static void main(String[] args){
		launch(args);
	}
}
