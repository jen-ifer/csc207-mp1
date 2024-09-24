package edu.grinnell.csc207.main;

import java.io.PrintWriter;
import edu.grinnell.csc207.util.CipherUtils;

/**
 * This is the cipher main java file.
 */
public class Cipher {
  /**
   * This is the cipher class.
   */

  /**
   * This is the all caesar class.
   * 
   * @param args
   */
  public static void main(String[] args) {
    PrintWriter pen = new PrintWriter(System.out, true);
    if (args.length != 4) {
      System.err.println("Error: AllCaesar with more than 4 arguments");
      pen.close();
      return;
    } // This loop checks we get 4 arguments (decode/encode, vigenere/caesar, a word, and a key)
    boolean caesar = false;
    boolean vigenere = false;
    boolean encode = false;
    boolean decode = false;
    String word = null;
    char caesarKey = '\0';
    String key = null;
    for (int i = 0; i < args.length; i++) {
      if (args[i].equals("-caesar")) {
        caesar = true;
      } // this checks the index i it checks if the string is caesar and make caesar true bc its
        // true that this string is in the args[]
      else if (args[i].equals("-vigenere")) {
        vigenere = true;
      } // this checks the index i it checks if the string is vigenere and make vigenere true bc its
        // true that this string is in the args[]
      else if (args[i].equals("-encode")) {
        encode = true;
      } // this checks the index i it checks if the string is encode and make encode true bc its
        // true that this string is in the args[]
      else if (args[i].equals("-decode")) {
        decode = true;
      } // this checks the index i it checks if the string is decode and make decode true bc its
        // true that this string is in the args[]
      else if (word == null) {
        word = args[i];
      } // this is to check if the variable word is empty because if it is I want the first word i
        // get form my args to go here
      else {
        if (1 == args[i].length()) {
          caesarKey = args[i].charAt(0);
        } // This just checks the length of the second string.If the length = 1 then the second
          // sting is for the ceasar cipher if its longer for vinegere
        else {
          key = args[i];
        } // if
      } // if
    } // for
    if (word.contains(" ")) {
      word = null;
      System.err.println("Error: Cipher doesn't accept arguments with white space");
      pen.close();
      return;
    } // if



    if (caesar && encode) {
      pen.println(CipherUtils.caesarEncrypt(word, caesarKey));
    } // if

    if (caesar && decode) {
      pen.println(CipherUtils.caesarDecrypt(word, caesarKey));
    } // if

    if (vigenere && encode) {
      String result;
      result = CipherUtils.vigenereEncrypt(word, key);
      if (result != null && !result.isEmpty()) {
        pen.println(result);
      } // if
    } // if

    if (vigenere && decode) {
      String result;
      result = CipherUtils.vigenereDecrypt(word, key);
      if (result != null && !result.isEmpty()) {
        pen.println(result);
      } // if
    } // if
  } // main
} // Cipher

