package cs111c;

/**interface Fraction - 
 *represent all the methods will be used in MyFraction class
 *these methods include setter and getter
 *add,subtract,multiply and divide
 *reciprocal,compareTo and toString
 * @author Jiadong Yu
 * @version 1.0
 * @since 08/23/2016
 */
public interface Fraction {
    public void setFraction (int num, int den);
    public void getFraction ();

    public void setNumerator(int num);
    public int getNumerator();

    public void setDenominator(int den);
    public int getDenominator();

    public Fraction add(Fraction b);
    public Fraction subtract(Fraction b);
    public Fraction multiply(Fraction b);
    public Fraction divide(Fraction b);

    public String reciprocal();

    public boolean compareTo(Fraction b);

    public String toString();


}
