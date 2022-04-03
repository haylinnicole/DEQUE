package MidtermS22338;

import java.util.Iterator;
import java.util.Vector;

public class ElementIterator<E> implements Iterator<E> {

private Vector<E> vector;
	
	
	public ElementIterator(Vector<E> vector) {
		this.vector = vector;
	}
	
	@Override
	public boolean hasNext() {
		return !vector.isEmpty();
	}

	@Override
	public E next() {
		return vector.remove(0);
	}

}
