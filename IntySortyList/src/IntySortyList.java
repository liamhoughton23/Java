// Liam Houghton x500 hough084

//  INTY SORTY LIST. A linear singly linked list of INTs which can be sorted by
//  Selection Sort. Do not change any part of this file, except for the body of
//  the SORT method.

class IntySortyList
{

//  NODE. A node in a singly linked linear list of INT's.

  private class Node
  {
    private int  key;   //  The key at this NODE, duh.
    private Node next;  //  The next NODE in the list, or NULL.

//  Constructor. Initialize a new NODE with KEY and NEXT.

    private Node(int key, Node next)
    {
      this.key  = key;
      this.next = next;
    }
  }

  private Node first;  //  Head node.

//  Constructor. Let FIRST be a singly linked linear list of the INT's in KEYS,
//  with a head node.

  public IntySortyList(int ... keys)
  {
     first = new Node(0, null);
     Node last = first;
     for (int key: keys)
     {
       last.next = new Node(key, null);
       last = last.next;
     }
  }

//  SORT. Sort FIRST using Selection Sort.

  public void sort()
  {
	  Node sorted = new Node(0, null);
	  while(first.next != null) {
		  
		  int number = biggestAndDelete();
		  sorted.next = new Node(number, sorted.next);
	  }	  
	  first = sorted;
  }

//  TO STRING. Convert FIRST to a STRING, for printing.

  public String toString()
  {
    StringBuilder builder = new StringBuilder();
    builder.append('[');
    Node temp = first.next;
    if (temp != null)
    {
      builder.append(temp.key);
      temp = temp.next;
      while (temp != null)
      {
        builder.append(',');
        builder.append(' ');
        builder.append(temp.key);
        temp = temp.next;
      }
    }
    builder.append(']');
    return builder.toString();
  }
  
  
  
  private int biggestAndDelete() {
	  int numBiggest = first.next.key;
	  Node biggest = first.next; 
	  Node prevBiggest = first;
	  Node number = first.next;
	  Node prevNumber = first;
	  while(number != null) {
		  if (number.key >= numBiggest) {
			  numBiggest = number.key;
			  biggest = number;
			  prevBiggest = prevNumber;
			  prevNumber = number;
			  number = number.next;	
			  
			  
		  }
		  else {
			  prevNumber = number;
			  number = number.next;			  
		  }
	  }
	  prevBiggest.next = biggest.next;
	  return numBiggest;
	  
  } 
}

/*
Output:
		  []
		  []
		  [1]
		  [1]
		  [2, 1]
		  [1, 2]
		  [5, 2, 1, 3, 4]
		  [1, 2, 3, 4, 5]
		  [3, 2, 1, 2, 3]
		  [1, 2, 2, 3, 3]
		  [2, -1, 0, -2, 1]
		  [-2, -1, 0, 1, 2]
*/