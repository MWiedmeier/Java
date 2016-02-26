import java.util.*;
import java.io.*;

public class Q5{

  public static void main(String args[]){

    String str = args[0];

    String output = "";
    int counter = 1;
    for(int i = 0; i < str.length(); i++){

        if((i+1 != str.length()) && str.charAt(i) == str.charAt(i+1)){
          counter++;
        }
        else{
          //Not the same, new sequence
          output+=str.charAt(i) +""+counter;
          counter = 1;
        }

    }

    if(output.length() > str.length()){
      System.out.println("Original String is Shorter!");
      output = str;
    }else{
      System.out.println("New String is Shorter!");
    }

    System.out.println(output);

  } // end main

}
