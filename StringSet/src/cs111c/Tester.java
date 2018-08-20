package cs111c;

public class Tester {

	public static void main(String[] args) {
	StringSet s = new ArrayStringSet();
	
	s.add("ABC");
	s.add("123");
	
	if (s.count() != 2){
		System.out.println("count desont work");
	
	}
	}

}
