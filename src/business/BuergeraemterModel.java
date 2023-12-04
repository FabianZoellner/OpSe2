package business;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import factory.ConcreteCreator;
import factory.ConcreteTxtCreator;
import factory.Creator;
import factory.Product;
import factory.TxtProduct;
import Observer.*;

public class BuergeraemterModel implements Observable {
 		
	private Buergeramt buergeramt;
	
	private static BuergeraemterModel instance;
	
	private List<Observer> observer = new ArrayList<Observer>();
	
	private BuergeraemterModel()
	{
		
	}

	public Buergeramt getBuergeramt() {
		return this.buergeramt;
	}
	
	public void setBuergeramt(Buergeramt buergeramt) {
		this.buergeramt = buergeramt;
		this.notifyObservers();
	}
 	
	public static BuergeraemterModel getInstance()
	{
		if(instance == null)
		{
			instance = new BuergeraemterModel();
		}
		return instance;
	}
	
	
	public void schreibeBuergeraemterInCsvDatei()
	    throws IOException{
		
	    Creator concreteCreator = new ConcreteCreator();
	    
	    Product a = (Product) concreteCreator.factoryMethod();
	    
	    a.fuegeInDateiHinzu(this.buergeramt);
	    
	   	a.schliesseDatei();
 	}
	public void schreibeBuergeraemterInTxtDatei()
	throws IOException{
		Creator concreteTxtCreator = new ConcreteTxtCreator();
		
		TxtProduct a = (TxtProduct) concreteTxtCreator.factoryMethod();
		
		a.exportToTxt(this.buergeramt);
		a.closeTxt();
	}

	@Override
	public void addObserver(Observer observer) {
		this.observer.add(observer);
	}

	@Override
	public void removeObserver(Observer observer) {
		this.observer.remove(observer);
	}

	@Override
	public void notifyObservers() {
		for(Observer o: this.observer)
		{
			o.update();
		}
	}

}