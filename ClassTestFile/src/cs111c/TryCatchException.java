package cs111c;

public class TryCatchException {

	public static void main(String[] args) {
	
		
		try{
			
			int a ;
			String b;
			
			a = Num();
			b = Den();
			System.out.println(a/b);
			
		}catch (Exception e){
			System.out.println("error,error, attation");
		}	
	}
	
	
	public static int Num(){
		int x = 3;
		return x;
	}
	
	public static int Den(){
		
		int y=0;
		return y;
	}

}
