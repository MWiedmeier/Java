import java.util.*;
import java.io.*;

public class CH2_Q7
{

  public static void main(String args[])
  {
    LL ll = new LL();
    ll.add(3);
    ll.add(1);
    ll.add(2);
    ll.add(3);

    String palindrome = ll.isPalindrome() ? ("List is a palindrome")
                                          : ("List is not a palindrome");

    System.out.println(palindrome);
  }

}
