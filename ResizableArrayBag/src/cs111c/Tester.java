package cs111c;

public class Tester {

	public static void main(String[] args) {
		BagInterface<String> aBag = new ResizableArrayBag<String>(5);
		
		String[] aBag1 = {"A","B","C","D","E","F","G"};
		String[] aBag2 = {"P","Q"};
		String[] aBag3 = {"X","Y","Z"};
		
		testAdd(aBag,aBag1);
		
		
		private static void testAdd(BagInterface<String> a, String[] content)
		{
			System.out.print("Adding to the bag: ");
			for (int index = 0; index < content.length; index++)
			{
				aBag.add(content[index]);
	         System.out.print(content[index] + " ");
			} // end for
	      System.out.println();
	      
			displayBag(aBag);
		} // end testAdd
		
	}

} 
