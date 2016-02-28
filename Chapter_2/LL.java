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

  public void add(Node node)
  {
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
    while(currNode != null)
    {
      if(ht.containsKey(currNode.getData()))
      {
        previous.setNext(currNode.getNext());
      }
      else
      {
        ht.put(currNode.getData(), true);
        previous = currNode;
      }
      currNode = currNode.getNext();
    }
  }

  public void getKthNode(int kth)
  {
    Node currNode = head;
    Node runner = head;

    int size = 1;

    while(runner.hasNext())
    {
      runner = runner.getNext();
      size++;
    }

    int goTo = size - kth;
    if(goTo < 0 || kth <= 0)
    {
      // bad case
      System.out.println("Can't get the " + kth + " to last element.");
      return;
    }
    for(int i = 0; i < goTo; i++)
    {
      currNode = currNode.getNext();
    }

    System.out.println("The " + kth + " to last element is: " + currNode.getData());
  }

  public void removeWithAccess(int k)
  {
      Node currNode = head;

      for(int i = 1; i < k; i++)
      {
        currNode = currNode.getNext();
        if(currNode == null)
        {
          System.out.println("Invalid node index");
          return;
        }
      }

      if(!currNode.hasNext())
      {
        currNode = null;
        System.out.println("This is the last element");
      }
      else
      {
        currNode.setData(currNode.getNext().getData());
        currNode.setNext(currNode.getNext().getNext());
      }
  }

  public LL partitionX(int x)
  {
    System.out.println("Partioning around value: " + x);
    LL lowList = new LL();
    LL highList = new LL();

    Node currNode = head;
    while(currNode != null)
    {
      if(currNode.getData() >= x)
      {
        highList.add(currNode.getData());
      }
      else
      {
        lowList.add(currNode.getData());
      }

      currNode = currNode.getNext();
    }

    Node lastLow = lowList.getHead();
    Node highHead = highList.getHead();

    if(lastLow == null) return highList;
    else if(highHead == null) return lowList;
    else
    {
      while(lastLow.hasNext())
      {
        lastLow = lastLow.getNext();
      }

      lastLow.setNext(highHead);
    }

    return lowList;
  }

  public static LL addLists(LL list1, LL list2)
  {

    LL returnList = new LL();
    Node currL1 = list1.getHead();
    Node currL2 = list2.getHead();
    int sum;
    int carry;
    boolean overflow = false;

    if(currL1 == null) return list2;
    else if (currL2 == null) return list1;
    else
    {
      while(currL1 != null || currL2 != null)
      {
        if(currL1 == null) sum = currL2.getData();
        else if (currL2 == null) sum = currL1.getData();
        else sum = currL1.getData() + currL2.getData();

        if(overflow) sum++;

        if(sum > 9)
        {
          sum = sum - 10;
          overflow = true;
        }
        else{
          overflow = false;
        }

        returnList.add(sum);

        if(currL1 != null) currL1 = currL1.getNext();
        if(currL2 != null) currL2 = currL2.getNext();
      }

      if(overflow)
      {
        returnList.add(1);
      }
    }

    return returnList;

  }

  public LL createCircularList()
  {
    LL returnList = new LL();
    Node n1 = new Node(1);
    Node n2 = new Node(2);
    Node n3 = new Node(3);
    returnList.add(n1);
    returnList.add(n2);
    returnList.add(n3);
    returnList.add(n2);
    return returnList;

  }

  public void isCircular(LL list)
  {
    HashMap<Node,Integer> visited = new HashMap<Node,Integer>();
    Node currNode = list.getHead();
    int index = 0;
    while(currNode != null)
    {
      if(visited.containsKey(currNode))
      {
        // Repeated Node
        System.out.println("Beginning of the loop is: " + currNode.getData() + ", at index: " + visited.get(currNode));
        break;
      }
      else
      {
        visited.put(currNode, index);
      }

      index++;
      currNode = currNode.getNext();
    }
  }

  public void getMiddleNode(int mid)
  {
    Node currNode = head;
    Node runner = head;

    while(runner != null && runner.hasNext()){

      for(int i = 0; i < 2; i++)
      {
        runner = runner.getNext();
        if(runner == null) break;
      }

      currNode = currNode.getNext();

    }

    System.out.println("The middle element is: " + currNode.getData());
  }

  public boolean isPalindrome()
  {

    Node currNode = head;
    Stack<Integer> values = new Stack<Integer>();

    System.out.println("Size: " + size);
    boolean leftover = size % 2 == 1? true:false;
    int mid = this.size/2;

    if(size == 1) return true;

    for(int i = 0; i < mid; i++)
    {
      values.push(currNode.getData());
      System.out.println("pushing: " + currNode.getData());
      currNode = currNode.getNext();
    }

    if(leftover)
    {
      currNode = currNode.getNext();
      mid++;
    }

    for(int i = mid; i < size; i++)
    {
      System.out.println("popping: " + currNode.getData());

      if(!(currNode.getData() == values.pop()))
      {
        return false;
      }

      currNode = currNode.getNext();
    }

    return true;

  }

  public void print()
  {
    Node currNode = head;
    if(currNode != null)
    {
      while(currNode != null)
      {
        System.out.print(currNode.getData() + " ");
        currNode = currNode.getNext();
      }
      System.out.print("\n");
    }
    else
    {
      System.out.println("List is empty...");
    }
  }

  public Node getHead()
  {
    return this.head;
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
    public void setData(int data)
    {
      this.data = data;
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
