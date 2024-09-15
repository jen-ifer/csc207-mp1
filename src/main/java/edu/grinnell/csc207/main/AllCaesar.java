package edu.grinnell.csc207.main;

import java.io.PrintWriter;
import edu.grinnell.csc207.util.CipherUtils;

public class AllCaesar {
  public static void main(String[] args) {
    PrintWriter pen = new PrintWriter(System.out, true);
    if(args.length == 3){
      String encoOrDeco = args[1];
      String str = args[2];
      if(encoOrDeco == "encode"){
        for (char ch = 'a'; ch <= 'z'; ch++) {
          pen.printf("n = %c: %s\n", ch, CipherUtils.caesarEncrypt(str, ch));
        }
        pen.close();

      }
      else{
        if (encoOrDeco == "decode"){
          for (char ch = 'a'; ch <= 'z'; ch++) {
            pen.printf("n = %c: %s\n", ch, CipherUtils.caesarDecrypt(str, ch));
          }
          pen.close();
          
        }
      }
  }
 }
}
