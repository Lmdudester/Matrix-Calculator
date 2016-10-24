package matrix;

import java.util.Scanner;
import java.io.File;

public class MatrixMaker {
	
	/*
	 * _____fMakeMatrix_____
	 * - Returns a matrix from a properly formatted .txt file
	 * - If improperly formatted, throws exceptions and exits
	 */
	public static Matrix fMakeMatrix(String fPath){
		Scanner scan = null;
		Matrix m = null;
		try {
	         File file = new File(fPath);
	         scan = new Scanner(file);
	         int[] size = getSizeOf(scan.nextLine());
	         
	         m = new Matrix(size[0],size[1]);
	         for(int r = 0; r < size[0]; r++){
	        	 for(int c = 0; c < size[1]; c++){
	        		 m.changeIndex(r, c, scan.nextDouble());
	        	 }
	         }
	    } catch (Exception e) {
	    	e.printStackTrace();
	    	System.exit(1);
	    }
		
		return m;
	}
	
	/*
	 * _____getSizeOf_____
	 * - Returns an array of size 2
	 * - arr[0] is rows, arr[1] is columns
	 * - Throws errors for invalid formatting
	 */
	private static int[] getSizeOf(String s){
		int[] size = new int[2];
		Scanner line;
		try{
			line = new Scanner(s);
			size[0] = line.nextInt();
			line.next();
			size[1] = line.nextInt();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return size;
	}
}
