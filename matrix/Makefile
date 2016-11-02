all: Matrix Main

Matrix: Matrix.java MatrixArithmetic.java MatrixMaker.java
	javac Matrix.java
	javac MatrixArithmetic.java
	javac MatrixMaker.java

Main: MatrixRunner.java
	javac MatrixRunner.java
	java MatrixRunner m1.csv m2.csv
	java MatrixRunner m1.txt m2.txt
	java MatrixRunner m1.txt m2.csv
	java MatrixRunner m1.csv m2.txt
