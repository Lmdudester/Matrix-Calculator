package gui;

import matrix.*;

public class MatrixCalculator {

    public static void main(String[] args){
      MatrixCalculatorWindow calculator = new MatrixCalculatorWindow();
      if(args.length != 3){
  			System.out.println(args.length + " is not a valid number of arguments.");
  			return;
  		}
  		calculator.m1 = new Matrix(args[0]);
  		calculator.operation = args[1].charAt(0);
  		calculator.m2 = new Matrix(args[2]);

  		System.out.println("Matrix 1:\n" + calculator.m1.toString());
  		System.out.println("Matrix 2:\n" + calculator.m2.toString());
  		if(calculator.m1.equals(calculator.m2)){
  			System.out.println("m1 is the same as m2");
  		}

    }

}
