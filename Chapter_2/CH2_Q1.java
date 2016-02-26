import java.util.*;
import java.io.*;

public class CH2_Q1
{

  public static void main(String[] args){

    LL ll = new LL();
    Random rand = new Random();
    for(int i = 0; i < 20; i++){
      ll.add(rand.nextInt(10));
    }

    ll.print();
    ll.removeDuplicates();
    ll.print();
  }

}
