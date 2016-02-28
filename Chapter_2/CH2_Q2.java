import java.util.*;
import java.io.*;

public class CH2_Q2
{

  public static void main(String args[])
  {
    LL ll = new LL();
    for(int i = 0; i < 15; i++)
    {
      ll.add(i);
    }

    ll.getKthNode(0);
    ll.getKthNode(2);
    ll.getKthNode(15);
    ll.getKthNode(20);
  }

}
