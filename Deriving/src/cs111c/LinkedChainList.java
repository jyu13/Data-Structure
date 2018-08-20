package cs111c;

/**A class LinkedChainList<T> extends LinkedChainBase<T> implements ListInterface<T>
 * demonstrate how a child class developed from a parent class, for example the new methods
 * @author Jiadong Yu
 * @version 1.1
 * @since 10/18/2016
 * @param <T>
 */
public class LinkedChainList<T> extends LinkedChainBase<T> implements ListInterface<T> {

    public LinkedChainList() {
        super();
    }

    // Here is an example of how LinkedChainList's methods can be implemented
    // using methods inherited from LinkedChainBase
    public T remove(int givenPosition) {
        // Make sure we have a good index
        if (givenPosition < 1 || givenPosition > getLength()) {
            throw new IndexOutOfBoundsException("index: " + givenPosition);
        }

        if (givenPosition == 1) {
            return removeFirstNode();
        } else {
            Node nodeBefore = getNodeAt(givenPosition - 1); // The -1 is the fix made in class
            return removeAfterNode(nodeBefore);
        }
    }

   
    public void add(T newEntry) {

    	Node newNode = new Node(newEntry);
    	addFirstNode(newNode);
    	
    }

    
    public void add(int newPosition, T newEntry) {

    	Node newNode = new Node(newEntry);
    	Node nodeBefore = getNodeAt(newPosition - 1);
    	addAfterNode(nodeBefore, newNode);
    }

    
    public T replace(int givenPosition, T newEntry) {
        T replaceEntry = remove(givenPosition);
        add(givenPosition, newEntry);
    	return replaceEntry;
    }

    
    public T getEntry(int givenPosition) {
        
    	if (givenPosition < 1 || givenPosition > getLength()) {
            throw new IndexOutOfBoundsException("index: " + givenPosition);
        }
    	Node newNode = getNodeAt(givenPosition);
        T getEntry = newNode.getData();
    	return getEntry;
    }

    
    public boolean contains(T anEntry) {
       
        Node current = getFirstNode();
        while(!isEmpty() && current != null) {
        	
        	if(anEntry == current.getData())
        		return true;
        }
        
    	    return false;
    }
}

