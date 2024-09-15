package edu.grinnell.csc207.main;

import java.io.PrintWriter;
import edu.grinnell.csc207.util.CipherUtils;

public class AllCaesar {
  public static void main(String[] args) {
    PrintWriter pen = new PrintWriter(System.out, true);
    if(args.length != 3){
      System.err.println("I only accept 3 arguments!");
      pen.close();
      return;
    }
      String encoOrDeco = args[1];
      String str = args[2];
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
          System.err.println("you didn't use encode or decode!");
        }
        pen.close();
      }
  }
