package edu.grinnell.csc207.main;
import java.io.PrintWriter;
import edu.grinnell.csc207.util.CipherUtils;

public class Cipher {
  public static void main(String[] args) {
    PrintWriter pen = new PrintWriter(System.out, true);
    if(args.length != 4 ){
      System.err.println("Error: AllCaesar with more than 4 arguments");
      pen.close();
      return;
    }
    boolean caesar = false;
    boolean vigenere = false;
    boolean encode = false;
    boolean decode = false;
    String word = null;
    char caesarKey = '\0';
    String key = null;
    for (int i = 0; i < args.length; i++) {
      if(args[i].equals("-caesar")){
        caesar = true;
      }
      else if(args[i].equals("-vigenere")){
        vigenere = true;
      }
      else if(args[i].equals("-encode")){
          encode = true;
        }
      else if(args[i].equals("-decode")){
          decode = true;
        }
      else if(word == null){
            word = args[i];
          }
      else{
        if(1 == args[i].length()){
          caesarKey = args[i].charAt(0);
        }
        else{
          key = args[i];
        }
      }
    }
  if(word.contains(" ")){
    word = null;
    System.err.println("Error: Cipher doesn't accept arguments with white space");
      pen.close();
      return;
  }


  
    if(caesar && encode){
      pen.println(CipherUtils.caesarEncrypt(word, caesarKey));
    }

    if(caesar && decode){
      pen.println(CipherUtils.caesarDecrypt(word, caesarKey));
    }

    if(vigenere && encode){
      String result;
      result = CipherUtils.vigenereEncrypt(word, key);
      if(result != null && !result.isEmpty()){
        pen.println(result);
      }
    }

    if(vigenere && decode){
      String result;
      result = CipherUtils.vigenereDecrypt(word, key);
      if(result != null){
        pen.println(result);
      }
    }
  
  
  }}

  //     }
  //   if (caesar && decode){
  //       pen.printf("n = %c: %s\n", caesarKey, CipherUtils.caesarDecrypt(word, caesarKey));
  //   }
  // }}
    

    // if(vigenere && encode){
    //   pen.printf("%s\n",CipherUtils.vigenereEncrypt(word, key));
    // }
    // pen.close();
    // //System.err.println("Error: Invalid parameters");
  
  
