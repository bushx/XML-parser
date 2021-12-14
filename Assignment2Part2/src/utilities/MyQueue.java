package utilities;

import exceptions.EmptyQueueException;

/**
 * <p>
 * The <code> MyQueue<E></code> interface is designed to be used as a basis for all
 * the QueueADT<E> data structures that will be developed in the CPRG 311 class from
 * Group in Wakka. The implementors of this interface will be required to add all the 
 * functionality.
 * </p>
 * @author Bushra Osman 
 * @param <E> The type of elements this list holds.
 */
public class MyQueue<E> implements QueueADT<E> {

	private MyDLL<E> q;

	public MyQueue() {
		q = new MyDLL<E>();
	}

	@Override
	public void enqueue(E toAdd) throws NullPointerException {
		q.add((E) toAdd);
	}

	@Override
	public E dequeue() throws EmptyQueueException {
		return q.remove(0);
	}

	@Override
	public E peek() throws EmptyQueueException {
		return q.get(0);
	}

	@Override
	public void dequeueAll() {
		q.clear();
	}

	@Override
	public boolean isEmpty() {
		return q.isEmpty();
	}

	@Override
	public Iterator<E> iterator() {
		return q.iterator();
	}

	@Override
	public boolean equals(QueueADT that) {
		Iterator<E> itr = (Iterator<E>) q.iterator();
		Iterator<E> itr2 = (Iterator<E>) that.iterator();
		while(itr.hasNext() && itr2.hasNext()) {
			E e1 = itr.next();
			E e2 = itr2.next();
			if (!e1.equals(e2)) {
				return false;
			}
		}
		
		return true;
	}

	@Override
	public Object[] toArray() {
		return q.toArray();
	}

	@Override
	public E[] toArray(E[] holder) throws NullPointerException {
		return  q.toArray(holder);
	}

	@Override
	public boolean isFull() {
		return false; 
	}
	
	@Override
	public int size() {
		return q.size();
	}	
}