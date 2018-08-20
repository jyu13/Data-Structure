package cs111c;

public class ArrayStringSet implements StringSet{
	
	private int count = 0;
	private String[] data;
	
	public ArrayStringSet(){
		data = new String[8];
	}
	
	public boolean contain(String s){
		return true;
		}
	public int count(){
		return 0;
		}
	public void add(String s){}
	public void remove(String s){}

}
