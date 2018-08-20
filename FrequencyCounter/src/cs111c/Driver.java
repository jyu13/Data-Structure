package cs111c;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
/**
   A driver that demonstrates the class FrequencyCounter.
   
 * @author Jiadong Yu
 * @version 1.1
 * @since 10/25/2016

*/
public class Driver
{
   public static void main(String[] args) 
   {
      FrequencyCounter wordCounter = new FrequencyCounter();
      String fileName = "src/cs111c/Alice.txt"; // Or file name could be read

      try
      {
         Scanner data = new Scanner(new File(fileName));
         wordCounter.readFile(data);
      }
      catch (FileNotFoundException e)
      {
         System.out.println("File not found: " + e.getMessage());
      }

      wordCounter.display();
      wordCounter.displayFrequency("Alice");
      wordCounter.displayFrequency("Rabbit");
      wordCounter.displayFrequency("Cheshire");
      wordCounter.displayFrequency("Mad");
      wordCounter.displayFrequency("Hatter");
   }  // end main
}  // end Driver


