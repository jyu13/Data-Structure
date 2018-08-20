package generics;

public class Test2 {
   public static void main (String[] arg){
	 
	  String a = "abc";
	  Integer b = 3;
	  Name n = new Name("willow");
	  Fraction c= new Fraction(3,4);
	  Tree<String> ap = new Tree<String>(a);
	  Tree<Integer> bp = new Tree<Integer>(b);
	  
	  Tree<Name> np = new Tree<Name> (n);
	  
	  
	  ap.print();
	  bp.print();
	  np.print();
   }
}

class Tree<T>{
	
	private T bbb;
	
	public Tree(T a){
		bbb=a;
	}
	
	public void print(){
	
		System.out.println(bbb);
		
	}
}

class Name {
	
	public String name;
	public Name(String n){
		
		name=n;
	}
	
	public String getName(){
		return name;
	}
	

	
}

class Fraction{
	
	private int num,den;
	public Fraction(int n, int d){
		num=n;
		den=d;
	}
}