
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
}
