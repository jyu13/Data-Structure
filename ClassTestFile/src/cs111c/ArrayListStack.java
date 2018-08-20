package cs111c;

import java.util.*;

public class ArrayListStack<T> {
	
	private List<T> list = new ArrayList<>();
	
	public ArrayListStack()
	{
	}
	
	public void push(T newEntry)
	{
		list.add(newEntry);
	}

	public T pop()
	{
		T a = list.get(list.size()-1);
		list.remove(list.size()-1);
		return a;
	}

	public T peek()
	{
		T a = list.get(list.size()-1);
		return a;
	}

	public boolean isEmpty()
	{
		return list.size()==0;
	}

	public void clear()
	{
		list.clear();
	}
	

}
