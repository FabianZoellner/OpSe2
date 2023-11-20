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
		this.ein.write("Daten des Bürgeramts");
		this.ein.write("\nName des Bürgeramts: " + a.getName());
		this.ein.write("\nÖffnungszeit des Bürgeramts: "+ a.getGeoeffnetVon() + " - " + a.getGeoeffnetBis());
		this.ein.write("\nStraße und Hausnummer des Bürgeramts: "+ a.getStrasseHNr());
		this.ein.write("\nDienstleistungen des Bürgeramts: "+ a.getDienstleistungenAlsString(','));
		
	}

	@Override
	public void closeTxt() throws IOException {
		this.ein.close();	
	}

}
