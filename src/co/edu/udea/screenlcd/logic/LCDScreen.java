package co.edu.udea.screenlcd.logic;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 */

/**
 * Class where it is defined the logic to print a number in LCD Screen format
 * Implementation of {@link Screen}
 * @author Andres Ceballos Sánchez - andres.ceballoss@udea.edu.co
 * @version 1.0
 *
 */
public class LCDScreen implements Screen {
	
	/*Constants*/
	public static final String HORIZONTAL_BAR = "-";
	public static final String VERTICAL_BAR = "|";
	public static final String SPACE_CHARACTER = " ";
	
	/*Number of rows and columns of each digit*/
	private Integer numRows;
	private Integer numCols;
	
	/*Size of digits to be printed*/
	private Integer size;
	private Integer space;
	/* 2D Array to store the structure of the digits to be printed*/
	private String[][] matrixPrint;	
	
	private Integer totalCols;	
	private Integer totalDigits;
	
	/**
	 * Print a number in style of LCD Screen
	 * @param _number Number to be printed
	 * @param _size Print size
	 */
	@Override
	public void printNumber(String _number, int _size, int _space) {
		
		//Set the size
		this.size = _size;
		
		//Set the space between digits
		this.space = _space;
		
		//Set the number of rows of each digit
		this.numRows = (2 * size) + 3;
		
		//Set the number of columns of each digit
		this.numCols = size + 2;		
		
		//Convert the String to a Integer array
		Integer [] digits = convertToArrayNumber(_number);
		
		//Create the matrix with the digits
		createMatrix(digits);
		
		//Print the matrix
		for(int i = 0; i < numRows; i++) {
			for (int j = 0; j < totalCols; j++) {
				System.out.print(matrixPrint[i][j]);
			}
			System.out.println();
		}
		
	}
	
	/**
	 * Method to convert a numeric String to an Integer array 
	 * @param _number numeric String
	 * @return Integer array
	 */
	private Integer[] convertToArrayNumber(String _number) {
		
		//Turn the String to char array
		char [] charDigits = _number.toCharArray();
		
		//number of digits
		totalDigits = charDigits.length;
		
		
		//Array to store the digits 
		Integer [] digits = new Integer[totalDigits];
		
		//Fill the array with the digits
		int currentDigit = 0;		
		int i = 0;
		char currentCharDigit = ' ';
		for(i = 0; i < totalDigits; i++){
			currentCharDigit = charDigits[i];
			
			//Validate that the character is a number
			if(!Character.isDigit(currentCharDigit)) {
				throw new IllegalArgumentException("El caracter " + currentCharDigit + " no es un número");
			}
			
			currentDigit = Character.getNumericValue(charDigits[i]);
			digits[i] = currentDigit;			
		}
		
		return digits;		
	}
	
	/**
	 * Method to create the matrix with the structure of LCD Scren
	 * @param _digits Array with the digits to be stored in the matrix
	 */
	private void createMatrix(Integer [] _digits) {
		
		//Calculate the total number of columns
		totalCols = (numCols * totalDigits) + ((totalDigits * space) - space);
		
		/*Create and initialize the matrix with blank spaces*/
		matrixPrint = new String[numRows][totalCols];		
		for(int i = 0; i < numRows; i++) {
			for (int j = 0; j < totalCols; j++) {
				matrixPrint[i][j] = SPACE_CHARACTER;
			}
		}
		
		List<Integer> segments = null;
		
		/*Add each digit to the matrix*/ 
		int index = 0;
		for(Integer currentDigit : _digits) {			
			segments = getSegments(currentDigit);
			addDigit(segments, index);
			index++;
		}
		
		
	}
	
