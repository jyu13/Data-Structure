package generics;

public class Tester {
       public static void main(String[] args){
       
    	   
    	   Animal a = new Animal(4);
    	   
    	   System.out.println(a.getLegs());;
       }
}


class Animal{
	
	private Integer legs;
	
	Animal(Integer l){
		legs=l;
	}
	
	public Integer getLegs(){
		return legs;
	}
}