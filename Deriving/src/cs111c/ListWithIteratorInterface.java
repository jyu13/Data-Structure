package cs111c;

import java.util.Iterator;

public interface ListWithIteratorInterface<T> extends Iterable<T>, ListInterface<T> {

	public Iterator<T> getIterator();
}
