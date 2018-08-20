package cs111c;

public class Outer {
    
	private String name;
	
	public Outer(String name) {
		this.name= name;
	}
 
	public Inner inner(){
		return new Inner();
	}
	
	public class Inner {
		public String toString(){
			return "inner class of " + name;
		}
	}
}
