package gui.guiStaedtischeEinrichtungen;
   
import java.util.ArrayList;

import business.BuergeraemterModel;
import business.Buergeramt;
import javafx.event.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import ownUtil.*;

public class StaedtischeEinrichtungenView {
	
	private BuergeraemterModel buergeraemterModel;
	
	
    	//---Anfang Attribute der grafischen Oberflaeche---
    	private Pane pane = new  Pane();
    	private Label lblAnzeigeBuergeraemter = new Label("Anzeige Bürgerämter");
    	private TextArea txtAnzeigeBuergeraemter  = new TextArea();
    	private Button btnAnzeigeBuergeraemter = new Button("Anzeige");
    	//-------Ende Attribute der grafischen Oberflaeche-------
    
    	public StaedtischeEinrichtungenView(Stage primaryStage, BuergeraemterModel model){
    		Scene scene = new Scene(this.pane, 560, 340);
    		primaryStage.setScene(scene);
    		primaryStage.setTitle("Anzeige von städtischen " 
 			+ "Einrichtungen");
    		primaryStage.show();
    		// Hier ergaenzen
    		this.buergeraemterModel = model;


		this.initKomponenten();
		this.initListener();
    	}

    	private void initKomponenten(){
    		// Label
 		Font font = new Font("Arial", 20);
       	lblAnzeigeBuergeraemter.setLayoutX(310);
    		lblAnzeigeBuergeraemter.setLayoutY(40);
    		lblAnzeigeBuergeraemter.setFont(font);
    		lblAnzeigeBuergeraemter.setStyle("-fx-font-weight: bold;"); 
       	pane.getChildren().add(lblAnzeigeBuergeraemter);    
        	


// Textbereich	
        	txtAnzeigeBuergeraemter.setEditable(false);
     		txtAnzeigeBuergeraemter.setLayoutX(310);
    		txtAnzeigeBuergeraemter.setLayoutY(90);
     		txtAnzeigeBuergeraemter.setPrefWidth(220);
    		txtAnzeigeBuergeraemter.setPrefHeight(185);
       	pane.getChildren().add(txtAnzeigeBuergeraemter);        	
        	// Button
          	btnAnzeigeBuergeraemter.setLayoutX(310);
        	btnAnzeigeBuergeraemter.setLayoutY(290);
        	pane.getChildren().add(btnAnzeigeBuergeraemter); 
   }
   
   private void initListener() {
	    btnAnzeigeBuergeraemter.setOnAction(
 			new EventHandler<ActionEvent>() {
	    		@Override
	        	public void handle(ActionEvent e) {
	            	zeigeBuergeraemterAn();
	        	} 
   	    });
    }
   
    public void zeigeBuergeraemterAn(){
    	if(buergeraemterModel.getBuergeramt().size() > 0){
			StringBuffer text = new StringBuffer();
			
			
			ArrayList<Buergeramt>aemter = buergeraemterModel.getBuergeramt();
			
			for(Buergeramt b : aemter)
			{
				text.append(b.gibBuergeramtZurueck(' '));
				text.append("\n");
			}
			
			txtAnzeigeBuergeraemter.setText(text.toString());
		}
    		else{
    			zeigeInformationsfensterAn(
 				"Bisher wurde kein Bürgeramt aufgenommen!");
    		}
    }	
   
    private void zeigeInformationsfensterAn(String meldung){
    	  	new MeldungsfensterAnzeiger(AlertType.INFORMATION,
               	"Information", meldung).zeigeMeldungsfensterAn();
    }	
    
}
