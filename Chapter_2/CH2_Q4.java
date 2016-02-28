import java.util.*;
import java.io.*;

public class CH2_Q4
{
  public static void main(String args[])
  {
    Random rand = new Random();
    LL ll = new LL();
    for(int i = 0; i < 20; i++)
    {
      ll.add(rand.nextInt(50));
    }

    ll.print();
    ll = ll.partitionX(rand.nextInt(50));
    ll.print();
  }

}
