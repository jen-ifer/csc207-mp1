package edu.grinnell.csc207.main;

import java.io.PrintWriter;
import edu.grinnell.csc207.util.CipherUtils;

/**
 * This is the all caesar main java file.
 */
public class AllCaesar {
  /**
   * This is the all caesar class.
   * 
   * @param args
   */
  public static void main(String[] args) {
    PrintWriter pen = new PrintWriter(System.out, true);
    if (args.length != 2) {
      System.err.println("Error: AllCaesar with zero arguments");
      pen.close();
      return;
    } // This if is to make sure I am only given 2 parameters for this to run
    String encoOrDeco = args[0];
    String str = args[1];
    if (encoOrDeco.equals("encode")) {
      for (char ch = 'a'; ch <= 'z'; ch++) {
        pen.printf("n = %c: %s\n", ch, CipherUtils.caesarEncrypt(str, ch));
      } // for
    } // If
    else if (encoOrDeco.equals("decode")) {
      for (char ch = 'a'; ch <= 'z'; ch++) {
        pen.printf("n = %c: %s\n", ch, CipherUtils.caesarDecrypt(str, ch));
      } // for
    } // if
    else {
      System.err.println(
          "Error: Invalid option: " + encoOrDeco + " Valid options are \"encode\" or \"decode\".");
    } // if the user doesn't input encode or decode when running the code then we will give the user
      // an error
    pen.close();
  } // main
} // Allcaesar
