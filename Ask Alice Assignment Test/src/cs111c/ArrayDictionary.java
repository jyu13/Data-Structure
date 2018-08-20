package cs111c;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
   A class that implements the ADT dictionary by using a resizable array.
   The dictionary is unsorted and has distinct search keys.
  
   @author Frank M. Carrano
   @author Timothy M. Henry
   @version 4.0
*/
public class ArrayDictionary<K, V> implements DictionaryInterface<K, V>
{
	private Entry<K, V>[] dictionary; // Array of unsorted entries
	private int numberOfEntries;
   private boolean initialized = false;
	private final static int DEFAULT_CAPACITY = 25;
	private static final int MAX_CAPACITY = 10000;
	
	public ArrayDictionary()
	{
		this(DEFAULT_CAPACITY);        // Call next constructor
	} // end default constructor
	
	public ArrayDictionary(int initialCapacity)
	{
      checkCapacity(initialCapacity);

		// The cast is safe because the new array contains null entries
      @SuppressWarnings("unchecked")
      Entry<K, V>[] tempDictionary = (Entry<K, V>[])new Entry[initialCapacity];
      dictionary = tempDictionary;
		numberOfEntries = 0;
      initialized = true;
	} // end constructor

	public V add(K key, V value)
	{
	   checkInitialization();
	   if ((key == null) || (value == null))
	      throw new IllegalArgumentException("Cannot add null to a dictionary.");
	   else
	   {
	      V result = null;
	      int keyIndex = locateIndex(key);
	      if (keyIndex < numberOfEntries)
	      {
	         // Key found, return and replace entry's value
	         result = dictionary[keyIndex].getValue(); // Get old value
	         dictionary[keyIndex].setValue(value); 		// Replace value
	      }
	      else // Key not found; add new entry to dictionary
	      {
	         // Add at end of array
	         dictionary[numberOfEntries] = new Entry<>(key, value);
	         numberOfEntries++;
	         ensureCapacity(); // Ensure enough room for next add
	      } // end if
	      return result;
	   } // end if
	} // end add

	// Returns the array index of the entry that contains key, or
	// returns numberOfEntries if no such entry exists.
	private int locateIndex(K key)
	{
	   // Sequential search
	   int index = 0;
	   while ( (index < numberOfEntries) && !key.equals(dictionary[index].getKey()) )
	      index++;
	   return index;
	} // end locateIndex
	   

	 public V remove(K key)
	 {
	    checkInitialization();
	    V result = null;
	    int keyIndex = locateIndex(key);
	    if (keyIndex < numberOfEntries)
	    {
	       // Key found; remove entry and return its value
	       result = dictionary[keyIndex].getValue();
	       dictionary[keyIndex] = dictionary[numberOfEntries - 1];
	       dictionary[numberOfEntries - 1] = null;
	       numberOfEntries--;
	    } // end if
	    // Else result is null
	    return result;
	 } // end remove
	   

	   public V getValue(K key)
	   {
		   
	   }

	   public boolean contains(K key)
	   {
		   return 
		   
	   }
	   

	   public Iterator<K> getKeyIterator()
	   {
		   return new KeyIterator();
	   }
	   private class KeyIterator implements Iterator<K>
	   {
		   
	   }
	   

	   public Iterator<V> getValueIterator()
	   {
		   return new ValueIterator();
		   
	   }
	   private class ValueIterator implements Iterator<V>
	   {
		   
	   }
	   

	   public boolean isEmpty()
	   {
		   return numberOfEntries == 0;
	   }
	   

	   public int getSize()
	   {
		   return numberOfEntries;
	   }
	   

	   public void clear()
	   {
		  numberOfEntries = 0; 
	   }
	   
	   private void ensureCapacity()
	   {
	      int capacity = dictionary.length - 1;
	      if (numberOfEntries >= capacity)
	      {
	         int newCapacity = 2 * capacity;
	         checkCapacity(newCapacity); // Is capacity too big?
	         dictionary = Arrays.copyOf(dictionary, newCapacity + 1);
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
	private class Entry<S, T> 
	{
		private S key;
		private T value;
		
		private Entry(S searchKey, T dataValue)
		{
         key = searchKey;
         value = dataValue;
		} // end constructor
		
		private S getKey()
		{
			return key;
		} // end getKey
		
		private T getValue()
		{
			return value;
		} // end getValue
		
		private void setValue(T dataValue)
		{
		 	value = dataValue;
		} // end setValue
	} // end Entry
} // end ArrayDictionary
