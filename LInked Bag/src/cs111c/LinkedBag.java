package cs111c;


/**A class LinkedBag<T> implements BagInterface<T>
 * demonstrate how entries are stored in a chain of linked nodes and
 * show how this nodes are added, removed, etc.
 * @author Jiadong Yu
 * @version 1.1
 * @since 09/5/2016
 * @param <T>
 */
public final class LinkedBag<T> implements BagInterface<T>
{

	private Node firstNode;       // Reference to first node
	private int numberOfEntries;
	public LinkedBag()
    {	
		firstNode = null;
		numberOfEntries = 0;
    } // end default constructor

    /** Adds a new entry to this bag.
      @param newEntry  The object to be added as a new entry.
      @return  True. */
	
	public boolean add(T newEntry) // OutOfMemoryError possible
    {
        // Add to beginning of chain:	
		Node newNode = new Node(newEntry);	
		newNode.next = firstNode;  // Make new node reference rest of chain
 
		// (firstNode is null if chain is empty)
		firstNode = newNode;       // New node is at beginning of chain	
		numberOfEntries++; 
	
		return true;
     } // end add

     /** Retrieves all entries that are in this bag.
        @return  A newly allocated array of all the entries in this bag. */

	public T[] toArray()
    {
        // The cast is safe because the new array contains null entries.  
		@SuppressWarnings("unchecked") 
		T[] result = (T[])new Object[numberOfEntries]; // Unchecked cast  
  
		int index = 0;
  
		Node currentNode = firstNode;
  
		while ((index < numberOfEntries) && (currentNode != null))
        {     
			result[index] = currentNode.data;     
			index++;    
			currentNode = currentNode.next;
        } // end while
  
  
		return result;
        // Note: The body of this method could consist of one return statement,
        // if you call Arrays.copyOf
    } // end toArray

    /** Sees whether this bag is empty.
       @return  True if the bag is empty, or false if not. */

	public boolean isEmpty()
    { 	
		return numberOfEntries == 0;
    } // end isEmpty

    /** Gets the number of entries currently in this bag.
      @return  The integer number of entries currently in the bag. */

	public int getCurrentSize()
    {	
		return numberOfEntries;
    } // end getCurrentSize

    /** Removes one unspecified entry from this bag, if possible.
       @return  Either the removed entry, if the removal
            was successful, or null. */

	public T remove()
    {
		T result = null;
		if (firstNode != null)
		{
			result = firstNode.data;
			firstNode = firstNode.next;
			numberOfEntries--;			
		}//end if
 
		return result; 
    } // end remove

    /** Removes one occurrence of a given entry from this bag.
       @param anEntry  The entry to be removed.
       @return  True if the removal was successful, or false otherwise. */

	public boolean remove(T anEntry)
    {
	
		boolean result = false;	
		Node nodeN = getReferenceTo(anEntry);	
		if (nodeN != null)
	    {		
			nodeN.data = firstNode.data;		
			firstNode = firstNode.next;		
			numberOfEntries--;		
			result = true;
	    }
  
		return result; 
    } // end remove

    /** Removes all entries from this bag. */

	public void clear()
    { 
		firstNode=null;
		numberOfEntries =0;
    } // end clear

	/** Counts the number of times a given entry appears in this bag.
	 @param anEntry  The entry to be counted.
	 @return  The number of times anEntry appears in the bag. */
    public Node getReferenceTo(T anEntry)
    {	
    	boolean found=false;	
    	Node currentNode = firstNode;	
    	while(!found&&(currentNode != null))
	    {		
    		if (anEntry.equals(currentNode.data))			
    			found=true;		
    		else			
    			currentNode=currentNode.next;
	    }      
    	return currentNode;
    } // end getFrequencyOf

    /** Tests whether this bag contains a given entry.
	 @param anEntry  The entry to locate.
	 @return  True if the bag contains anEntry, or false otherwise. */

    public boolean contains(T anEntry)
    {	
    	boolean found = false;	
    	Node currentNode= firstNode;	
    	while(!found&&(currentNode !=null))	
    	{		
    		if (anEntry.equals(currentNode.data))			
    			found = true;		
    		else			
    			currentNode = currentNode.next;
    	}
    	return found;
    } // end contains
    
    /** Get how many times anEntry appear in a bag
	 @param anEntry  The entry to counted
	 @return  Times that anEntry appear in a bag */    
    
	public int getFrequencyOf(T anEntry)
	{
		int frequency = 0;
		int loopCounter = 0;
		Node currentNode = firstNode;
		
		while ((loopCounter < numberOfEntries)&& (currentNode !=null))
		{
			if (anEntry.equals(currentNode.data))
				frequency++;			
			loopCounter++;
			currentNode=currentNode.next;			
		}
		return frequency;		   
	}//end getFrequencyOf

    /** Tests whether this bag contains two or more the same entry.
	 @return  True if the bag contains two or more the same entry, or false otherwise. */
	
    public boolean hasDuplicateEntries()
    {
    	boolean duplicate = false;
    	Node current=firstNode;
    	int i=0;
    	while ( i< numberOfEntries && (current!=null))
    	{  

    		if (getFrequencyOf(current.data)>=2)
    			duplicate = true;
    		i++;
    		current = current.next;
    	}

    	return duplicate;
    }//end hasDuplicateEntries
    
    /** Tests whether two bags contains the same entries
	 @param other another bag
	 @return  True if the two bags contain same entries, or false otherwise. */ 
    
    public boolean equals(BagInterface<T> other)
    {
    	boolean equals = false;
    	Node current = firstNode;

    	if (getCurrentSize()==other.getCurrentSize())
    	{
        	int i=0;
    	    while ( i< numberOfEntries && (current!=null))
    	    {     		
    	    	if(getFrequencyOf(current.data)==other.getFrequencyOf(current.data))   			
    	    		equals = true;
    	    	else return false;
            
    	    	i++;
        	 	current = current.next;
    	    }
    	}
    	return equals;
    }// end equals
    
    /** Inner class Node have two constructors to construct current Node with data
     * and next Node with data */
    
    private class Node
    {    
    	private T    data; // Entry in bag    
    	private Node next; // Link to next node	
    	private Node(T dataPortion)
	    {		
    		this(dataPortion, null);	    
	    } // end constructor
		 
    	private Node(T dataPortion, Node nextNode)
	    {		
    		data = dataPortion;		
    		next = nextNode;	
	    } // end constructor
    } // end Node

} // end LinkedBag
 



