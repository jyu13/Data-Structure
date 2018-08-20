package cs111c;

public class Tester1 {

	public static void main(String[] args) {
		
		Outer o1 = new Outer("First");
		Outer o2 = new Outer("Second");
		Outer.Inner o3 =  o1.inner();
		
		o1 = null;
		
		System.out.println(o3);
	}
	
}
