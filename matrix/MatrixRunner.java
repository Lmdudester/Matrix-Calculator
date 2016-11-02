
public class MatrixRunner {

	public static void main(String[] args) {
		// for(String s : args){
		// 	System.out.println(s);
		// }
		if(args.length != 3){
			System.out.println(args.length + " is not a valid number of arguments.");
			return;
		}
		Matrix m1 = new Matrix(args[0]);
		char operation = args[1].charAt(0);
		Matrix m2 = new Matrix(args[2]);

		System.out.println("Matrix 1:\n" + m1.toString());
		System.out.println("Matrix 2:\n" + m2.toString());
		if(m1.equals(m2)){
			System.out.println("m1 is the same as m2");
		}

		Matrix result = null;
		if(operation == '+'){
			result = Matrix.add(m1, m2);
		} else if(operation == '-'){
			result = Matrix.subtract(m1, m2);
		} else if(operation == 'x'){
			result = Matrix.multiply(m1, m2);
		} else {
			System.out.println(operation + " is not a valid operation.");
			return;
		}

		System.out.println("Matrix Operation Result:\n" + result.toString());
		System.out.println("The result matrix is: " + (result.isSymmetric() ? "Symmetric" : "Not Symmetric"));

	}

}
