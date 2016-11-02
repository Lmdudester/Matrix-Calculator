# Java Matrix Calculator

Performs basic operations upon Matrices stored in text or csv files.

    - Reads Matrix Files Path's from command line
    - Computes Matrix Operation
    - Returns Resulting Matrix

Developed Using Java.

## How To Use:
    Using Input Files:
        1. Create 1 or more .csv or .txt files containing a matrix. (Format specified below)
        2. Create a Matrix object with the .csv or .txt filepath string as its parameter. [Matrix(fPath)]
        3. Call any of the methods described in the Methods Header Below
        
    Creating in code:
        1. Create a Matrix object giving rows and columns as parameters. [Matrix(rows, columns)]
        2. Fill in each position using setIndex()
        3. Call any of the methods described in the Methods Header Below

## Methods:
    Matrix Arithmetic:
        Addition - add(Matrix a, Matrix b):
            - Adds two arrays of the same size
            - Returns a new Matrix object, containing a + b
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

    Output:
        String - toString():
            - Returns the matrix in a string format
            - Must begin on a new line (if printed) or alignment will be off

## Coming Soon:

  - Matrix Subtraction, RREF Generation, Identity Generation.
  - Add Operation to be performed to command line
  - Develop Regressive Test Cases for all operations
  - Create Guide for using the calculator and making matrix files
  - Implment a GUI for better usability

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
