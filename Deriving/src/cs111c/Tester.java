package cs111c;

import java.util.Iterator;



/**Tester class 
 * to test LinkedChainList and LinkedListWithIterator class
 * @author Jiadong Yu
 * @version 1.1
 * @since 10/18/2016
 * @param <T>
 */

public class Tester {

	public static void main(String[] args) {
		
    ListInterface<String> string = new LinkedChainList<>();
    
	testAdd(string, "Banana");
	testAdd(string, "Apple");
	testAdd(string, "Pear");
	testAdd(string, "Grape");
	testAdd(string, "Cherry");
	display(string);
	testAdd(string, "Lychee",2);
	testAdd(string, "Peach",4);
	display(string);
	testRemove(string,3);
	testRemove(string,5);
	display(string);
	testReplace(string,"Mango",1);
	testReplace(string,"Orange",3);
	display(string);
	
	IteratorTest();
	}

	public static void testAdd(ListInterface<String> q, String entry) {
		q.add(entry);
	}
	public static void testAdd(ListInterface<String> q, String entry,int position) {
		q.add(position , entry);
	}
	public static void testRemove(ListInterface<String> q, int position) {
		q.remove(position);
	}
	public static void testReplace(ListInterface<String> q, String entry,int position) {
		q.replace(position, entry);
	}
	public static void display(ListInterface<String> q) {
		int length = q.getLength();
		for (int i = 1; i <= length; i++) {
			System.out.println("Position at " + i + " is " + q.getEntry(i));
		}
		System.out.println();
	}
	public static void IteratorTest() {
		System.out.println("Iterator Test");
		LinkedListWithIterator<String> fruit = new LinkedListWithIterator<String>();
		fruit.add("Banana");
		fruit.add("Apple");
		fruit.add("Grape");
		fruit.add("Mango");
		fruit.add("Orange");
		for (int i = 1; i < fruit.getLength()+1; i++) {
			System.out.println(fruit.getEntry(i));
		}
		Iterator<String> nameIterator = fruit.getIterator();
		System.out.println("Contain next? return ture if it is, false it not: " + nameIterator.hasNext());
		
	}

}
