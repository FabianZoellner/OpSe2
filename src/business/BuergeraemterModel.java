package business;

import java.io.*;

import factory.ConcreteCreator;
import factory.ConcreteTxtCreator;
import factory.Creator;
import factory.Product;
import factory.TxtProduct;

public class BuergeraemterModel {
 		
	private Buergeramt buergeramt;

	public Buergeramt getBuergeramt() {
		return this.buergeramt;
	}
	
	public void setBuergeramt(Buergeramt buergeramt) {
		this.buergeramt = buergeramt;
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

}