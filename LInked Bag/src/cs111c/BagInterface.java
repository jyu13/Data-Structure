package cs111c;


/**Interface BagInterface<T>
 * demonstrate the methods need to be used in class LinkedBag
 * @author Jiadong Yu
 * @version 1.1
 * @since 09/5/2016
 * @param <T>
 */
public interface BagInterface<T> 
{
		/** Gets the current number of entries in this bag.
			 @return  The integer number of entries currently in the bag. */
		public int getCurrentSize();
		
		/** Sees whether this bag is empty.
			 @return  True if the bag is empty, or false if not. */
		public boolean isEmpty();
		
		/** Adds a new entry to this bag.
		    @param newEntry  The object to be added as a new entry.
		    @return  True if the addition is successful, or false if not. */
		public boolean add(T newEntry);

		/** Removes one unspecified entry from this bag, if possible.
	       @return  Either the removed entry, if the removal.
	                was successful, or null. */
		public T remove();
	   
		/** Removes one occurrence of a given entry from this bag.
	       @param anEntry  The entry to be removed.
	       @return  True if the removal was successful, or false if not. */
	   public boolean remove(T anEntry);
		
	   /** Counts the number of times a given entry appears in this bag.
		 @param anEntry  The entry to be counted.
		 @return  The number of times anEntry appears in the bag. */
	   public int getFrequencyOf(T anEntry);
	   
		/** Removes all entries from this bag. */
		public void clear();		
		
		/** Tests whether this bag contains a given entry.
			 @param anEntry  The entry to locate.
			 @return  True if the bag contains anEntry, or false if not. */
		public boolean contains(T anEntry);
	   
		/** Retrieves all entries that are in this bag.
			 @return  A newly allocated array of all the entries in the bag.
	                Note: If the bag is empty, the returned array is empty. */
		public T[] toArray();
		
		/** Test if two bags contain the same entry
		 * @param other The entries located in the second bag
		 * @return true if the two bag contain the same entry, or false if not*/

		public boolean equals(BagInterface<T> other);

		/** Test if a bag contains the same entry
		 * @return true if there are same entries, or false if not*/
		public boolean hasDuplicateEntries();
} // end BagInterface


