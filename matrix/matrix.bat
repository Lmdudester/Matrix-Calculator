
javac Matrix.java
javac MatrixRunner.java

java MatrixRunner m1.csv + m2.csv
java MatrixRunner m1.txt + m2.txt
java MatrixRunner m1.txt + m2.csv
java MatrixRunner m1.csv + m2.txt
java MatrixRunner m1.csv - m2.csv
java MatrixRunner m1.txt - m2.txt
java MatrixRunner m1.txt - m2.csv
java MatrixRunner m1.csv - m2.txt
java MatrixRunner m1.csv x m2.csv
java MatrixRunner m1.txt x m2.txt
java MatrixRunner m1.txt x m2.csv
java MatrixRunner m1.csv x m2.txt

del /f Matrix.class
del /f MatrixRunner.class

pause
