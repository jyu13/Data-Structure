package cs111c;

import java.util.Arrays;

public class ResizableArrayBag<T> implements BagInterface<T>{
	
	    private T[] bag;
	    private int numberofEntries;
	    private static final int Initial_size=10; 

	    
	
        public ResizableArrayBag(){
        	this(Initial_size);
        } // default constructor
        
        public ResizableArrayBag(int Initial){
            
        	checkCapacity(Initial);
        	
        	@SuppressWarnings("unchecked")
            T[] tempBag = (T[])new Object[Initial_size]; // Unchecked cast
            bag = tempBag;
            numberofEntries = 0;
        	
        } //default constructor to set empty bag
        
        public ResizableArrayBag(T[] contents){
        	
        	checkCapacity(contents.length);
        	bag=Arrays.copyOf(contents, contents.length);
        	numberofEntries=contents.length;
        	
        } //default constructor to set bag with Entries
	
        public int getCurrentSize(){
	    	
	    	
	    	return numberofEntries;
	    			
	    }


        public boolean isEmpty(){
        	
        	return numberofEntries == 0;
        }


        public boolean add(T newEntry){
        	
        	if (bag.length==numberofEntries)
        		doublesize();
        	if (isTooBig())
        		reduceArray();
        	bag[numberofEntries]=newEntry;
        	numberofEntries++;
        	return true;
        }


        public T remove(){
        	T result = bag[numberofEntries-1];
            bag[numberofEntries-1]=null;
            if (isTooBig())
            	reduceArray();
        	return result;
        }

        public boolean remove(T anEntry){
        	
        	boolean success=false;
        	for (int index=0; index<numberofEntries;index++){
        		if (anEntry==bag[index]){

        			int lastIndex= numberofEntries-1;
        			bag[index]=bag[lastIndex];
        			bag[lastIndex]=null;
        			
        			success=true;
        		}
        	}
        	if(isTooBig())
        		reduceArray();
        	
        	return success;
        }


        public void clear(){
        
        	while(!isEmpty())
                 remove();
        	
        }

        public int getFrequencyOf(T anEntry){
        	int counter=0;
        	for (int index=0; index<numberofEntries ; index++){
        		if (anEntry==bag[index])
        			counter++;
        	}
        	return counter;
        }

 
        public boolean contains(T anEntry){
        	boolean x=false;
        	for (int index=0; index<numberofEntries ; index++){
        		
        		if (anEntry==bag[index])
        			x=true;

        	}
            return x;
        	
        }


        public T[] toArray(){
            @SuppressWarnings("unchecked")
            T[] result = (T[])new Object[numberofEntries];
            for (int index = 0; index < numberofEntries; index++)
            {
               result[index] = bag[index];
            } 
            
            return result;
        }
        
        public void doublesize(){
        	int temp = bag.length*2;
        	checkCapacity(temp);
        	bag=Arrays.copyOf(bag,temp);
        }
        public void checkCapacity(int initial){
        	
        	if (initial > Initial_size)
        		throw new IllegalStateException("size is too big and will increase bag size."); 
            while (initial> Initial_size){
        		doublesize();
        	}
        }
        
        private boolean isTooBig(){
        	boolean a=false;
        	if ((bag.length>=20) && (numberofEntries < bag.length/2)){
        		
        		a=true;
        	}
        	return a;
        }
        private void reduceArray(){
        	int temp= bag.length*3/4;
        	bag = Arrays.copyOf(bag,temp);
        }
}