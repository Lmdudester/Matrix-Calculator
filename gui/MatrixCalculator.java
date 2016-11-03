package gui;

import matrix.*;

public class MatrixCalculator {

    public static void main(String[] args){
      MatrixCalculatorWindow calculator = new MatrixCalculatorWindow();
      if(args.length != 3){
  			System.out.println(args.length + " is not a valid number of arguments.");
  		}
  		calculator.operation = '+';
    }

}
