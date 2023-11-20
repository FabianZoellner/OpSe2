package factory;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import business.Buergeramt;

public class ConcreteTxtProduct extends TxtProduct {

	public ConcreteTxtProduct()
			throws IOException{
					this.ein = new BufferedWriter(new FileWriter("Buergeraemter.txt", false));
			}
	
	@Override
	public void exportToTxt(Object object) throws IOException {
		Buergeramt a = (Buergeramt)object;
		this.ein.write("Daten des B�rgeramts");
		this.ein.write("\nName des B�rgeramts: " + a.getName());
		this.ein.write("\n�ffnungszeit des B�rgeramts: "+ a.getGeoeffnetVon() + " - " + a.getGeoeffnetBis());
		this.ein.write("\nStra�e und Hausnummer des B�rgeramts: "+ a.getStrasseHNr());
		this.ein.write("\nDienstleistungen des B�rgeramts: "+ a.getDienstleistungenAlsString(','));
		
	}

	@Override
	public void closeTxt() throws IOException {
		this.ein.close();	
	}

}
