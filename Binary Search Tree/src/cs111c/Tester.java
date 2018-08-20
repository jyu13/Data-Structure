package cs111c;
import java.util.Random;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
public class Tester {

	public static void main(String[] args) {
		BinarySearchTree<Integer> tree = new BinarySearchTree<>();
		ArrayList<Integer> list = new ArrayList<>(100000);
		DictionaryInterface<String,Integer> key = new Dictionary<>();
		
		for(int i = 0; i < 100000; i++) {
			tree.add(generateRandomInt());
		}
		for(int i = 0; i<100000; i++){
			
			list.add(generateRandomInt());
		}
		
		Date treeStart = new Date();
		
		for (int j = 1; j<=1000 ; j++){		
			tree.contains(j);					
		}
		Date treeEnd = new Date();
		long elapasedTime = treeEnd.getTime() - treeStart.getTime();
		System.out.println("The searching time of tree is: "+ elapasedTime);
		
		Date listStart = new Date();
		
		for (int j = 1; j<=1000 ; j++){
			list.indexOf(j);
		}
		Date listEnd = new Date();
		long elapasedTime1 = listEnd.getTime() - listStart.getTime();
		System.out.println("The searching time of array is: "+ elapasedTime1);
		
		key.add("a", 1);
		key.add("b", 2);
		key.add("c", 3);
		key.add("e", 4);
        
	}

	public static Integer generateRandomInt(){
	    int randomNumber = new Random().nextInt(100000);
		return randomNumber;
	}
	public static void display(DictionaryInterface<String,Integer> other) {
		Iterator<String> key = other.getKeyIterator();
		Iterator<Integer> value = other.getValueIterator();
		
		while(key.hasNext())
		{
			System.out.println(key + " : " + value);
		}
	}
}
