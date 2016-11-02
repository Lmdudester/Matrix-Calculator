
public class MatrixRunner {

	public static void main(String[] args) {
		for(String s : args){
			System.out.println(s);
		}
		Matrix m1 = new Matrix(args[0]);
		Matrix m2 = new Matrix(args[1]);

		System.out.println("Matrix 1:\n" + m1.toString());
		System.out.println("Matrix 2:\n" + m1.toString());

		Matrix sum = MatrixArithmetic.add(m1, m2);

		System.out.println("Matrix Sum:\n" + sum.toString());

	}

}
