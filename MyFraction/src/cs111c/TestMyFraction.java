package cs111c;

/**class TestMyFraction - 
 *This is a class to test MyFraction class and see if the class works
 * @author Jiadong Yu
 * @version 1.0
 * @since 08/23/2016
 */
public class TestMyFraction {

	public static void main(String[] args) {
	     Fraction f1 = new MyFraction(7, 9);
	        Fraction f2 = new MyFraction(5, 7);	        
	        Fraction f3 = f1.add(f2);
	        Fraction f4 = f1.subtract(f2);
	        Fraction f5 = f1.multiply(f2);
	        Fraction f6 = f1.divide(f2);
	        
	        boolean a = f1.compareTo(f2);
	        System.out.println(f3);
	        System.out.println(f4);
	        System.out.println(f5);	        
	        System.out.println(f6);
	        
	        if (a== true)
	            System.out.println("These two fractions are equal.");
	            else
	        	System.out.println("These two fractions are not equal");
	}
}
