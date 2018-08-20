package cs111c;


/**A class Tester test if all the methods work in the Class LinkedBag
 * @author Jiadong Yu
 * @version 1.1
 * @since 09/5/2016
 */
public class Tester
{
	
	public static void main(String[] args) 
	{
		// A bag whose initial capacity is small
        BagInterface<String> aBag = new LinkedBag<>();
        BagInterface<String> aBag1 = new LinkedBag<>();
        BagInterface<String> aBag2 = new LinkedBag<>();
        testIsEmpty(aBag, true);
        testIsEmpty(aBag1, true);
        testIsEmpty(aBag2, true);
        
		System.out.println("Adding to the bag more strings than its initial capacity.");
        String[] contentsOfBag = {"A", "D", "B", "A", "C", "A", "D"};
		testAdd(aBag, contentsOfBag);
		
		//test if the bag contains duplicate entries
		System.out.println("Does the bag contains duplicate entries?  "+ aBag.hasDuplicateEntries());

        testIsEmpty(aBag, false);
        String[] testStrings2 = {"A", "B", "C", "D", "Z"};
        testAdd(aBag1,testStrings2);
        String[] testStrings3 = {"D","A","A","A","D","C","B"};
        testAdd(aBag2,testStrings3);
        
        //test if two bags contain the same entry
        System.out.println("Does the Bag and Bag1 contain the same entries? " + aBag.equals(aBag1));
        System.out.println("Does the Bag1 and Bag2 contain the same entries? " + aBag1.equals(aBag2));
        System.out.println("Does the Bag and Bag2 contain the same entries? " + aBag.equals(aBag2));
        testFrequency(aBag, testStrings2);
        testContains(aBag, testStrings2);
		
        // Removing strings
		String[] testStrings4 = {"", "B", "A", "C", "Z"};
        testRemove(aBag, testStrings4);

		System.out.println("\nClearing the bag:");
		aBag.clear();
        testIsEmpty(aBag, true);
		displayBag(aBag);
	} // end main
	
    // Tests the method add.
	private static void testAdd(BagInterface<String> aBag, String[] content)
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

   // Tests the two remove methods.
	private static void testRemove(BagInterface<String> aBag, String[] tests)
	{
      for (int index = 0; index < tests.length; index++)
      {
         String aString = tests[index];
         if (aString.equals("") || (aString == null))
         {
            // test remove()
            System.out.println("\nRemoving a string from the bag:");
            String removedString = aBag.remove();
            System.out.println("remove() returns " + removedString);
         }
         else
         {
            // test remove(aString)
            System.out.println("\nRemoving \"" + aString + "\" from the bag:");
            boolean result = aBag.remove(aString);
            System.out.println("remove(\"" + aString + "\") returns " + result);
         } // end if
         
         displayBag(aBag);
      } // end for
	} // end testRemove

   // Tests the method isEmpty.
   // correctResult indicates what isEmpty should return.   
	private static void testIsEmpty(BagInterface<String> aBag, boolean correctResult)
	{
      System.out.print("Testing isEmpty with ");
      if (correctResult)
         System.out.println("an empty bag:");
      else
         System.out.println("a bag that is not empty:");
      
      System.out.print("isEmpty finds the bag ");
      if (correctResult && aBag.isEmpty())
			System.out.println("empty: OK.");
		else if (correctResult)
			System.out.println("not empty, but it is empty: ERROR.");
		else if (!correctResult && aBag.isEmpty())
			System.out.println("empty, but it is not empty: ERROR.");
		else
			System.out.println("not empty: OK.");      
		System.out.println();
	} // end testIsEmpty
	 
	// Tests the method getFrequencyOf.
	private static void testFrequency(BagInterface<String> aBag, String[] tests)
	{
	 	System.out.println("\nTesting the method getFrequencyOf:");
	    for (int index = 0; index < tests.length; index++)
	    System.out.println("In this bag, the count of " + tests[index] + 
	                            " is " + aBag.getFrequencyOf(tests[index]));
	} // end testFrequency


   
   // Tests the method contains.
	private static void testContains(BagInterface<String> aBag, String[] tests)
	{
 		System.out.println("\nTesting the method contains:");

        	for (int index = 0; index < tests.length; index++)        
        System.out.println("Does this bag contain " + tests[index] + "? " + aBag.contains(tests[index]));
        
        
    } // end testContains

   // Tests the method toArray while displaying the bag.
	private static void displayBag(BagInterface<String> aBag)
	{
		System.out.println("The bag contains " + aBag.getCurrentSize() +
		                   " string(s), as follows:");		
		Object[] bagArray = aBag.toArray();
		for (int index = 0; index < bagArray.length; index++)
		{
			System.out.print(bagArray[index] + " ");
		} // end for
		
		System.out.println();
	} // end displayBag
} // end ResizableArrayBagDemo

