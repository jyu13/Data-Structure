package cs111c;

import java.util.Iterator;
import java.util.Scanner;
/**
   A class that counts the number of times each word occurs in a document.
   
 * @author Jiadong Yu
 * @version 1.1
 * @since 10/25/2016
*/
public class FrequencyCounter
{
   private DictionaryInterface<String, Integer> wordTable;

   public FrequencyCounter() 
   {
      wordTable = new HashedDictionaryNew<>();
   } // end default constructor
   
   // 19.16
   /** Reads a text file of words and counts their frequencies of occurrence.
       @param data  A text scanner for the text file of data. */
   public void readFile(Scanner data)
   {
      data.useDelimiter("\\W+");

      while (data.hasNext())
      {
         String nextWord = data.next();
         //nextWord = nextWord.toLowerCase(); will cause no more capital letters
         Integer frequency = wordTable.getValue(nextWord);

         if (frequency == null)
         { // Add new word to table
            wordTable.add(nextWord, new Integer(1));
         }
         else
         {  // Increment count of existing word; replace wordTable entry
            frequency++;
            wordTable.add(nextWord, frequency);
         } // end if
      } // end while

      data.close();
   } // end readFile
   // 19.17
   /** Displays words and their frequencies of occurrence. */
   public void display()
   {
      int maxFrequency = 0, frequency;
      String maxFrequencyWord = null, word;
	  Iterator<String>  keyIterator   = wordTable.getKeyIterator();
      Iterator<Integer> valueIterator = wordTable.getValueIterator();

      
      while (keyIterator.hasNext())
      {
    	  word = keyIterator.next();
    	  frequency = valueIterator.next();
    	  if (frequency >  maxFrequency)
    	  {
    		  maxFrequency = frequency;
    		  maxFrequencyWord = word;
    	  }
          System.out.println(word + " " + frequency);
      } // end while    
      System.out.println("Most ofter appeared word is : " +  maxFrequencyWord + " " + maxFrequency);
   } // end display
   
   public void displayFrequency(String word)
   {
	   
	   System.out.println(word + " " + wordTable.getValue(word));
	   
   }
} // end FrequencyCounter