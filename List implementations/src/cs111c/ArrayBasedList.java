package cs111c;

import java.util.Arrays;
/**A class ArrayBasedList<T> implements ListInterface<T>
 * demonstrate how list entries are stored in an arraylist with add and remove
 * @author Jiadong Yu
 * @version 1.1
 * @since 10/11/2016
 * @param <T>
 */
public class ArrayBasedList<T> implements ListInterface<T>
{
	private T[] list;   // Array of list entries; ignore list[0]
	private int numberOfEntries;
   private boolean initialized = false;
	private static final int DEFAULT_CAPACITY = 3;
	private static final int MAX_CAPACITY = 10000000;
   
	public ArrayBasedList()
	{
		this(DEFAULT_CAPACITY);
	} // end default constructor
   
	public ArrayBasedList(int initialCapacity)
	{
      // Is initialCapacity too small?
      if (initialCapacity < DEFAULT_CAPACITY)
         initialCapacity = DEFAULT_CAPACITY;
      else // Is initialCapacity too big?
         checkCapacity(initialCapacity);
      
      // The cast is safe because the new array contains null entries
      @SuppressWarnings("unchecked")
      T[] tempList = (T[])new Object[initialCapacity + 1];
      list = tempList;
      numberOfEntries = 0;
      initialized = true;
	} // end constructor
   
	public void add(T newEntry)
	{
       checkInitialization();
       list[numberOfEntries + 1] = newEntry;
       numberOfEntries++;
       ensureCapacity();
//     add(numberOfEntries + 1, newEntry);  // ALTERNATE CODE
	} // end add

	public void add(int newPosition, T newEntry)
	{
	   checkInitialization();
	   if ((newPosition >= 1) && (newPosition <= numberOfEntries + 1))
	   {
	      if (newPosition <= numberOfEntries)
	         makeRoom(newPosition);
	      list[newPosition] = newEntry;
	      numberOfEntries++;
	      ensureCapacity(); // Ensure enough room for next add
	   }
	   else
	      throw new IndexOutOfBoundsException(
	                "Given position of add's new entry is out of bounds.");
	} // end add
	private void makeRoom(int newPosition)
	{
	   int newIndex = newPosition;
	   int lastIndex = numberOfEntries;
	   for (int index = lastIndex; index >= newIndex; index--)
	      list[index + 1] = list[index];
	}  // end makeRoom

	public T remove(int givenPosition)
	{
	   checkInitialization();
	   if ((givenPosition >= 1) && (givenPosition <= numberOfEntries))
	   {
	      assert !isEmpty();
	      T result = list[givenPosition]; // Get entry to be removed
	      // Move subsequent entries towards entry to be removed,
	      // unless it is last in list
	      if (givenPosition < numberOfEntries)
	         removeGap(givenPosition);
	      numberOfEntries--;
	      return result;
	   }
	   else
	      throw new IndexOutOfBoundsException(
	                "Illegal position given to remove operation.");
	} // end remove
	
	private void removeGap(int givenPosition)
	{
		assert (givenPosition>=1)&&(givenPosition<numberOfEntries);
		
		int removedIndex=givenPosition;
		int lastIndex=numberOfEntries;
		for(int index=removedIndex;index<lastIndex;index++)
			list[index]=list[index+1];
	}

	public void clear()
	{ /* < Implementation deferred > */
	} // end clear

	public T replace(int givenPosition, T newEntry)
	{
	   checkInitialization();
	   if ((givenPosition >= 1) && (givenPosition <= numberOfEntries))
	   {
	      assert !isEmpty();
	      T originalEntry = list[givenPosition];
	      list[givenPosition] = newEntry;
	      return originalEntry;
	   }
	   else
	      throw new IndexOutOfBoundsException(
	                "Illegal position given to replace operation.");
	} // end replace
	public T getEntry(int givenPosition)
	{
	   checkInitialization();
	   if ((givenPosition >= 1) && (givenPosition <= numberOfEntries))
	   {
	      assert !isEmpty();
	      return list[givenPosition];
	   }
	   else
	      throw new IndexOutOfBoundsException(
	                "Illegal position given to getEntry operation.");
	} // end getEntry

   public T[] toArray()
   {
		checkInitialization();
      
      // The cast is safe because the new array contains null entries
      @SuppressWarnings("unchecked")
      T[] result = (T[])new Object[numberOfEntries]; // Unchecked cast
      for (int index = 0; index < numberOfEntries; index++)
      {
         result[index] = list[index + 1];
      } // end for
      
      return result;
   } // end toArray
   
   public boolean contains(T anEntry)
   {
      checkInitialization();
      boolean found = false;
      int index = 1;
      while (!found && (index <= numberOfEntries))
      {
         if (anEntry.equals(list[index]))
            found = true;
         index++;
      } // end while
      return found;
   } // end contains

	public int getLength()
	{
		return numberOfEntries;
	} // end getLength

	public boolean isEmpty()
	{
		return numberOfEntries == 0; // Or getLength() == 0
	} // end isEmpty

   // Doubles the capacity of the array list if it is full.
   // Precondition: checkInitialization has been called.
   private void ensureCapacity()
   {
      int capacity = list.length - 1;
      if (numberOfEntries >= capacity)
      {
         int newCapacity = 2 * capacity;
         checkCapacity(newCapacity); // Is capacity too big?
         list = Arrays.copyOf(list, newCapacity + 1);
      } // end if
   } // end ensureCapacity
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
   }//end checkInitiallization
   
}//end Alist()
