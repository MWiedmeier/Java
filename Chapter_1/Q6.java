import java.util.*;
import java.io.*;

public class Q6{

  public static void main(String args[]){

    int size = Integer.parseInt(args[0]);
    int[][] image = new int[size][size];
    for(int i = 0; i < size; i++){
      for(int j = 0; j < size; j++){
        image[i][j] = j;
      }
    }

    printMatrix(image);

    int[][] output = new int[size][size];

    for(int i = 0; i < size; i++){
      for(int j = 0; j < size; j++){
        int col = size - i - 1;
        output[j][col] = image[i][j];
      }
    }

    printMatrix(output);
  } // end main

  static void printMatrix(int[][] m){
    System.out.print("\n");

    for(int i = 0; i < m.length; i++){
      for(int j = 0; j < m[i].length; j++){
        System.out.print(m[i][j] + " ");
      }
      System.out.print("\n");

    }

  }

}
