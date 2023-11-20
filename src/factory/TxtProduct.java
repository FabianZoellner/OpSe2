package factory;

import java.io.BufferedWriter;
import java.io.IOException;

public abstract class TxtProduct {
	BufferedWriter ein;
	
	public abstract void exportToTxt(Object object) throws IOException;
	public abstract void closeTxt() throws IOException;
}
