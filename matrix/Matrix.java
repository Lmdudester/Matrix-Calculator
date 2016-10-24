package matrix;

public class Matrix {
	double[][] matrix;
	int rows, columns;
	
	/*
	 * _____Matrix()_____
	 * - Creates an empty matrix with r rows and c columns
	 * - Initializes all values to 0.0
	 */
	public Matrix(int r, int c){
		matrix = new double[r][c];
		rows = r;
		columns = c;
	}
	
	
	/*****Index Editing*****/
	
	/*
	 * _____changeIndex()_____
	 * - Places value into matrix position [r,c]
	 */
	public void changeIndex(int r, int c, double value){
		if(r >= rows || c >= columns)
			throw new ArrayIndexOutOfBoundsException("Matrix is [" + rows + ", " + columns + "]. Position ["
					+ r + ", " + c + "] does not exist.");
		
		matrix[r][c] = value;
	}
	
	/*
	 * _____accessIndex_____
	 * - Returns the double value at the given position
	 */
	public double accessIndex(int r, int c){
		if(r >= rows || r <= 0 || c >= columns || c <= 0)
			throw new ArrayIndexOutOfBoundsException("Matrix is [" + rows + ", " + columns + "]. Position ["
					+ r + ", " + c + "] does not exist.");
		return matrix[r][c];
	}
	
	
	/*****Elementary Operations*****/
	
	/*
	 * _____transpose_____
	 * - Switches the Matrix to it's transpose
	 */
	public void transpose(){
		double[][] matrixT = new double[columns][rows];
		
		for(int r = 0; r < rows; r++){
			for(int c = 0; c < columns; c++){
				matrixT[c][r] = matrix[r][c];
			}
		}
		
		matrix = matrixT;
		
		int temp = rows;
		rows = columns;
		columns = temp;
	}
	
	/*
	 * _____rowSwap_____
	 * - Swaps two rows in the matrix
	 * - r1 and r2 are from 1 thru (m+1): When A[mxn] Matrix
	 */
	public void rowSwap(int r1, int r2){
		checkRowInput(r1);
		checkRowInput(r2);
		
		double[] temp = matrix[r1 - 1];
		matrix[r1 - 1] = matrix[r2 - 1];
		matrix[r2 - 1] = temp;
	}
	
	/*
	 * _____rowScale_____
	 * - Scales a certain row in the matrix
	 * - r is from 1 thru (m+1): When A[mxn] Matrix
	 */
	public void rowScale(int r, double scalar){
		checkRowInput(r);
		
		for(int c = 0; c < columns; c++){
			matrix[r-1][c] *= scalar;
		}
	}
	
	/*
	 * _____rowAdd(int r1, int r2)_____
	 * - Adds r1 to r2
	 */
	public void rowAdd(int r1, int r2){
		checkRowInput(r1);
		checkRowInput(r2);
		
		for(int c = 0; c < columns; c++){
			matrix[r2 - 1][c] += matrix[r1 - 1][c];
		}
	}
	
	/*
	 * _____rowAdd(int r1, int r2, double scalar)_____
	 * - Adds (scalar)r1 to r2
	 */
	public void rowAdd(int r1, int r2, double scalar){
		checkRowInput(r1);
		checkRowInput(r2);
		
		for(int c = 0; c < columns; c++){
			matrix[r2 - 1][c] += scalar*matrix[r1 - 1][c];
		}
	}
	
	
	/*****Output Methods****/
	
	/* _____toString_____
	 * - Converts Matrix to a string
	 * - Must be on a line by itself to look neat
	 */
	public String toString(){
		StringBuilder result = new StringBuilder();
		for(int r = 0; r < rows; r++){
			for(int c = 0; c < columns; c++){
				result.append(matrix[r][c] + "\t");
			}
			result.append('\n');
		}
		
		return result.toString();
	}
	
	
	/*****Error Throwing Methods*****/
	
	/*
	 * _____checkRowInput_____
	 * - Ensures value is in range, throws error if not
	 * - Range 1 to (m-1) where A is [mxn] matrix
	 */
	private void checkRowInput(int val){
		if(val > rows || val <= 0)
			throw new ArrayIndexOutOfBoundsException("Matrix is [" + rows + ", " + columns + "]. Row " + 
					val + " does not exist.");
	}
}
