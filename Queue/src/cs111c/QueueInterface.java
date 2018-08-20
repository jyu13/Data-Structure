package cs111c;


/**A interface QueueInterface<T> 
 * demonstrate the methods that need to be used in queue 
 * @author Jiadong Yu
 * @version 1.1
 * @since 10/04/2016
 * @param <T>
 */
public interface QueueInterface<T>
{
  /** Adds a new entry to the back of this queue.
      @param newEntry  An object to be added. */
  public void enqueue(T newEntry);
  
  /** Removes and returns the entry at the front of this queue.
      @return  The object at the front of the queue. 
      @throws  EmptyQueueException if the queue is empty before the operation. */
  public T dequeue() throws EmptyQueueException;
  
  /**  Retrieves the entry at the front of this queue.
      @return  The object at the front of the queue.
      @throws  EmptyQueueException if the queue is empty. */
  public T getFront() throws EmptyQueueException;
  
  /** Detects whether this queue is empty.
      @return  True if the queue is empty, or false otherwise. */
  public boolean isEmpty();
  
  /** Removes all entries from this queue. 
      @throws EmptyQueueException */
  public void clear() throws EmptyQueueException;
  
  /** splice the parameter queue onto the end of the receiving queue
      @param q
      @throws EmptyQueueException */
  public void splice(QueueInterface<T> q) throws EmptyQueueException;

  
} // end QueueInterface