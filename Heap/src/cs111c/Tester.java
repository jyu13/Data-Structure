package cs111c;

import java.util.ArrayList;
import java.util.Random;
/** 
  A tester help to find kthSmallest of an array
 * @author Jiadong Yu
 * @version 1.1
 * @since 11/15/2016

*/
public class Tester {

	public static void main(String[] args) {
		
		int arraySize = 1000;
		int arraySize2 = 2500;
		int arraySize3 = 5000;
		int[] temp = new int[arraySize];
		int[] temp2 = new int[arraySize2];
		int[] temp3 = new int[arraySize3];
		int k = 200;
		
		for (int i = 0; i < arraySize ; i++)
			temp[i] = generateRandomInt(arraySize);	
	
		for (int i = 0; i < arraySize2 ; i++)
			temp2[i] = generateRandomInt(arraySize2);
		
		for (int i = 0; i < arraySize3 ; i++)
			temp3[i] = generateRandomInt(arraySize3);
		
		int kth = kthSmallest(temp,k);

		System.out.println("The " + k +"th smallest of ArraySize "+ arraySize +" is :" + kth);
	
		int kth2 = kthSmallest(temp2,k);

		System.out.println("The " + k +"th smallest of ArraySize "+ arraySize2 +" is :" + kth2);

		int kth3 = kthSmallest(temp3,k);

		System.out.println("The " + k +"th smallest of ArraySize "+ arraySize3 +" is :" + kth3);
	}

	public static int kthSmallest(int[] a, int k)
	{
		MaxHeapInterface<Integer> maxHeap = new MaxHeap<>();
		int length = a.length;
		if (1 <= k && k <= length) {
	
			for( int i = 0 ; i < (length) ; i++)
		    { 
				maxHeap.add(a[i]);	 		
		    }
			for( int i = 0; i < length-k; i++)
			{				
					maxHeap.removeMax();			
			}
		
	    }else {
	    	throw new IllegalArgumentException();
	    }
		return maxHeap.getMax();
	}
	
	public static Integer generateRandomInt(int a ){
	    int randomNumber = new Random().nextInt(a);
		return randomNumber;
	}
}
