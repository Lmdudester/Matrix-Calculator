package gui;

import java.awt.*;
import java.net.*;
import java.awt.Desktop;
import java.awt.event.*;
import javax.swing.*;
import java.io.File;
import matrix.*;
import java.nio.file.*;
import java.io.*;

public class MatrixCalculatorWindow extends JFrame implements ActionListener {

  private MatrixCalculatorPanel panel = new MatrixCalculatorPanel();
  private JButton btnEditM2 = panel.btnEditM2;
  private JButton btnEditM1 = panel.btnEditM1;
  private JButton btnPerformOperation = panel.btnPerformOperation;
  private JButton btnExit = panel.btnExit;
  private JComboBox cbxM1 = panel.cbxM1;
  private JComboBox cbxOperation = panel.cbxOperation;
  private JComboBox cbxM2 = panel.cbxM2;

  Desktop esktop;
  File[] files;
  Matrix m1, m2;
  char operation;
  String mainDirectory = Paths.get("").toAbsolutePath().toString();

  public MatrixCalculatorWindow() {
    mainDirectory.replace("\\","/");


    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.getContentPane().add(panel);
    this.setTitle("Matrix Calculator");
    this.pack();
    this.setVisible(true);
    this.setResizable(false);

    btnPerformOperation.addActionListener(this);
    btnExit.addActionListener(this);
    btnEditM1.addActionListener(this);
    btnEditM2.addActionListener(this);
    cbxM1.addActionListener(this);
    cbxOperation.addActionListener(this);
    cbxM2.addActionListener(this);

    char[] ops = {' ','x', '+', '-'};
    for(char i : ops){
      cbxOperation.addItem(i);
    }

    try{
      esktop = null;
      if (esktop.isDesktopSupported()) {
          esktop = esktop.getDesktop();
      }
    }catch(Exception e){
      e.printStackTrace();
    }

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
              m1 = new Matrix(mainDirectory + "\\matrices\\" + ((JComboBox) e.getSource()).getSelectedItem().toString());
          }
      } else if (e.getSource().equals(cbxM2)){
          if(((JComboBox) e.getSource()).getSelectedItem().toString().equals("")){

          } else {
              m2 = new Matrix(mainDirectory + "\\matrices\\"+ ((JComboBox) e.getSource()).getSelectedItem().toString());
          }
      } else if (e.getSource().equals(cbxOperation)){
          if(((JComboBox) e.getSource()).getSelectedItem().toString().equals("")){

          } else {
              this.operation = ((JComboBox) e.getSource()).getSelectedItem().toString().charAt(0);
          }
      } else if (e.getSource().equals(btnEditM1)) {
        try {
          if(esktop != null){
            esktop.open(new File(mainDirectory + "\\matrices\\"+ cbxM1.getSelectedItem().toString()));
          }
        } catch (Exception ex){
          ex.printStackTrace();
        }
      } else if (e.getSource().equals(btnEditM2)) {
        try {
          if(esktop != null){
            esktop.open(new File(mainDirectory + "\\matrices\\"+ cbxM2.getSelectedItem().toString()));
          }
        } catch (Exception ex){
          ex.printStackTrace();
        }
      }
  }

  public void loadFiles(){
    File dir = new File(mainDirectory + "/matrices");
    mainDirectory.replace("/", "\\");
    files = dir.listFiles();
    if(files != null){
      cbxM1.addItem("");
      cbxM2.addItem("");
      for(File i : files){
        cbxM1.addItem(i.toString().replace(mainDirectory + "\\matrices\\", ""));
        cbxM2.addItem(i.toString().replace(mainDirectory + "\\matrices\\", ""));
      }
    } else {
      System.out.println("NULL");
    }
    mainDirectory.replace("\\","/");
  }

  public void setControlValues(){
    try {
      btnPerformOperation.setEnabled((!cbxM1.getSelectedItem().toString().equals("")) &&
      (!cbxM2.getSelectedItem().toString().equals("")) && (cbxOperation.getSelectedItem().toString().charAt(0) != ' '));
      btnEditM1.setEnabled(!cbxM1.getSelectedItem().toString().equals(""));
      btnEditM2.setEnabled(!cbxM2.getSelectedItem().toString().equals(""));
    } catch (Exception e) {
      //e.printStackTrace();
    }
  }

  //////////////////////////////////////////////////////////////////////////////////////////////
  // inner classes
  //////////////////////////////////////////////////////////////////////////////////////////////
  private class MatrixCalculatorPanel extends JPanel {

      JButton btnEditM2, btnEditM1, btnPerformOperation, btnExit;
      JComboBox cbxM1, cbxOperation, cbxM2;

      public MatrixCalculatorPanel() {
            //construct preComponents
            String[] cbxM1Items = {};
            String[] cbxOperationItems = {};
            String[] cbxM2Items = {};

            //construct components
            btnEditM2 = new JButton ("Edit Matrix");
            btnEditM1 = new JButton ("Edit Matrix");
            btnPerformOperation = new JButton ("PerformOperation");
            cbxM1 = new JComboBox (cbxM1Items);
            cbxOperation = new JComboBox (cbxOperationItems);
            cbxM2 = new JComboBox (cbxM2Items);
            btnExit = new JButton ("Exit");

            //set components properties
            btnEditM2.setEnabled (false);
            btnEditM1.setEnabled (false);
            //btnPerformOperation.setEnabled (false);

            //adjust size and set layout
            setPreferredSize (new Dimension (355, 160));
            setLayout (null);

            //add components
            add (btnEditM2);
            add (btnEditM1);
            add (btnPerformOperation);
            add (cbxM1);
            add (cbxOperation);
            add (cbxM2);
            add (btnExit);

            //set component bounds (only needed by Absolute Positioning)
            btnEditM2.setBounds (215, 60, 100, 20);
            btnEditM1.setBounds (40, 60, 100, 20);
            btnPerformOperation.setBounds (107, 85, 140, 25);
            cbxM1.setBounds (40, 30, 100, 25);
            cbxOperation.setBounds (145, 30, 65, 25);
            cbxM2.setBounds (215, 30, 100, 25);
            btnExit.setBounds (107, 115, 140, 25);

            btnEditM2.setPreferredSize (new Dimension(100, 25));
            btnEditM1.setPreferredSize (new Dimension(100, 25));
            btnPerformOperation.setPreferredSize (new Dimension(140, 25));
            cbxM1.setPreferredSize (new Dimension(100, 25));
            cbxOperation.setPreferredSize(new Dimension(65, 25));
            cbxM2.setPreferredSize (new Dimension(100, 25));
            btnExit.setPreferredSize (new Dimension(140, 25));
        }

      public void paintComponent(Graphics g) {
          super.paintComponent(g);
      }

  }

}
