package cs111c;

public class Tester {

	public static void main(String[] args) {
	
		ArrayListStack<Integer> s = new ArrayListStack<>();
        
		s.push(4);
		s.push(1);
		s.push(2);
		s.push(3);
		
		if (s.isEmpty())
			System.out.println("The stack is empty.");
		
		if(s.peek()!=3)
			System.out.println("The top of the stack is not 3");
		
		s.pop();
		
		if(s.peek()!=2)
			System.out.println("The top of the stack is not 2");
		
		s.pop();
		
		if(s.peek()!=1)
			System.out.println("The top of the stack is not 3");
		
		s.pop();
		
		if(!s.isEmpty())
			System.out.println("ERROR");
	}
	
	public static void assertGood(String s)
	{
		int charNumber=0;
		
	    static boolean canIgnore(char c)
		{
			
		}
		static boolean isMatch(char c1,char c2)
		{
			return (c1=='('&&c2==')')||(c1=='{'&&c2=='}')||
		}
	}

}
