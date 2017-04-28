package co.edu.udea.screenlcd.logic;
import static org.junit.Assert.*;

import org.junit.Test;

import co.edu.udea.screenlcd.logic.LCDScreen;

/**
 * 
 */

/**
 * @author Andres Ceballos Sanchez
 * @version 1.0
 *
 */
public class LCDScreenTest {

	/**
	 * Test method for {@link LCDScreen#printNumber(java.lang.String, int)}.
	 * Test that the method not throws exceptions
	 */
	@Test
	public void testPrintNumber() {
		LCDScreen lcd = new LCDScreen();
		try {
			lcd.printNumber("1234567890", 3, 1);
			assertTrue(true);
		} catch(Exception e) {
			throw new IllegalArgumentException("Error: " + e.getMessage());
		}
	}

}
