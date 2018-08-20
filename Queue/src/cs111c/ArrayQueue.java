package cs111c;

/**A class ArrayQueue<T> implements QueueInterface<T>
 * demonstrate how entries are stored in an array with enqueue and dequeue
 * @author Jiadong Yu
 * @version 1.1
 * @since 10/04/2016
 * @param <T>
 */
public final class ArrayQueue<T> implements QueueInterface<T>
{
   private T[] queue; // Circular array of queue entries and one unused location
   private int frontIndex;
   private int backIndex;
   private boolean initialized = false;
   private static final int DEFAULT_CAPACITY = 50;
   private static final int MAX_CAPACITY = 10000;
   
   public ArrayQueue()
   {
      this(DEFAULT_CAPACITY);
   } // end default constructor
   
   public ArrayQueue(int initialCapacity)
   {
      checkCapacity(initialCapacity);
      
      // The cast is safe because the new array contains null entries
      @SuppressWarnings("unchecked")
      T[] tempQueue = (T[]) new Object[initialCapacity + 1];
      queue = tempQueue;
      frontIndex = 0;
      backIndex = initialCapacity;
      initialized = true;
   } // end constructor
   
   public void enqueue(T newEntry)
   {
      checkInitialization();
      ensureCapacity();
      backIndex = (backIndex + 1) % queue.length;
      queue[backIndex] = newEntry;
   } // end enqueue

   public T getFront() throws EmptyQueueException
   {
      checkInitialization();
      if (isEmpty())
         throw new EmptyQueueException();
      else
         return queue[frontIndex];
   } // end getFront
   
   public T dequeue() throws EmptyQueueException
   {
      checkInitialization();
      if (isEmpty())
         throw new EmptyQueueException();
      else
      {
         T front = queue[frontIndex];
         queue[frontIndex] = null;
         frontIndex = (frontIndex + 1) % queue.length;
         return front;
      } // end if
   } // end dequeue
   
   private void ensureCapacity()
   {
      if (frontIndex == ((backIndex + 2) % queue.length)) // if array is full,
      {                                                   // double size of array
         T[] oldQueue = queue;
         int oldSize = oldQueue.length;
         int newSize = 2 * oldSize;
         checkCapacity(newSize);

         // The cast is safe because the new array contains null entries
         @SuppressWarnings("unchecked")
         T[] tempQueue = (T[]) new Object[2 * oldSize];
         queue = tempQueue;
         for (int index = 0; index < oldSize - 1; index++)
         {
            queue[index] = oldQueue[frontIndex];
            frontIndex = (frontIndex + 1) % oldSize;
         } // end for
         
         frontIndex = 0;
         backIndex = oldSize - 2;
      } // end if
   } // end ensureCapacity
   
   public boolean isEmpty()
   {
     return frontIndex == ((backIndex + 1) % queue.length);
   } // end isEmpty
   
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
   
   public void splice2(ArrayQueue<T> q) throws EmptyQueueException
   {
	   if(q.isEmpty())
		   throw new EmptyQueueException();

	   for(int i=0; i < (q.backIndex-q.frontIndex+1);i++)
	   {
		   ensureCapacity();
		   backIndex = (backIndex + 1) % queue.length;
	       queue[backIndex] = q.queue[(q.frontIndex+i)%q.queue.length];
	   }

   }//end splice2
   
   private void checkCapacity(int capacity)
   {
        if (capacity > MAX_CAPACITY)
            throw new IllegalStateException("Attempt to create a bag whose capacity exceeds " +
                                         "allowed maximum of " + MAX_CAPACITY);
   } // end checkCapacity
   
   // Throws an exception if receiving object is not initialized.
   private void checkInitialization()
   {
        if (!initialized)
            throw new SecurityException ("Uninitialized object used " +
                                      "to call an ArrayBag method.");
   } // end checkInitialization
}