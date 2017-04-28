
/**
 * 
 */

/**
 * @author Andres Ceballos Sánchez - andres.ceballoss@udea.edu.co
 * @version 1.0
 *
 */
public class CustomValidator {
	
	public static final String FINAL_SYMBOL = "0,0";
	public static final String SEPARATOR_SYMBOL =",";
	
	/**
	 * Check if the string is a number
	 * @param numericString string to be validated
	 * @return true if the string is a number. Otherwise, return false
	 */
	public static boolean isNumeric(String numericString) {
		try {
			Integer.parseInt(numericString);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
	
	/**
	 * Method to validate the entry (size, number) 
	 * @param entry  
	 */
	public static void validateEntry(String entry) {
		
		/*Arrays to store entry parameters*/
		String [] parameters;
		Integer [] numParameters = new Integer [2];
		
		/*Validate if the entry contains the separator symbol*/
		if(!entry.contains(",")) {
			throw new IllegalArgumentException("La entrada " + entry + "no posee el caracter separador "
					+ SEPARATOR_SYMBOL);
		}
		
		//Split the entry
		parameters = entry.split(SEPARATOR_SYMBOL);
		
		/*Check the number of parameters*/
		if(parameters.length > 2) {
			throw new IllegalArgumentException("La entrada " + entry + "posee más de un caracter separador "
					+ SEPARATOR_SYMBOL);
		}
		
		if(parameters.length < 2) {
			throw new IllegalArgumentException("La entrada " + entry + "no posee el formato requerido");
		}
		
		
		/*Check the format (number) of parameters*/
		if(isNumeric(parameters[0])) {
			numParameters[0] = Integer.parseInt(parameters[0]);
			
			if(numParameters[0] < 0 || numParameters[0] > 10) {
				throw new IllegalArgumentException("El parametro size [" + numParameters[0] +
						"debe estar entre 1 y 10");
			}
		} else {
			throw new IllegalArgumentException("El parametro size [" + numParameters[0] +
					"no es un número");
		}
		
		if(!isNumeric(parameters[1])) {
			throw new IllegalArgumentException("El parametro numero[" + numParameters[1] + 
					"no es un número");
		}
		
	}
	
	

}
