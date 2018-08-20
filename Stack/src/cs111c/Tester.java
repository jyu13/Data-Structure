package cs111c;

/**A class Tester to test class LinkedStack and ArrayStack 
 * @author Jiadong Yu
 * @version 1.1
 * @since 09/11/2016
 */
public class Tester {

	public static void main(String[] args) 
	{
	     StackInterface<String> aStack = new LinkedStack<>();
	     StackInterface<String> aStack1 = new ArrayStack<>(20); //initial the capacity of the array
	     testIsEmpty(aStack, true);
	     testIsEmpty(aStack1, true);
	     
	     System.out.println("Adding to the Linked Stack.");
	     String[] contentsOfStack = {"A", "D", "B", "A", "C", "A", "D"};
	     testPush(aStack, contentsOfStack);
	     testIsEmpty(aStack, false);
	     
	     System.out.println("Adding to the ArrayStack more strings than its initial capacity.");
	     String[] contentsOfStack1 = {"Z","B","U","O","P","T","R","E","S"};
	     testPush(aStack1, contentsOfStack1);
	     testIsEmpty(aStack1, false);
	     
	     System.out.println("Test peek of Stack:");
	     testPeek(aStack);
	     System.out.println("Test peek of Stack 1:");
	     testPeek(aStack1);
	     
	     System.out.println("Test toString of Stack:");
	     displayStack(aStack);
	     System.out.println("Test toString of Stack 1:");
	     displayStack(aStack1);
	     
	     System.out.println();
	     System.out.println("Test pop of Stack:");
	     testPop(aStack,4);
	     System.out.println("Test pop of Stack 1:");
	     testPop(aStack1,8);
	     
	     testPush(aStack,contentsOfStack);
	     testPush(aStack1,contentsOfStack1);
	     displayStack(aStack);
	     displayStack(aStack1);
	     
	     System.out.println("Test remove: remove 3 elements and display the stack:");
	     testRemove(aStack);
	     testRemove(aStack1);
	     displayStack(aStack);
	     displayStack(aStack1);
	     
	     System.out.println("Test pushAll: add 4 Bs to the Stack and display the stack:");
	     testPushAll(aStack);
	     testPushAll(aStack1);
	     displayStack(aStack);
	     displayStack(aStack1);
         aStack.doubleUp();
         displayStack(aStack);
	     
	     System.out.println("Test clear of Stack:");
         testIsClear(aStack);
	     System.out.println("Test clear of Stack 1:");
         testIsClear(aStack1);

		

	}
	private static void testPush(StackInterface<String> aStack, String[] content)
	{
		System.out.print("Adding to the stack: ");
		for (int index = 0; index < content.length; index++)
		{
			aStack.push(content[index]);

		} // end for
      System.out.println();
	}// end testPush
	
	private static void testPop(StackInterface<String> aStack, int times)
	{	
		
		for (int i =0; i < times ;i++)
		{		
           System.out.println("Pop out :" + aStack.pop() );
		}//end for
		
	}// end testPop
	
	private static void testPeek(StackInterface<String> aStack)
	{
		System.out.println("The first element on top of the Stack is:" + aStack.peek() );
		System.out.println("The second element on the top of the Stack is:" + aStack.peek2());
	}
	private static void testIsEmpty(StackInterface<String> aStack, boolean correctResult)
	{
      System.out.print("Testing isEmpty with ");
      if (correctResult)
         System.out.println("an empty stack:");
      else
         System.out.println("a stack that is not empty:");
      
      System.out.print("isEmpty finds the stack ");
      if (correctResult && aStack.isEmpty())
			System.out.println("empty: OK.");
		else if (correctResult)
			System.out.println("not empty, but it is empty: ERROR.");
		else if (!correctResult && aStack.isEmpty())
			System.out.println("empty, but it is not empty: ERROR.");
		else
			System.out.println("not empty: OK.");      
		System.out.println();
	} // end testIsEmpty
    
	
	private static void testRemove(StackInterface<String> aStack)
	{
		aStack.remove(3);
		System.out.println("I have removed 3 of the elements of the stack.");
	} // end testRemove
	
	private static void testPushAll(StackInterface<String> aStack)
	{
		String a[]={"B","B","B","B"};
		aStack.pushAll(a);
	} //end testPushAll
	
	private static void testIsClear(StackInterface<String> aStack)
	{
		aStack.clear();
		testIsEmpty(aStack,true);
    } //end testIsClear
	
	private static void displayStack(StackInterface<String> aStack)
	{
		System.out.println("All the elements in the stack are:" + aStack.toString());
	}// end displayStack
	
}// end Tester
