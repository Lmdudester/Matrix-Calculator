
import java.lang.IllegalStateException;

public class MatrixArithmetic {

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
