package matrix;

import java.util.Scanner;
import java.io.File;
import java.lang.IllegalStateException;
import java.math.BigDecimal;

public class Matrix {
	private BigDecimal[][] matrix;
	int rows, columns;

	/*
	 * _____Matrix(int r, int c)_____
	 * - Creates an empty matrix with r rows and c columns
	 * - Initializes all values to 0.0
	 */
	public Matrix(int r, int c){
		matrix = new BigDecimal[r][c];
		rows = r;
		columns = c;
	}

	/*
	 * _____Matrix(String fPath)_____
	 * - Creates an matrix based on a properly formatted .csv or .txt file
	 */
	public Matrix(String fPath){
		Scanner scan = null;
		try {
	         File file = new File(fPath);
					 //System.out.println(fPath.substring(fPath.length() - 4));
					 boolean isCSV = (fPath.length() > 4) && (fPath.substring(fPath.length() - 4).equals(".csv"));
					 //System.out.println(isCSV);
	         scan = new Scanner(file);

					 //Reads size of matrix and creates a properly sized matrix
					 Scanner line = new Scanner(scan.nextLine());
					 if(isCSV){
						 scan.useDelimiter(",");
						 line.useDelimiter(",");
					 }
					 rows = line.nextInt();
		 			 line.next();
		 			 columns = line.nextInt();
					 matrix = new BigDecimal[rows][columns];

					 //Places all values into Matrix
	         for(int r = 0; r < rows; r++){
						 line = new Scanner(scan.nextLine());
						 if(isCSV){
							 line.useDelimiter(",");
						 }
					 	 for(int c = 0; c < columns; c++){
						 		this.setIndex(r, c, line.nextDouble());
					 	 }
	         }
	    } catch (Exception e) {
	    	e.printStackTrace();
	    	System.exit(1);
	    }
	}



	/*****Index Editing*****/

	public int getRows(){
		return this.rows;
	}

	public int getColumns(){
		return this.columns;
	}

	/*
	 * _____changeIndex()_____
	 * - Places value into matrix position [r,c]
	 */
	public void setIndex(int r, int c, double value){
		if(r >= rows || c >= columns)
			throw new ArrayIndexOutOfBoundsException("Matrix is [" + rows + ", " + columns + "]. Position ["
					+ r + ", " + c + "] does not exist.");

		matrix[r][c] = new BigDecimal(value);
	}

	/*
	 * _____accessIndex_____
	 * - Returns the double value at the given position
	 */
	public double getIndex(int r, int c){
		if(r >= rows || r < 0 || c >= columns || c < 0)
			throw new ArrayIndexOutOfBoundsException("Matrix is [" + rows + ", " + columns + "]. Position ["
					+ r + ", " + c + "] does not exist.");
		return matrix[r][c].doubleValue();
	}

	/*****Instance Methods******/

	/*
	 * _____isSymmetric_____
	 * - Returns true if the matrix is symmetric
	*/
	public boolean isSymmetric(){
		if(this.rows != this.columns){
			return false;
		}
		for(int c = 0; c < this.columns; c ++){
			for(int r = c + 1; r < this.rows; r ++){
				if(this.matrix[r][c].compareTo(this.matrix[c][r]) != 0){
					return false;
				}
			}
		}
		return true;
	}

	/*
	 * _____equals_____
	 * - Returns true if the current instance and parameter matrix are equal
 	*/
	@Override
 	public boolean equals(Object obj){
		if (obj == null) {
        return false;
    }
    if (!Matrix.class.isAssignableFrom(obj.getClass())) {
        return false;
    }
    final Matrix input = (Matrix) obj;

		if(input == null || !(input instanceof Matrix)){
	 		return false;
		}
	 	if(this.rows != input.getRows() || this.columns != input.getColumns()){
			return false;
		}
		for(int r = 0; r < this.rows; r++){
	 		for(int c = 0; c < this.columns; c++){
				if(this.getIndex(r,c) != input.getIndex(r,c)){
	 				return false;
	 			}
	 		}
		}
		return true;
  }

	/*****Elementary Operations*****/

