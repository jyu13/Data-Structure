package cs111c;

import java.util.Iterator;
import java.util.NoSuchElementException;


/**LinkedListWithIterator<T> extends LinkedChainList<T> implements ListWithIteratorInterface<T>
 * demonstrate how a Iterator will help with the Linked List 
 * @author Jiadong Yu
 * @version 1.1
 * @since 10/18/2016
 * @param <T>
 */
public class LinkedListWithIterator<T> extends LinkedChainList<T> implements ListWithIteratorInterface<T>
{
   private Node firstNode;
   private int  numberOfEntries;;

   public LinkedListWithIterator()
   {
       initializeDataFields();
      
   } // end default constructor

   
   public Iterator<T> iterator()
   {
	   return new IteratorForLinkedList();
   } // end iterator

	public Iterator<T> getIterator()
	{
	   return iterator();
	} // end getIterator
   
	private class IteratorForLinkedList implements Iterator<T>
	{
      private Node nextNode;     
      
		private IteratorForLinkedList()
		{
			nextNode = firstNode;
		} // end default constructor
	     
		public T next()
		{
			if (hasNext())
			{
				
				Node returnNode = nextNode;        // Get next node
				nextNode = nextNode.getNextNode(); // Advance iterator
				
				return returnNode.getData();       // Return next entry in iteration
			}
			else
				throw new NoSuchElementException("Illegal call to next(); " +
		                                       "iterator is after end of list.");
		} // end next
      
		public boolean hasNext()
		{
			return nextNode != null;
		} // end hasNext      
      
		public void remove()
		{
		    		    
				throw new UnsupportedOperationException("remove() is not " +
		                                           "supported by this iterator");
		} // end remove
	} // end IteratorForLinkedList
}// end LinkedListWithIterator