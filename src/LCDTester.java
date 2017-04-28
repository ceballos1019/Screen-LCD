import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author Andres Ceballos Sanchez - andres.ceballoss@udea.edu.co
 * @version 1.0
 */
public class LCDTester {
	

	public static void main(String[] args) {
		
		//Screen to print the numbers
		LCDScreen screenLCD = new LCDScreen();
		
		//Array to store the input
		List<String> numbers = new ArrayList<>();
		
		//String to read the input
		String reader = "";
		
		//space between digits
		int spaceDigits = 0;
		
		/*Read the input*/
		try(Scanner scanner = new Scanner(System.in)) {			
			System.out.println("Ingrese el espacio entre digitos (0 a 5): ");
			reader = scanner.next();
			
			/*Validate if the input is numeric*/
			if(CustomValidator.isNumeric(reader)) {
				spaceDigits = Integer.parseInt(reader);
				
				/*Validate if the input fit the required format*/
				if(spaceDigits < 0 || spaceDigits > 5) {
					throw new IllegalArgumentException("Solo esta permitido un"
							+ " espacio entre digitos entre 0 - 5");
				}
			} else {
				throw new IllegalArgumentException("El espacio ingresado " + 
						reader + " no es un numero");
			}
			
			/*Read the numbers*/
			do {				
				System.out.println("Ingrese un número (tamaño, numero):");
				reader = scanner.next();
				if(!CustomValidator.FINAL_SYMBOL.equals(reader)) {
					numbers.add(reader);
				} 
			} while(!CustomValidator.FINAL_SYMBOL.equals(reader));
			
			/*Validate each number and print it in LCD Format*/
			Iterator<String> iterator = numbers.iterator();
			while(iterator.hasNext()) {
				String currentEntry = iterator.next();
				try {
					CustomValidator.validateEntry(currentEntry);
				} catch(Exception e) {
					throw new IllegalArgumentException("Error: " + e.getMessage());
				}	
				String [] params = currentEntry.split(CustomValidator.SEPARATOR_SYMBOL);				
				int sizeDigits = Integer.parseInt(params[0]);
				screenLCD.printNumber(params[1], sizeDigits, spaceDigits);	
				System.out.println();
			}				
			
		} catch(Exception ex) {
			System.out.println("Error: " + ex.getMessage());
		}
	}
}
