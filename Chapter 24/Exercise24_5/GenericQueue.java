// Author: Evie Welch
// date: 21/02/23
import java.util.LinkedList;


public class GenericQueue<E> extends LinkedList<E> {
	
	public void enqueue(E e) {
		addLast(e);
	}
	public E dqueue() {
		return removeFirst();
	}
	public int getSize() {
		return size();
	}
	@Override
	public String toString() {
		return "Queue: " + super.toString();
	}
}
