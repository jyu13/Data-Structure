package cs111c;

import java.util.EmptyStackException;
import java.util.NoSuchElementException;

/**A class LinkedStack<T> implements StackInterface<T>
 * demonstrate how entries are stored in a chain of linked nodes and stack
 * @author Jiadong Yu
 * @version 1.1
 * @since 09/11/2016
 * @param <T>
 */

public class LinkedStack<T> implements StackInterface<T>
{
	private Node topNode; // References the first node in the chain
    private int numberOfEntries;
    public LinkedStack()
    {
       topNode = null;
       numberOfEntries=0;
    } // end default constructor
  
	public void push(T newEntry)
	{
		topNode = new Node (newEntry, topNode);
		numberOfEntries++;
	}//end push
	
	public T pop()
	{
		if (topNode != null)
		{
			T pop = topNode.getData();;
			topNode=topNode.getNextNode();
			numberOfEntries--;
			return pop;
		}
		else
			throw new EmptyStackException();
	}//end pop

	public T peek()
	{
		if (isEmpty())
		{
			throw new EmptyStackException();
		}
		else
			return topNode.getData();
	}//end peek

	public boolean isEmpty()
	{
		return topNode==null;
	}//end isEmpty

	public void clear()
	{
		topNode=null;
		numberOfEntries=0;
	}//end clear
	
	public T peek2()
	{
		if (topNode.getNextNode()!=null)
		{
			return topNode.getNextNode().getData();
		}
		else 
            throw new NoSuchElementException();
		
	}//end peek2
	
	public String toString()
	{
		String a="";
		Node tempNode=topNode;
		int i = 0;
		while(i<numberOfEntries&&tempNode!=null)
		{
			a = a + tempNode.getData() + "";
			tempNode=tempNode.getNextNode();
			i++;

		}
		return a;
	}//end toString
	
	public void remove(int n)
	{
		int i=0;
		while( i<n && numberOfEntries!=0)
		{
			pop();
			i++;
		}
	}//end remove
	
	public void pushAll(T[] a)
	{
		for(int i=0; i< a.length;i++)
		{
			push(a[i]);
		}
	}//end pushAll

	public void doubleUp()
	{
		Node current=topNode;
		while(current!=null)
		{
			Node newNode= new Node(current.getData(),current.next);
			current.setNextNode(newNode);
			current=newNode.getNextNode();
		}
		
	}
	
	
	private class Node
	{
      private T    data; // Entry in stack
      private Node next; // Link to next node
      
      private Node(T dataPortion)
      {
         this(dataPortion, null);
      } // end constructor
      
      private Node(T dataPortion, Node linkPortion)
      {
         data = dataPortion;
         next = linkPortion;
      } // end constructor
      
      private T getData()
      {
         return data;
      } // end getData
      
      private void setData(T newData)
      {
         data = newData;
      } // end setData
      
      private Node getNextNode()
      {
         return next;
      } // end getNextNode
      
      private void setNextNode(Node nextNode)
      {
         next = nextNode;
      } // end setNextNode
	} // end Node
} // end LinkedStack
