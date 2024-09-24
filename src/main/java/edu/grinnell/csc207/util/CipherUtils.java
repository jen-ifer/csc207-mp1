package edu.grinnell.csc207.util;

/**
 * This is the cipher util java file
 */
public class CipherUtils {
  /**
   * This is the cipher utils class.
   */
  /**
   * @param letter
   * @return a letter converted to an int
   */
  private static int letter2int(char letter) {
    char x = letter;
    int letToInt = x - 'a';
    return letToInt;
  } // letter to int

  /**
   * @param i
   * @return an integer to a letter
   */
  private static char int2letter(int i) {
    int letterconvert = i + 'a';
    char intTolet = (char) (letterconvert);
    return intTolet;
  } // int to letter

  /**
   * 
   * @param str
   * @param letter
   * @return string for a caesar encrypted message
   */
  public static String caesarEncrypt(String str, char letter) {
    int LEN_ALPHA = 26;
    letter -= 'a';
    char[] str2array = str.toCharArray();
    int[] arrayOfInts;
    StringBuilder finalString = new StringBuilder();
    arrayOfInts = new int[str2array.length];
    for (int i = 0; i < str.length(); i++) {
      arrayOfInts[i] = letter2int(str2array[i]);
      arrayOfInts[i] = (arrayOfInts[i] + letter) % LEN_ALPHA;
      str2array[i] = int2letter(arrayOfInts[i]);
      finalString.append(str2array[i]);
    } //for
    return finalString.toString();
  } //Caesar encrypt

  /**
   * @param str
   * @param letter
   * @return string for a caesar decrypted message
   */
  public static String caesarDecrypt(String str, char letter) {
    int LEN_ALPHA = 26;
    char[] str2array = str.toCharArray();
    int[] arrayOfInts;
    letter -= 'a';
    StringBuilder finalString = new StringBuilder();
    arrayOfInts = new int[str2array.length];
    for (int i = 0; i < str.length(); i++) {
      arrayOfInts[i] = letter2int(str2array[i]);
      arrayOfInts[i] = (arrayOfInts[i] - letter);
      if (arrayOfInts[i] < 0) {
        arrayOfInts[i] = arrayOfInts[i] + LEN_ALPHA;
      } //if
      arrayOfInts[i] = arrayOfInts[i] % LEN_ALPHA;
      str2array[i] = int2letter(arrayOfInts[i]);
      finalString.append(str2array[i]);
    } //for
    return finalString.toString();
  } // ceasarDecrypt

  /**
   * @param str
   * @param key
   * @return string for a vigenere encrypted message
   */
  public static String vigenereEncrypt(String str, String key) {
    int LEN_ALPHA = 26;
    for (int i = 0; i < key.length(); i++) {
      if (Character.isUpperCase(key.charAt(i))) {
        System.err.print("Error:");
        key = null;
        return null;
      } // if
    } // for
    char[] str1 = str.toCharArray();
    char[] str2 = key.toCharArray();
    int[] str1num;
    str1num = new int[str1.length];
    int[] vi;
    vi = new int[str1.length];
    char[] encryptedVig;
    encryptedVig = new char[str1.length];
    StringBuilder finalString = new StringBuilder();
    for (int a = 0; a < str1.length; a++) {
      str1num[a] = letter2int(str1[a]);
    } // for
    for (int b = 0; b < str1.length; b++) {
      if (b < str2.length) {
        vi[b] = letter2int(key.charAt(b));
      } else {
        vi[b] = letter2int(str2[b % (str2.length)]);
      } // else
    } // for
    for (int c = 0; c < str1.length; c++) {
      encryptedVig[c] = int2letter((str1num[c] + vi[c]) % LEN_ALPHA);
      finalString.append(encryptedVig[c]);
    } // for
    return finalString.toString();
  } //Vigenere encrypt

  /**
   * @param str
   * @param key
   * @return string decrypted vigenere message
   */
  public static String vigenereDecrypt(String str, String key) {
    int LEN_ALPHA = 26;
    for (int i = 0; i < key.length(); i++) {
      if (Character.isUpperCase(key.charAt(i))) {
        key = null;
        System.err.print("Error:");
        return null;
      } // if
    } // for
    char[] str1 = str.toCharArray();
    char[] str2 = key.toCharArray();
    int[] str1num;
    str1num = new int[str1.length];
    int[] vi;
    vi = new int[str1.length];
    char[] decryptedVig;
    decryptedVig = new char[str1.length];
    StringBuilder finalString = new StringBuilder();
    for (int a = 0; a < str1.length; a++) {
      str1num[a] = letter2int(str1[a]);
    } // for
    for (int b = 0; b < str1.length; b++) {
      if (b < str2.length) {
        vi[b] = letter2int(key.charAt(b));
      } else {
        vi[b] = letter2int(str2[b % (str2.length)]);
      } // else
    } // for
    for (int c = 0; c < str1.length; c++) {
      decryptedVig[c] = int2letter(((str1num[c] - vi[c]) + LEN_ALPHA) % LEN_ALPHA);
      finalString.append(decryptedVig[c]);
    } // for
    return finalString.toString();
  } // vigenereDecrypt
} // CipherUtils


