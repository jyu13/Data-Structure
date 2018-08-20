package cs111c;

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.NoSuchElementException;

/**A class ArrayStack<T> implements StackInterface<T>
 * demonstrate how entries are stored in an array with stack
 * @author Jiadong Yu
 * @version 1.1
 * @since 09/11/2016
 * @param <T>
 */
public class ArrayStack<T> implements StackInterface<T>
{

	private T[] stack;    // Array of stack entries
	private int topIndex; // Index of top entry
	private boolean initialized = false;
	private static final int DEFAULT_CAPACITY = 50;
	private static final int MAX_CAPACITY = 10000;
	
	public void doubleUp()
	{
		
	}

	public ArrayStack()
	{  
		this(DEFAULT_CAPACITY);
	} // end default constructor


	public ArrayStack(int initialCapacity)

	{
		checkCapacity(initialCapacity); 
		// The cast is safe because the new array contains null entries  
		@SuppressWarnings("unchecked")
		T[] tempStack = (T[])new Object[initialCapacity]; 
		stack = tempStack;	
		topIndex = -1;  
		initialized = true;
	} // end constructor


	public void push(T newEntry)
	{
		checkInitialization();
		ensureCapacity();

		stack[topIndex+1]=newEntry;
		topIndex++;
	}//end push


	public T pop()
	{
		checkInitialization();
		ensureCapacity();
		if (isEmpty())
			throw new EmptyStackException();
		else
		{
			T pop = stack[topIndex];
		    stack[topIndex]= null;
		    topIndex--;
		    return pop;
		}
	}//end pop


	public T peek()
	{
		checkInitialization();
		if (isEmpty())
			throw new EmptyStackException();
		else
			return stack[topIndex];
	}//end peek


	public boolean isEmpty()
	{
		return topIndex < 0;
	}// end isEmpty


	public void clear()
	{
		while(!isEmpty())
			pop();
	}//end clear
	
	private void ensureCapacity()
	{
		if(topIndex==stack.length-1)
		{
			int newLength = stack.length*2;
			checkCapacity(newLength);
			stack = Arrays.copyOf(stack,newLength);
		}			
	}//end ensureCapacity
	
	public T peek2()
	{
		if (topIndex>=1)
			return stack[topIndex-1];
		else
            throw new NoSuchElementException();
	}//end peek2
	
	public String toString()
	{
		String a="";
		for (int i =0; i<topIndex;i++)
		{
			a = a+stack[i]+"";
		}
	 	return a;
	}//end toString
	
	public void remove(int n)
	{
        int i=0;
		while (i<n&& topIndex!=0)
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

} // end ArrayStack
