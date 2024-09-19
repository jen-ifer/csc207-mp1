package edu.grinnell.csc207.main;

import java.io.PrintWriter;
import edu.grinnell.csc207.util.CipherUtils;

public class AllCaesar {
  public static void main(String[] args) {
    PrintWriter pen = new PrintWriter(System.out, true);
    if(args.length != 2 ){
      System.err.println("Error: AllCaesar with zero arguments");
      pen.close();
      return;
    }
    
      String encoOrDeco = args[0];
      String str = args[1];
      if(encoOrDeco.equals("encode")){
        for (char ch = 'a'; ch <= 'z'; ch++) {
          pen.printf("n = %c: %s\n", ch, CipherUtils.caesarEncrypt(str, ch));
        }
      }
      else if(encoOrDeco.equals("decode")){
          for (char ch = 'a'; ch <= 'z'; ch++) {
            pen.printf("n = %c: %s\n", ch, CipherUtils.caesarDecrypt(str, ch));
          } 
        }
        else{
          System.err.println("Error: Invalid option: " + encoOrDeco + " Valid options are \"encode\" or \"decode\".");
        }
        pen.close();
      }
  }
