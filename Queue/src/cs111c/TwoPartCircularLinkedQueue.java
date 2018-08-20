package cs111c;


/**A class TwoPartCircularLinkedQueue<T> implements QueueInterface<T>
 * demonstrate how entries are stored in a chain of linked nodes with enqueue and dequeue
 * @author Jiadong Yu
 * @version 1.1
 * @since 10/04/2016
 * @param <T>
 */
public final class TwoPartCircularLinkedQueue<T> implements QueueInterface<T>
{
   private Node queueNode; // References first node in queue
   private Node freeNode;  // References node after back of queue
   
   public TwoPartCircularLinkedQueue()
   {
      freeNode = new Node(null, null);
      freeNode.setNextNode(freeNode);
      queueNode = freeNode;
   } // end default constructor

   public void enqueue(T newEntry)
   {
      freeNode.setData(newEntry);

      if (isChainFull())
      {
         // Allocate a new node and insert it after the node that
         // freeNode references
         Node newNode = new Node(null, freeNode.getNextNode());
         freeNode.setNextNode(newNode);
      } // end if

      freeNode = freeNode.getNextNode();
   } // end enqueue
   
   public T getFront() throws EmptyQueueException
   {
      if (isEmpty())
         throw new EmptyQueueException();
      else
         return queueNode.getData();
   } // end getFront
   
   public T dequeue() throws EmptyQueueException
   {
      if(isEmpty())
    	  throw new EmptyQueueException();
      else
      {
    	  T front = getFront();  // Might throw EmptyQueueException
          assert !isEmpty();
          queueNode.setData(null);
          queueNode = queueNode.getNextNode();
          return front;
      }
   } // end dequeue
   
   public boolean isEmpty()
   {
      return queueNode == freeNode;
   } // end isEmpty

   private boolean isChainFull()
   {
      return queueNode == freeNode.getNextNode();
   } // end isChainFull
   
   public void clear() throws EmptyQueueException
   {
	   while(!isEmpty())
		   dequeue();
   }// end clear
   
   public void splice(QueueInterface<T> q) throws EmptyQueueException
   {
	   if(q.isEmpty())
		   throw new EmptyQueueException();
	   else
	   {
	       while(!q.isEmpty())
		         this.enqueue(q.dequeue());
	   }
   }//end splice
   
   public void splice2(TwoPartCircularLinkedQueue<T> q) throws EmptyQueueException
   {
	   if(q.isEmpty())
		   throw new EmptyQueueException();
	   freeNode.setData(q.queueNode.getData());
	   freeNode.setNextNode(q.queueNode.getNextNode());
	   freeNode=q.freeNode;
   }//end splice2
   
	private class Node
	{
		private T    data;  // Queue entry
		private Node next;  // Link to next node
      
		private Node(T dataPortion)
		{
			data = dataPortion;
			next = null;
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
} // end TwoPartCircularLinkedQueue
