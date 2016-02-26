import java.io.*;
import java.util.*;

public class LL
{

  Node head;
  int size;

  public LL()
  {
    head = null;
    size = 0;
  }

  public void add(int data)
  {
    Node node = new Node(data);
    if(head == null)
    {
      head = node;
    }
    else
    {

      Node currNode = head;
      while(currNode.hasNext())
      {
        currNode = currNode.getNext();

      }

      currNode.setNext(node);
    }

    size++;
  }

  public boolean remove(int index)
  {
    Node currNode = head;

    if(index >= size || index < 0) return false;
    if(index == 0)
    {
      // Remove the head
      if(currNode.hasNext()) head = head.getNext();
      else
      {
        head = null;
      }
      size --;
      return true;
    }

    int i = 0;
    for(; i < index - 1; i++)
    {
      if(currNode.hasNext()) currNode = currNode.getNext();
    }
    if(i == size - 1)
    {
      // Remove the tail item
      currNode.setNext(null);
    }
    else
    {
      currNode.setNext(currNode.getNext().getNext());
    }

    size--;
    return true;
  }

  public void removeDuplicates()
  {
    // Bad code....
    // Node nextNode;
    // if(size <= 1 || currNode == null) return;
    // else
    // {
    //   HashMap<Integer,Node> map = new HashMap<Integer,Node>();
    //   map.put(currNode.getData(), currNode);
    //   while(currNode.hasNext())
    //   {
    //     nextNode = currNode.getNext();
    //     while(nextNode != null && map.containsKey(nextNode.getData())){
    //       // Skip till you find one thats not in there
    //       nextNode = nextNode.getNext();
    //       size--;
    //     }
    //     if(nextNode == null)
    //     {
    //       // rest were duplicates
    //       currNode.setNext(null);
    //     }
    //     else
    //     {
    //       map.put(nextNode.getData(), nextNode);
    //       currNode.setNext(nextNode);
    //       currNode = currNode.getNext();
    //     }
    //   }
    // }

    Node currNode = head;
    Hashtable<Integer,Boolean> ht = new Hashtable<Integer,Boolean>();
    Node previous = null;
    while(currNode != null){
      if(ht.containsKey(currNode.getData()))
      {
        previous.setNext(currNode.getNext());
      }else
      {
        ht.put(currNode.getData(), true);
        previous = currNode;
      }

      currNode = currNode.getNext();
    }

  }

  public void print()
  {
    System.out.println("\nPrinting List...");
    Node currNode = head;
    if(currNode != null)
    {
      while(currNode != null)
      {
        System.out.print(currNode.getData() + " ");
        currNode = currNode.getNext();
      }
    }
    else
    {
      System.out.println("List is empty...");
    }
  }

  public class Node
  {

    int data;
    Node next;

    public Node(int data)
    {
      this.data = data;
      this.next = null;
    }

    public int getData()
    {
      return data;
    }
    public void setNext(Node node)
    {
      this.next = node;
    }

    public boolean hasNext()
    {
      return next != null;
    }

    public Node getNext()
    {
      return next;
    }
  }

}
