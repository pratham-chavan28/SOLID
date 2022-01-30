package com.udemy.isp;

// The requirement is old-fashioned printer
// which only has Printing functionality
// Here we are forced to implement 2 other non-useful methods - fax and scan.
// Users may use fax and scan on this old-fashioned printers
// which will lead to exception
public class OldFashionedPrinter implements Machine {
  @Override
  public void print(Document d) {
    System.out.println("Print is working");
  }

  @Override
  public void fax(Document d) throws Exception {
    throw new Exception();
  }

  @Override
  public void scan(Document d) throws Exception {
    throw new Exception();
  }

}