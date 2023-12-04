package gui.guiStaedtischeEinrichtungen;

import business.BuergeraemterModel;
import javafx.stage.Stage;

import Observer.*;

public class StaedtischeEinrichtungControl implements Observer{

	private StaedtischeEinrichtungenView einrichtungView;
	
	private BuergeraemterModel aemterModel;
	
	public StaedtischeEinrichtungControl(Stage primaryStage, BuergeraemterModel aemterModel)
	{
		this.einrichtungView = new StaedtischeEinrichtungenView(primaryStage, aemterModel);
		
		this.aemterModel = aemterModel;
		
		this.aemterModel.addObserver(this);
	}
	
	@Override
	public void update()
	{
		this.einrichtungView.zeigeBuergeraemterAn();
	}
}