	/*
	 * _____transpose_____
	 * - Switches the Matrix to it's transpose
	 */
	public void transpose(){
		BigDecimal[][] matrixT = new BigDecimal[columns][rows];

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

		BigDecimal[] temp = matrix[r1 - 1];
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
			matrix[r-1][c] = matrix[r-1][c].multiply(new BigDecimal(scalar));
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
			matrix[r2 - 1][c].add(matrix[r1 - 1][c]);
		}
	}

	/*
	 * _____rowAdd(int r1, int r2, double scalar)_____
	 * - Adds (scalar)r1 to r2
	 */
	public void rowAdd(int r1, int r2, double scalar){
		checkRowInput(r1);
		checkRowInput(r2);
		BigDecimal temp;

		for(int c = 0; c < columns; c++){
			temp = matrix[r1 - 1][c];
			temp = temp.multiply(new BigDecimal(scalar));
			matrix[r2 - 1][c].add(temp);
		}
	}

	/*
   * _____scaleMatix______
	 * - Scales the whole matrix by the parameter scalar
	*/
	public void scaleMatrix(double scalar){
		for(int r = 0; r < this.rows; r++){
			this.rowScale(r, scalar);
		}
	}

	/*****Echeclon Forms*****/

	/*
	 * _____rref_____
	 * - Changes the Matrix into its Reduced Row Echeclon Form
	*//*
public void rref()
{
    int lead = 0;
    int rowCount = rows;
    int colCount = columns;
    int i;
    boolean quit = false;

    for(int row = 0; row < rowCount && !quit; row++) {
        if(colCount <= lead) {
            quit = true;
            break;
        }
        i = row;

        while(!quit && matrix[i][lead].doubleValue() == 0.0) { //Here
            i++;
            if(rowCount == i) {
                i=row;
                lead++;

                if(colCount == lead) {
                    quit = true;
                    break;
                }
            }
        }

        if(!quit)
        {
            this.rowSwap(i + 1, row + 1);

            if(matrix[row][lead].doubleValue() != 0.0)
                rowScale(row + 1, 1.0f / matrix[row][lead].doubleValue());

            for(i = 0; i < rowCount; i++) {
                if(i != row)
                    rowAdd( row + 1, i + 1, matrix[i][lead].doubleValue()*-1);
            }
        }
    }
}*/

	/*****Output Methods****/

	/* _____toString_____
	 * - Converts Matrix to a string
	 * - Must be on a line by itself to look neat
	 */
	@Override
	public String toString(){
		StringBuilder result = new StringBuilder();
		for(int r = 0; r < rows; r++){
			for(int c = 0; c < columns; c++){
				result.append(matrix[r][c].doubleValue() + "\t");
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

	/*****Arithmetic Methods*****/

	/*
	 * _____add_____
	 * - Adds two Matrices and returns the resulting matrix
	 * - Throws an error if sizes don't match
	 */
	public static Matrix add(Matrix m1, Matrix m2){
		if(m1.rows != m2.rows || m1.columns != m2.columns){
			throw new IllegalStateException("Cannot Add Matricies of Different Sizes.");
		}

		Matrix result = new Matrix(m1.rows, m1.columns);

		for(int r = 0; r < m1.rows; r++){
			for(int c = 0; c < m1.columns; c++){
				result.setIndex(r, c, (m1.getIndex(r, c) + m2.getIndex(r, c)));
			}
		}

		return result;
	}

	/*
	 * _____subtract_____
	 * - Subtracts two Matrices and returns the resulting matrix
	 * - Throws an error if sizes don't match
	 */
	public static Matrix subtract(Matrix m1, Matrix m2){
		if(m1.rows != m2.rows || m1.columns != m2.columns){
			throw new IllegalStateException("Cannot Add Matricies of Different Sizes.");
		}

		Matrix result = new Matrix(m1.rows, m1.columns);

		for(int r = 0; r < m1.rows; r++){
			for(int c = 0; c < m1.columns; c++){
				result.setIndex(r, c, (m1.getIndex(r, c) - m2.getIndex(r, c)));
			}
		}

		return result;
	}

	/*
	 * _____multiply_____
	 * - Multiplies two Matrices and returns the resulting matrix
	 * - Throws an error if sizes don't match
	 */
	public static Matrix multiply(Matrix m1, Matrix m2){
		if(m1.columns != m2.rows){
			throw new IllegalStateException("Error: Matrix 1 must have the same number of columns as Matrix 2 has rows.");
		}

		Matrix result = new Matrix(m1.rows, m2.columns);

		//should improve this efficency
		for(int r = 0; r < m1.rows; r++){
			for(int c = 0; c < m2.columns; c++){
				double newValue = 0.0;
				for(int i = 0; i < m1.columns; i++){
					newValue += (m1.getIndex(r, i)) * (m2.getIndex(i, c));
				}
				result.setIndex(r, c, newValue);
			}
		}

		return result;
	}

}
