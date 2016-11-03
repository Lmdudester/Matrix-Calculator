all: Matrix GUI Main clean

Matrix: matrix/Matrix.java
	javac matrix/Matrix.java

GUI: gui/MatrixCalculatorWindow.java
	javac gui/MatrixCalculatorWindow.java

Main: gui/MatrixCalculator.java
	javac gui/MatrixCalculator.java
	java gui/MatrixCalculator

clean:
	rm -f gui/*.class
	rm -f matrix/*.class
