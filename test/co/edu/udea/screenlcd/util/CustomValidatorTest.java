package co.edu.udea.screenlcd.util;
import static org.junit.Assert.*;

import org.junit.Test;

import co.edu.udea.screenlcd.util.CustomValidator;
/**
 * @author Andres Ceballos Sanchez - andres.ceballoss@udea.edu.co
 * @version 1.0
 *
 */
public class CustomValidatorTest {

	/**
	 * Test method for {@link CustomValidator#isNumeric(java.lang.String)}.
	 * Test when the method returns true
	 */
	@Test
	public void testIsNumeric() {
		String validString = "123456789";
		boolean resultTest = CustomValidator.isNumeric(validString);
		assertTrue(resultTest);
	}

	/**
	 * Test method for {@link CustomValidator#validateEntry(java.lang.String)}.
	 * Test that the method not throws exceptions
	 */
	@Test
	public void testValidateEntry() {
		String validEntry = "2,1985";
		try {
			CustomValidator.validateEntry(validEntry);
			assertTrue(true);
		} catch (Exception e) {
			throw new IllegalArgumentException("Error: " + e.getMessage());			
		}
	}

}
