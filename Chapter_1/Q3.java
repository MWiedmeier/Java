import java.util.*;
import java.io.*;

public class Q3{

  public static void main(String args[]){

    String str1 = args[0];
    String str2 = args[1];

    int utf_chars[] = new int[256];

    int len1 = str1.length();
    int len2 = str2.length();

    for(int i = 0; i < len1; i++){
      utf_chars[str1.charAt(i)]++;
    }

    for(int j = 0; j < len2; j++){
      utf_chars[str2.charAt(j)]--;
    }

    for(int k = 0; k < utf_chars.length; k++){
      if(utf_chars[k] != 0){
        System.out.println("Not a permutation!!");
        return;
      }
    }
  } // end main

}
