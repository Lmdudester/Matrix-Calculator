# Java Matrix Calculator

Performs basic operations upon Matrices stored in text or csv files.

    - Reads Matrix Files from a specified directory
    - Uses GUI to specify two matrix files
    - Computes Matrix Operation 
    - Returns Resulting Matrix

Developed Using Java.

## How To Use:
   1. Place at least two .csv files of the proper formatting (See Below) into the *matricies* subfolder
   2. Run MatrixCalc.bat
   3. Use the GUI to choose the two matricies where the higher choice is A and the bottom is B as in: A (operation) B
   4. Look to the terminal window for the result

## Methods:
    Matrix Arithmetic:
        Addition - add(Matrix a, Matrix b):
            - Adds two Matrix objects of the same size
            - Returns a new Matrix object, containing a + b
            - Will return an error if arrays are not of equal size
        Subtraction - subtract(Matrix a, Matrix b):
            - Subtracts two Matrix objects of the same size
            - Returns a new Matrix object, containing a - b
            - Will return an error if arrays are not of equal size
        Multiplication - multiply(Matrix a, Matrix b):
            - Multiplies two Matrix objects of size (m x n) and (n x r)
            - Returns a new Matrix object of size (m x r)
            - Will return an error if arrays are not of equal size

    Elementary Operations:
        Row Swapping - rowSwap(int row1, int row2):
            - Swaps the positions of the two given rows
            - Arguments: 1 <= row1 <= n, 1 <= row2 <= n

        Row Scaling - rowScale(int row, double scalar):
            - Scales row by the given scalar
            - Arguments: 1 <= row <= n + 1, scalar ∈ Real Numbers

        Row Addition - rowAdd(int row1, int row2):
            - Adds the row1 to row2
            - Arguments: 1 <= row1 <= n, 1 <= row2 <= n

        Row Addition with Scaling - rowAdd(int row1, int row2, double scalar):
            - Adds (row1 * scalar) to row2
            - Arguments: 1 <= row1 <= n, 1 <= row2 <= n, scalar ∈ Real Numbers

        Transposing - transpose():
            - Changes the matrix to its transpose

    Instance Methods:
        Equality Checker - equals(Object obj)
            - Compares the current instance to the given object
            - Returns true if they are equal, but false otherwise
        
        Symmetry Checker - isSymmetric()
            - Determines if the current instance is a symmetric matrix
            - Returns true if it is, false otherwise

    Output:
        String - toString():
            - Returns the matrix in a string format
            - Must begin on a new line (if printed) or alignment will be off

## Coming Soon:

  - RREF Generation, Identity Generation.
  - Develop Regressive Test Cases for all operations
  - Create Guide for using the calculator and making matrix files
  - Improve GUI for better usability

## Format for [matrix name].txt Files:

    [m] x [n]
    a b c ...
    d e f ...
    g h i ...
    ...   ...

## Format for [matrix name].csv Files:

    m,x,n
    a, b, c, ...
    d, e, f, ...
    g, h, i, ...
    .,.,.,   ...



Developed by Liam Davies, with contributions by David Parsons
