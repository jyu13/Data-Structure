package generics;

public class Test1 {

	public static void main(String[] args) {
		Integer[] a= {1,2,3,4};
		ArrayPrinter<Integer> ap = new ArrayPrinter<Integer>(a);
		
		String[] b = {"abc","bcd","edf"};
		ArrayPrinter<String> bp = new ArrayPrinter<String>(b);
		
		
		ap.print();
		bp.print();
	}

}


class ArrayPrinter<T>{
	
	
	private T[] array;
	
	public ArrayPrinter (T[] a) {
		array=a;
	}
	
	public void print() {
		
		for (T value: array) {
			System.out.println(value);
		}
	}
}