package gui.guiBuergeraemter;

import java.io.IOException;

import business.BuergeraemterModel;
import javafx.stage.Stage;
import Observer.*;

public class BuergeraemterControl implements Observer {
	
	private BuergeraemterView buergeraemterView;
	private BuergeraemterModel buergeraemterModel;

	public BuergeraemterControl(Stage primaryStage){
		this.buergeraemterModel = BuergeraemterModel.getInstance();
		this.buergeraemterView = new BuergeraemterView(this, primaryStage, 
				buergeraemterModel);
		
		this.buergeraemterModel.addObserver(this);
	}
	
	void schreibeBuergeraemterInDatei(String typ){
	   	try{
	   		if("csv".equals(typ)){
	   			buergeraemterModel.schreibeBuergeraemterInCsvDatei();
	   			buergeraemterView.zeigeInformationsfensterAn(
	   				"Die Bürgerämter wurden gespeichert!");
	   		}
	   		else{
	   			buergeraemterModel.schreibeBuergeraemterInTxtDatei();
	   			buergeraemterView.zeigeInformationsfensterAn(
	   				"Die Txt wurde exportiert!");
	   		}
	    } 
		catch(IOException exc){
			buergeraemterView.zeigeFehlermeldungsfensterAn(
				"IOException beim Speichern!");
		}
		catch(Exception exc){
			buergeraemterView.zeigeFehlermeldungsfensterAn(
				"Unbekannter Fehler beim Speichern!");
		}
    }

	@Override
	public void update()
	{
		this.buergeraemterView.zeigeBuergeraemterAn();
	}
	
}
