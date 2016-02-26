import java.util.*;
import java.io.*;

public class Q1{

  public static void main(String args[]){

    String toCheck = args[0];
    int len = toCheck.length();
    for(int i = 0; i < len; i++){
      for(int j = i+1; j < len; j++){
        if(toCheck.charAt(i) == toCheck.charAt(j)){
          System.out.println("Not unique!");
          return;
        }
      }
    }

  } // end main

}
