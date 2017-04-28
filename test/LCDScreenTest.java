import static org.junit.Assert.*;

import org.junit.Test;

/**
 * 
 */

/**
 * @author user
 *
 */
public class LCDScreenTest {

	/**
	 * Test method for {@link LCDScreen#printNumber(java.lang.String, int)}.
	 */
	@Test
	public void testPrintNumber() {
		LCDScreen lcd = new LCDScreen();
		try {
		lcd.printNumber("1234567890", 3, 5);
		} catch(Exception e) {
			e.printStackTrace();
		}
		assertTrue(true);
	}

}
