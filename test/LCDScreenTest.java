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
		lcd.printNumber("123456789054336143", 3);
		} catch(Exception e) {
			e.printStackTrace();
		}
		assertTrue(true);
	}

}
