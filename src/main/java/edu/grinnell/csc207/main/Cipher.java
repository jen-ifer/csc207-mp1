package edu.grinnell.csc207.main;

import java.io.PrintWriter;

public class Cipher {
  public static void main(String[] args) {
    PrintWriter pen = new PrintWriter(System.out, true);
    String encoDeco;
    String caesarOrVig;
    for (int i = 0; i < args.length; i++) {
      if(args[i].equals("-encode")){
  
      }





      pen.printf("args[%d] = \"%s\"\n", i, args[i]);
    }
    pen.close();
    System.err.println("Error: Invalid parameters");
  }
}
