package cs111c;

/**class MyFraction - 
 *This class will implements interface Fraction and give 
 *each method a definition. 
 * @author Jiadong Yu
 * @version 1.0
 * @since 08/23/2016
 */
public class MyFraction implements Fraction{

    private int numerator, denominator;

    public MyFraction (){
        numerator=0;
        denominator=1;
    }
    public MyFraction (int num, int den){
    	numerator=num;
    	denominator=den;
    }

    public void setFraction(int num, int den){
        numerator=num;
        denominator=den;
    }

    public void getFraction(){ }
    
    public int getNumerator(){
        return numerator;
    }

    public void setNumerator(int num){
        numerator=num;
    }

    public int getDenominator(){
        return denominator;
    }
//ass
    public void setDenominator(int den){
        denominator=den;
    }

/*toString method return the result as String
 */

    public String toString(){
        return numerator +"/"+ denominator;
    }
/* reciprocal method switch the numerator and denominator.
 */
    public String reciprocal(){
        return denominator+"/"+numerator;
    }
   
/*add method calculate the result from one fraction 
 *add another fraction and simplify the result 
 */
    public Fraction add(Fraction b){
        int addNum, addDen;
        addNum= numerator * b.getDenominator() + b.getNumerator()*denominator;
        addDen= denominator*b.getDenominator();
        int result= gcd(addNum,addDen);
        
        return new MyFraction(addNum/result,addDen/result);

    }
    
/*subtract method calculate the result from one fraction 
 *subtract another fraction and simplify the result 
 */

    public Fraction subtract(Fraction b){
       int subNum, subDen;
       subNum= numerator * b.getDenominator() - b.getNumerator()*denominator;
       subDen= denominator*b.getDenominator();
       int result= gcd(subNum,subDen);
    
       return new MyFraction(subNum/result,subDen/result);
    }    

/*multiply method calculate the result from one fraction 
 *multiply another fraction and simplify the result 
 */


public Fraction multiply(Fraction b){
    int mulNum, mulDen;
    mulNum= numerator *b.getNumerator();
    mulDen= denominator*b.getDenominator();
    int result= gcd(mulNum,mulDen);



    return new MyFraction(mulNum/result,mulDen/result);

}

/*divide method calculate the result from one fraction 
 *divide another fraction and simplify the result  
 */
public Fraction divide(Fraction b){
    int divNum, divDen;
    divNum= numerator * b.getDenominator();
    divDen= denominator*b.getNumerator();
    int result= gcd(divNum,divDen);



    return new MyFraction(divNum/result,divDen/result);

}

//compareTo method compare two fraction and return a boolean value

public boolean compareTo(Fraction b){
	int b_num,b_den;
	b_num=b.getNumerator();
	b_den=b.getDenominator();
	int result = gcd(b_num,b_den);
	
	if (numerator==(b_num/result) && denominator==(b_den/result))
		return true;
	else 
		return false;
}

//gcd method find out the greatest common factor of a fraction

private int gcd(int one, int two){

    int result;
    if (one%two == 0)
        result = two;
    else
        result = gcd(two, one%two);
    return result;

    }
}