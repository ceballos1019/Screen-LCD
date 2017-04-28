/**
 * 
 */
package co.edu.udea.screenlcd.logic;

/** * 
 * @author Andres Ceballos Sanchez - andres.ceballoss@udea.edu.co
 * @version 1.0
 *
 */
public interface Screen {
	
	/**
	 * Prints a number with a specific size and space
	 * @param _number number to be printed
	 * @param _size size of each digit of the number
	 * @param space space between digits
	 */
	public void printNumber(String _number, int _size, int space);
}
