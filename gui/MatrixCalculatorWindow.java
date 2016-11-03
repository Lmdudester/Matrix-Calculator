package gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import matrix.*;

public class MatrixCalculatorWindow extends JFrame implements ActionListener {

  JButton btnExit;
  JButton btnPerformOperation;
  Matrix m1;
  Matrix m2;
  char operation;

  public MatrixCalculatorWindow() {
    this.setTitle("Matrix Calculator");
    this.setSize(860, 480);

    Container content = getContentPane();
    content.setLayout(null);

    MatrixCalculatorPanel panel = new MatrixCalculatorPanel();

    btnExit = new JButton("Exit");
    btnExit.addActionListener(this);
    panel.add(btnExit);

    btnPerformOperation = new JButton("Perform Operation");
    btnPerformOperation.addActionListener(this);
    panel.add(btnPerformOperation);

    content.add(panel);
    panel.setBounds(0, 0, 850, 450);
    panel.setBackground(Color.lightGray);

    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    this.setVisible(true);
  }

  public void redraw() {
      this.repaint();
      try {
          Thread.sleep(500);
      } catch (InterruptedException e) {
          // should never happen
      }
  }

  public void close() {
      this.setVisible(false);
      this.dispose();
  }

  public void actionPerformed(ActionEvent e) {
      if(e.getSource().equals(btnExit)){
          System.out.println("EXIT WAS CLICKED");
          this.close();
      } else if (e.getSource().equals(btnPerformOperation)) {
          Matrix result = null;
          if(this.operation == '+'){
            result = Matrix.add(this.m1, this.m2);
          } else if(this.operation == '-'){
            result = Matrix.subtract(this.m1, this.m2);
          } else if(this.operation == 'x'){
            result = Matrix.multiply(this.m1, this.m2);
          } else {
            System.out.println(operation + " is not a valid operation.");
            return;
          }
          System.out.println("Matrix Operation Result:\n" + result.toString());
          System.out.println("The result matrix is: " + (result.isSymmetric() ? "Symmetric" : "Not Symmetric"));
      }
  }

  //////////////////////////////////////////////////////////////////////////////////////////////
  // inner classes
  //////////////////////////////////////////////////////////////////////////////////////////////
  private class MatrixCalculatorPanel extends JPanel {

      public void paintComponent(Graphics g) {
          super.paintComponent(g);
      }

  }

}
