package edu.grinnell.csc207.util;

public class CipherUtils {
  private static int letter2int(char letter) {
    char x = letter;
    int letToInt = x - 'a'; 
    return letToInt; // STUB
  }

  private static char int2letter(int i) {
    int letterconvert = i + 'a';
    char intTolet = (char)(letterconvert);
    return intTolet; // STUB
  }

    /**
     * 
     * @param str
     * @param letter
     * @return
     */
  public static String caesarEncrypt(String str, char letter) {
    letter -= 'a';
    char[] str2array = str.toCharArray();
    int[] arrayOfInts;
    StringBuilder finalString = new StringBuilder();
    arrayOfInts = new int[str2array.length];
    for(int i=0; i< str.length(); i++){
      arrayOfInts[i] = letter2int(str2array[i]);
      arrayOfInts[i]= (arrayOfInts[i] + letter) % 26;
      str2array[i] = int2letter(arrayOfInts[i]);
      finalString.append(str2array[i]);
      }
    return finalString.toString(); // STUB
  }

  public static String caesarDecrypt(String str, char letter) {
    char[] str2array = str.toCharArray();
    int[] arrayOfInts;
    letter -= 'a';
    StringBuilder finalString = new StringBuilder();
    arrayOfInts = new int[str2array.length];
    for(int i=0; i< str.length(); i++){
      arrayOfInts[i] = letter2int(str2array[i]);
      arrayOfInts[i]= (arrayOfInts[i] - letter);
      if(arrayOfInts[i] < 0){
        arrayOfInts[i] = arrayOfInts[i] + 26;
      }
      arrayOfInts[i]= arrayOfInts[i] % 26;
      str2array[i] = int2letter(arrayOfInts[i]);
      finalString.append(str2array[i]);
      }
    return finalString.toString(); // STUB
  }

  public static String vigenereEncrypt(String str, String key) {
    for(int i=0; i< key.length(); i++){
      if(Character.isUpperCase(key.charAt(i))){
        System.err.print("Error:");
        key = null;
        return null;
      }
    }
    char[] str1 =str.toCharArray();
    char[] str2= key.toCharArray();
    int[] str1num;
    str1num = new int [str1.length];
    int[] vi;
    vi = new int[str1.length];
    char[] encryptedVig;
    encryptedVig =  new char [str1.length];
    StringBuilder finalString = new StringBuilder();
    for(int a=0; a< str1.length; a++){
      str1num[a]=letter2int(str1[a]);
    }
    for(int b=0; b<str1.length; b++){
      if(b < str2.length){
        vi[b] = letter2int(key.charAt(b));
      } else{
        vi[b]=letter2int(str2[b % (str2.length)]);
      }
    }
    for(int c=0; c<str1.length; c++){
      encryptedVig[c] = int2letter((str1num[c] + vi[c])% 26);
      finalString.append(encryptedVig[c]);
    }
    return finalString.toString(); // STUB
  }

  public static String vigenereDecrypt(String str, String key) {
    for(int i=0; i< key.length(); i++){
      if(Character.isUpperCase(key.charAt(i))){
        key = null;
        System.err.print("Error:");
        return null;
      }}
    char[] str1 =str.toCharArray();
    char[] str2= key.toCharArray();
    int[] str1num;
    str1num = new int [str1.length];
    int[] vi;
    vi = new int[str1.length];
    char[] decryptedVig;
    decryptedVig =  new char [str1.length];
    StringBuilder finalString = new StringBuilder();
    for(int a=0; a< str1.length; a++){
      str1num[a]=letter2int(str1[a]);
    }
    for(int b=0; b<str1.length; b++){
      if(b < str2.length){
        vi[b] = letter2int(key.charAt(b));
      } else{
        vi[b]=letter2int(str2[b % (str2.length)]);
      }
    }
    for(int c=0; c<str1.length; c++){
      decryptedVig[c] = int2letter(((str1num[c] - vi[c])+26)% 26);
      finalString.append(decryptedVig[c]);
    }
    return finalString.toString(); // STUB
  }
}


