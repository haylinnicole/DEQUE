package MidtermS22338;

import java.util.Iterator;
import java.util.Vector;



public class DoubleEndedQueue <E> implements DoubleEndedQueueInterface <E>{

	private Node<E> front;
	private Node<E> back;
	private int size;
	
	
	public DoubleEndedQueue () {
		this.front=null;
		this.back=null;
		this.size =0;
	}
	
	
	@Override
	public Iterator<E> iterator() {
		Vector<E> vector = new Vector<E>();
		
		Node<E> curNode = this.front;
		while (curNode != null) {
			vector.add(curNode.getElement());
			curNode = curNode.getNext();
		}
		
		ElementIterator<E> ei = new ElementIterator<E>(vector);
		return ei;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return (this.size==0);
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return this.size;
	}

	@Override
	public void addFront(E element) throws NullPointerException {
		//FIXME: 
		if (element == null) {
			throw new NullPointerException("Unable to enqueue null element to ArrayBasedQueue");
		} else {
			Node<E> newNode = new Node<E>(element);
			if (this.isEmpty()) {
				this.front = newNode;
				this.back = newNode;
			} else {
				newNode.setNext(this.front);
				this.front.setPrevious(newNode);
				this.front = newNode;
			}
		}		
		
		this.size++;
		
		
	}
	

	@Override
	public void addBack(E element) throws NullPointerException {
		if (element == null) {
			throw new NullPointerException("Unable to enqueue null element to ArrayBasedQueue");
		} else {
			Node<E> newNode = new Node<E>(element);
			if (this.isEmpty()) {
				this.front = newNode;
				this.back = newNode;
			} else {
				this.back.setNext(newNode);
				newNode.setPrevious(this.back);
				this.back = newNode;
			}
		}		
		
		this.size++;
	}

	@Override
	public E removeFront() {
		if (this.isEmpty()) {
			return null;
		} else {
			E element = this.front.getElement();
			if (this.front == this.back) {
				this.front = null;
				this.back = null;
			} else {
				this.front = this.front.getNext();
				this.front.setPrevious(null);
			}
			this.size--;
			return element;
		}
	}

	@Override
	public E removeBack() {
		if (this.isEmpty()) {
			return null;
		} else {
			E element = this.back.getElement();
			if (this.front == this.back) {
				this.front = null;
				this.back = null;
			} else {
				
				this.back = this.back.getPrevious();
				this.back.setNext(null);
			}
			this.size--;
			return element;
		}
	}

	@Override
	public E peekFront() {
		if (this.isEmpty()) {
			return null;
		} else {
			return this.front.getElement();
		}
	}

	@Override
	public E peekBack() {
		if (this.isEmpty()) {
			return null;
		} else {
			return this.back.getElement();
		}
	}

	@Override
	public void removeAll() {
		this.front = null;
		this.back = null;
		this.size = 0;
	}
	
	
}
