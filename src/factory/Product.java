package factory;

import java.io.BufferedWriter;
import java.io.IOException;

public abstract class Product {
	
	BufferedWriter ein;
	
	public abstract void fuegeInDateiHinzu(Object object)throws IOException;
	public abstract void schliesseDatei() throws IOException;
}