	/**
	 * Method to get the segments that shape a digit
	 * @param _digit to be shaped with segments
	 * @return List<Integer> segments that shape the digit
	 */
	private List<Integer> getSegments(int _digit) {
		
		//List to store the segments of the digit
		List<Integer> segmentList = new ArrayList<>();
		
		switch(_digit) {
		case 0:
			segmentList.add(1);
			segmentList.add(2);
			segmentList.add(3);
			segmentList.add(7);
			segmentList.add(6);
			segmentList.add(5);
			break;
		case 1: 
			segmentList.add(3);
			segmentList.add(7);
			break;
		case 2:
			segmentList.add(2);
			segmentList.add(3);
			segmentList.add(4);
			segmentList.add(5);
			segmentList.add(6);
			break;
		case 3:
			segmentList.add(2);
			segmentList.add(3);
			segmentList.add(4);
			segmentList.add(7);
			segmentList.add(6);
			break;
		case 4:
			segmentList.add(1);
			segmentList.add(4);
			segmentList.add(3);
			segmentList.add(7);
			break;
		case 5:
			segmentList.add(2);
			segmentList.add(1);
			segmentList.add(4);
			segmentList.add(7);
			segmentList.add(6);
			break;
		case 6:
			segmentList.add(2);
			segmentList.add(1);
			segmentList.add(5);
			segmentList.add(6);
			segmentList.add(7);
			segmentList.add(4);
			break;
		case 7:
			segmentList.add(2);
			segmentList.add(3);
			segmentList.add(7);
			break;
		case 8:
			segmentList.add(1);
			segmentList.add(2);
			segmentList.add(3);
			segmentList.add(7);
			segmentList.add(6);
			segmentList.add(5);
			segmentList.add(4);
			break;
		case 9:
			segmentList.add(4);
			segmentList.add(1);
			segmentList.add(2);
			segmentList.add(3);
			segmentList.add(7);
			segmentList.add(6);
			break;
		}
		
		return segmentList;
	}
	
	/**
	 * Method to add a digit to the matrix 
	 * @param _segments list of segments that shape the digit
	 * @param _index position of the digit in the whole number
	 */
	private void addDigit(List<Integer> _segments, int _index) {
		
		//Array to store the start point in the matrix of each segment 
		Integer [] startPoints = null;
		
		/*Get the start point of each segment and fill it in the matrix*/
		for(Integer segment : _segments) {
			startPoints = getStartPoint(segment, _index);
			fillMatrix(startPoints, segment);
		}
	}
	
	/**
	 * Method to get the start point in the matrix of a segment given its index
	 * @param _segment segment
	 * @param _index index of the segment
	 * @return Integer[] Array with the row and column of the start point
	 */
	private Integer [] getStartPoint(int _segment, int _index) {
		
		//Array to store the start point
		Integer [] initialPos = new Integer [2];
		
		//start column of the segment depending on the index
		int colStart = _index * (numCols + space);
		
		/*Calculate the start point depending on the segment*/
		switch(_segment) {
			case 1:
				initialPos[0] = 1;
				initialPos[1] = colStart;
				break;
			case 2:
				initialPos[0] = 0;
				initialPos[1] = colStart + 1;
				break;
			case 3:
				initialPos[0] = 1;
				initialPos[1] = numCols + colStart - 1;
				break;
			case 4:
				initialPos[0] = (numRows / 2);
				initialPos[1] = colStart + 1;
				break;
			case 5:
				initialPos[0] = (numRows / 2) + 1;
				initialPos[1] = colStart;
				break;
			case 6:				
				initialPos[0] = numRows - 1;
				initialPos[1] = colStart + 1;
				break;
			case 7:				
				initialPos[0] = (numRows / 2) + 1;
				initialPos[1] = numCols + colStart - 1;
				break;
		}
		
		return initialPos;
	}
	
	/**
	 * Fill the segment in the matrix with the appropriate character and size 
	 * @param _startPoints segment start point in the matrix
	 * @param _currentSegment the segment 
	 */
	private void fillMatrix(Integer [] _startPoints, int _currentSegment) {		
		//Character to be stored in the matrix 
		String characterPrint = "";
		
		/*Initialize the row and column of the segment in the matrix*/
		int row = _startPoints[0];
		int column = _startPoints[1];
		
		//auxiliary variable to loop
		int i = 0;
		
		/*If the segment is even, it is a horizontal segment. Otherwise, it is a vertical segment.*/
		if(_currentSegment % 2 == 0) {
			characterPrint = HORIZONTAL_BAR;
			
			/*Iterate through the columns*/
			for(i = 0; i < size; i++) {
				matrixPrint[row][column] = characterPrint;
				column++;
			}
		} else {
			characterPrint = VERTICAL_BAR;
			
			/*Iterate through the rows*/
			for(i = 0; i < size; i++) {
				matrixPrint[row][column] = characterPrint;
				row++;
			}
		}		
		
	}
}
