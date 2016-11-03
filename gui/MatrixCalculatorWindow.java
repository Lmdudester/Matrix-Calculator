package gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.File;
import matrix.*;

public class MatrixCalculatorWindow extends JFrame implements ActionListener {

  JButton btnExit, btnPerformOperation;
  JComboBox cbxM1, cbxM2, cbxOperation;
  File[] files;
  Matrix m1, m2;
  char operation;

  public MatrixCalculatorWindow() {
    this.setTitle("Matrix Calculator");
    this.setSize(450, 170);

    Container content = getContentPane();
    content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));

    MatrixCalculatorPanel panel = new MatrixCalculatorPanel();

    cbxM1 = new JComboBox();
    cbxM1.addActionListener(this);
    panel.add(cbxM1);

    cbxOperation = new JComboBox();
    cbxOperation.addActionListener(this);
    panel.add(cbxOperation);
    char[] ops = {' ','x', '+', '-'};
    for(char i : ops){
      cbxOperation.addItem(i);
    }

    cbxM2 = new JComboBox();
    cbxM2.addActionListener(this);
    panel.add(cbxM2);

    btnPerformOperation = new JButton("Perform Operation");
    btnPerformOperation.addActionListener(this);
    panel.add(btnPerformOperation);

    content.add(panel);
    panel.setBounds(0, 0, 450, 170);
    panel.setBackground(Color.lightGray);

    btnExit = new JButton("Exit");
    btnExit.addActionListener(this);
    panel.add(btnExit);

    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setVisible(true);
    this.setResizable(false);

    loadFiles();
    setControlValues();
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
      setControlValues();
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
      } else if (e.getSource().equals(cbxM1)){
          if(((JComboBox) e.getSource()).getSelectedItem().toString().equals("")){

          } else {
              m1 = new Matrix(((JComboBox) e.getSource()).getSelectedItem().toString());
          }
      } else if (e.getSource().equals(cbxM2)){
          if(((JComboBox) e.getSource()).getSelectedItem().toString().equals("")){

          } else {
              m2 = new Matrix(((JComboBox) e.getSource()).getSelectedItem().toString());
          }
      } else if (e.getSource().equals(cbxOperation)){
          if(((JComboBox) e.getSource()).getSelectedItem().toString().equals("")){

          } else {
              this.operation = ((JComboBox) e.getSource()).getSelectedItem().toString().charAt(0);
          }
      }
  }

  public void loadFiles(){
    File dir = new File("C:/Users/David/Documents/GitHub/Matrix-Calculator/matrices");
    files = dir.listFiles();
    if(files != null){
      cbxM1.addItem("");
      cbxM2.addItem("");
      for(File i : files){
        cbxM1.addItem(i.toString());
        cbxM2.addItem(i.toString());
      }
    } else {
      System.out.println("NULL");
    }
  }

  public void setControlValues(){
    if(cbxM1 != null && cbxM2 != null && cbxOperation != null){
    btnPerformOperation.setEnabled((!cbxM1.getSelectedItem().toString().equals("")) &&
    (!cbxM2.getSelectedItem().toString().equals("")) && (cbxOperation.getSelectedItem().toString().charAt(0) != ' '));

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
