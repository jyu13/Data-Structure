package cs111c;

/**A interface StackInterface<T> 
 * demonstrate the methods that need to be used in both class LinkedStack and ArrayStack
 * @author Jiadong Yu
 * @version 1.1
 * @since 09/11/2016
 * @param <T>
 */
public interface StackInterface<T>
{

	/** Adds a new entry to the top of this stack.
    @param newEntry  An object to be added to the stack. */
	public void push(T newEntry);

	/** Removes and returns this stack's top entry.
    @return  The object at the top of the stack. 
    @throws  EmptyStackException if the stack is empty before the operation. */
	public T pop();

	/** Retrieves this stack's top entry.
    @return  The object at the top of the stack.
    @throws  EmptyStackException if the stack is empty. */
	public T peek();

	/** Detects whether this stack is empty.
    @return  True if the stack is empty. */
	public boolean isEmpty();

	/** Removes all entries from this stack. */
	public void clear();
	
	/** Retrieves this stack's second top entry.
	 @return The object at the second top of the stack
	 @throws NoSuchElementException if the stack is less than 2 elements */
	public T peek2();
	
	/** Push all elements into a string to display
	 * @return a string that shows all of the elements on the stack.*/
	public String toString();
	
	/** Remove the top n entries from the stack. Stop as soon as the stack is empty
	 * @param n,numbers of the entries need to be removed */
	public void remove(int n);
	
	/** Add each elements in the array to the stack
	 * @param a,the array that want to add */
	public void pushAll(T[] a);
	
	public void doubleUp();
	
} // end StackInterface

