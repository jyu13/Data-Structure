package cs111c;

import cs111c.SearchTreeInterface;
import cs111c.BinarySearchTree;
import java.util.Iterator;
/**
 A class that implements the ADT dictionary by using a binary search tree.
 The dictionary is sorted and has distinct search keys.
 
 @author Frank M. Carrano
 @author Timothy M. Henry
 @version 4.0
 */
public class Dictionary<K extends Comparable<? super K>, V> 
implements DictionaryInterface<K, V>
{
   private SearchTreeInterface<Entry<K, V>> bst;
   
   public Dictionary()
   {
      bst = new BinarySearchTree<>();
   } // end default constructor

   public V add(K key, V value) {
       Entry<K, V> newEntry = new Entry<>(key, value);
       Entry<K, V> returnEntry = bst.add(newEntry);
       V result = null;
       if(returnEntry != null)
           result = returnEntry.getValue();
       return result;
   }

   public V getValue(K key) {
       Entry<K, V> findEntry = new Entry<>(key, null);
       Entry<K, V> returnEntry = bst.getEntry(findEntry);
       V result = null;
       if(returnEntry != null)
           result = returnEntry.getValue();
       return result;
   }

   public V remove(K key) {
       Entry<K, V> findEntry = new Entry<>(key, null);
       Entry<K, V> returnEntry = bst.remove(findEntry);
       V result = null;
       if(returnEntry != null)
           result = returnEntry.getValue();
       return result;
   }

   public boolean contains(K key) {
       Entry<K, V> findEntry = new Entry<>(key, null);
       Entry<K, V> returnEntry = bst.getEntry(findEntry);
       return returnEntry != null;
   }

   public Iterator<K> getKeyIterator() {
       return new KeyIterator();
   }

   public Iterator<V> getValueIterator() {
       return new ValueIterator();
   }

   public boolean isEmpty() {
       return bst.isEmpty();
   }

   public int getSize() {
       return bst.getNumberOfNodes();
   }

   public void clear() {
       bst.clear();
   }

   private class KeyIterator implements Iterator<K>{

       private Iterator<Entry<K, V>> key;

       public KeyIterator(){
           key = bst.getInorderIterator();
       }

       public boolean hasNext() {
           return key.hasNext();
       }

       public K next() {
           Entry<K, V> nextEntry = key.next();
           return nextEntry.getKey();
       }

       public void remove() {
           throw new UnsupportedOperationException();
       }
   }

   private class ValueIterator implements Iterator<V>{

       private Iterator<Entry<K, V>> value;

       public ValueIterator(){
           value = bst.getInorderIterator();
       }

       public boolean hasNext() {
           return value.hasNext();
       }

       public V next() {
           Entry<K, V> nextEntry = value.next();
           return nextEntry.getValue();
       }

       public void remove() {
           throw new UnsupportedOperationException();
       }
   }

   private class Entry<S extends Comparable<? super S>, T> 
           implements Comparable<Entry<S, T>>
   {
      private S key;
      private T value;

      private Entry(S searchKey, T dataValue)
      {
         key = searchKey;
         value = dataValue;
      } // end constructor

      public int compareTo(Entry<S, T> other)
      {
         return key.compareTo(other.key);
      } // end compareTo
      
      public boolean equals(Entry<S, T> other)
      {
    	  boolean equal=false;
    	  if(key.compareTo(other.key) == 1);  
    	       equal=true;
    	
    	  return equal;
      }
      
      private S getKey()
	  {
	  	return key;
	  } // end getKey
		
	  private T getValue()
	  {
		return value;
	  } // end getValue
	  
	  public String toString()
	  {
		  return "a";
	  }
   } // end Entry
} // end BstDictionary
