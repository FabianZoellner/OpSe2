package business;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BuergeramtTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void test() {
		Buergeramt b = new Buergeramt(
				"Querenburg",
				9.0f,
				17.0f,
				"Querenburger Höhe 256",
				"Hauptwohnsitz,Nebenwohnsitz".split(","));
		
		assertTrue(b.getName() == "Querenburg","Der Name ist nicht Querenburg");
	}
	@Test
	void test2() {
		
		Throwable exc = assertThrows(IllegalArgumentException.class, 
				()->{
					new Buergeramt(
							"Querenburg",
							9.0f,
							17.0f,
							"Querenburger Höhe 256",
							null);
				});
		assertEquals("Dienstleistungen dürfen nicht 0 sein",
				exc.getMessage());
	}
}
