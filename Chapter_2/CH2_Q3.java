import java.util.*;
import java.io.*;

public class CH2_Q3
{
  public static void main(String args[])
  {
    LL ll = new LL();
    for(int i = 0; i < 15; i++)
    {
      ll.add(i);
    }

    ll.print();
    ll.removeWithAccess(15);
    ll.print();
  }
}
