package factory;

import java.io.IOException;

public class ConcreteTxtCreator extends Creator {
	public TxtProduct factoryMethod() throws IOException{
		return new ConcreteTxtProduct();
	}
}
