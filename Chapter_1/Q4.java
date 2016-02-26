import java.util.*;
import java.io.*;

public class Q4{

  public static void main(String args[]){

    String str = args[0];

    char[] cArr = str.toCharArray();
    int i = cArr.length-1;
    int j = i;

    while(cArr[i]== ' '){
      i--;
    }

    while( j > 0 ){

      if(cArr[i] == ' '){
        cArr[j--] = '0';
        cArr[j--] = '2';
        cArr[j] = '%';
      }else{
        cArr[j] = cArr[i];
      }

      i--; j--;
    }

    System.out.println(cArr);
  } // end main

}
