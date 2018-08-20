package cs111c;

import java.util.Date;
import java.util.Random;

/**A class ListComparsion as a tester 
 *Create an empty list, then add one million String objects using the add(T)  method.
 *Create an empty list, then add one million String objects using add(T, index) method. Each object should be added using a random index.
 *In a million element list, remove 10,000 elements using random indexes.
 *In a million element list, replace 10,000 elements using random indexes.
 * @author Jiadong Yu
 * @version 1.1
 * @since 10/11/2016
 * @param <T>
 */

public class ListComparsion {

	public static void main(String[] args) {
	
		ListInterface<String> array = new ArrayBasedList<>(10000000);
		ListInterface<String> array1 = new ArrayBasedList<>(10000000);
		ListInterface<String> linked = new LinkedListBasedList<>();
		ListInterface<String> linked1 = new LinkedListBasedList<>();

		Date start = new Date();
		for (int i = 0;i < 1000000 ; i++)
		{
		   
			array.add(generateRandomString());
		}
		System.out.println("Step1");
		for (int ii = 0;ii < 1000000; ii++)
		{
			Random ran = new Random();
			array1.add(ran.nextInt(ii+1)+1 ,generateRandomString());
		}
		System.out.println("Step2");
		for (int iii = 0;iii < 10000;iii++)
		{
			Random ran = new Random();
			array.remove(ran.nextInt(9999)+1);
		}
		System.out.println("Step3");
		for (int iiii = 0;iiii < 10000;iiii++)
		{
			Random ran = new Random();
			array1.replace(ran.nextInt(100000), generateRandomString());
		}
		System.out.println("Step4");
  
		Date end=new Date();
		long elapasedTime = end.getTime()-start.getTime();
		
		System.out.println("The Time needed for ArrayBasedList is : " + elapasedTime);
		
		
		
		Date start1 = new Date();
		System.out.println("Step5");
		for (int j = 0;j < 100000;j++)
		{
		   
			linked.add(generateRandomString());
		}
		System.out.println("Step6");
		for (int jj = 0;jj < 100000;jj++)
		{
			Random ran = new Random();
			linked1.add(ran.nextInt(jj+1)+1,generateRandomString());
		}
		System.out.println("Step7");
		for (int jjj = 0;jjj < 10000;jjj++)
		{
			Random ran = new Random();
			linked.remove(ran.nextInt(9999)+1);
		}
		System.out.println("Step8");
		for (int jjjj = 0;jjjj < 10000;jjjj++)
		{
			Random ran = new Random();
			linked1.replace(ran.nextInt(99998)+1, generateRandomString());
		}
		
		Date end1=new Date();
		long elapasedTime1 = end1.getTime() - start1.getTime();
		
		System.out.println("The Time needed for LinkedListBasedList is : " + elapasedTime1);
	}

	public static String generateRandomString()
	{
		int leftLimit = 97;
		int rightLimit = 122;
		int length = 1;
		StringBuilder buffer= new StringBuilder(length);
		for (int i = 0;i < length;i++)
		{
			int randomLimited = leftLimit + (int)(new Random().nextFloat()*(rightLimit - leftLimit));
			buffer.append(randomLimited);
		}
		
		 return buffer.toString();
	}

}
