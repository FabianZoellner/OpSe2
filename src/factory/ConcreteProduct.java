package factory;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import business.Buergeramt;

public class ConcreteProduct extends Product
{
	
	public ConcreteProduct()
	throws IOException{
			this.ein = new BufferedWriter(new FileWriter("Buergeraemter.csv", true));
		
	}

	@Override
	public void fuegeInDateiHinzu(Object object) throws IOException {
		this.ein.write(((Buergeramt)object).gibBuergeramtZurueck(';'));
	}
	
	@Override
	public void schliesseDatei() throws IOException {
		
		this.ein.close();
	}
	
}
