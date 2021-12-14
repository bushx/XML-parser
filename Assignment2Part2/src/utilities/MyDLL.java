package utilities;

import java.util.NoSuchElementException;

/**
 * <p>
 * The <code>MyDLL</code> interface is designed to be used as a basis for all
 * the ListADT<E> data structures that will be developed in the CPRG 311 class at 
 * Group in Wakka . The implementors of this interface will be required to add all the 
 * functionality.
 * </p>
 * @author Eunji Lee
 * @param <E> The type of elements this list holds.
 */
public class MyDLL<E> implements ListADT<E> {
	private MyDLLNode<E> head;
	private MyDLLNode<E> tail;	
	
	/**
	 * 
	 */
	public MyDLL() {
		this.head = null;
		this.tail = null;
	}

	public MyDLLNode<E> getHead() {
		return head;
	}

	public void setHead(MyDLLNode<E> head) {
		this.head = head;
	}

	public MyDLLNode<E> getTail() {
		return tail;
	}

	public void setTail(MyDLLNode<E> tail) {
		this.tail = tail;
	}

	@Override
	public int size() {
		int size = 0;
		
		Iterator<E> iterator = iterator();

		while(iterator.hasNext()) {
			size++;
			iterator.next();
		}
				
		return size;
	}

	@Override
	public void clear() {
		if(!isEmpty()) {
			MyDLLNode<E> curr = head;
			
			while(curr != null) {
				MyDLLNode<E> nextNode = curr.getNext();
				curr.setElement(null);
				curr.setNext(null);
				curr.setPrev(null);
				curr = nextNode;
			}
			
			head = null;
			tail = null;
		}
	}

	@Override
	public boolean add(int index, E toAdd) throws NullPointerException, IndexOutOfBoundsException {
		if(index < 0 || index > size()) {
			throw new IndexOutOfBoundsException("The index is out of range");
		}
		
		if(toAdd == null) {
			throw new NullPointerException("This element is null and "
					+ "the list implementation does not support having null elements");	
		}
		
		MyDLLNode<E> newNode = new MyDLLNode<E>(toAdd, null, null);
		
		if(index == 0) {			
			if(isEmpty()) {
				head = newNode; 
				tail = newNode;
			} else {
				newNode.setNext(head);
				head.setPrev(newNode);
				head = newNode;
			}
		} else if(index == size()) {
			add(toAdd);
		} else {
			MyDLLNode<E> curr = head;			
			Iterator<E> iterator = iterator();
			int count = 0;
			
			while(iterator.hasNext()) {
				if(count == index) {
					curr.getPrev().setNext(newNode);
					newNode.setPrev(curr.getPrev());
					curr.setPrev(newNode);
					newNode.setNext(curr);
					
					return true;
				}
				
				curr = curr.getNext();		
				count++;
			}
		}
		
		return true;
	}

	@Override
	public boolean add(E toAdd) throws NullPointerException {
		if(toAdd == null) {
			throw new NullPointerException("This element is null and "
					+ "the list implementation does not support having null elements");	
		}
		
		MyDLLNode<E> newNode = new MyDLLNode<E>(toAdd, null, null);
		
		if(isEmpty()) {
			head = newNode; 
			tail = newNode;
		} else {
			tail.setNext(newNode);
			newNode.setPrev(tail);
			tail = newNode;				
		}
		
		return true;
	}

	@Override
	public boolean addAll(ListADT<? extends E> toAdd) throws NullPointerException {
		if(toAdd == null) {
			throw new NullPointerException("This element is null and "
					+ "the list implementation does not support having null elements");	
		}

		Iterator<? extends E> iterator = toAdd.iterator();
		
		while(iterator.hasNext()) {
			add(iterator.next());
		}
		
		return true;
	}

	@Override
	public E get(int index) throws IndexOutOfBoundsException {
		if(index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException("The index is out of range");
		}
		
		MyDLLNode<E> curr = head;
		Iterator<E> iterator = iterator();
		int count = 0;
		
		while(iterator.hasNext()) {
			if(count == index) {				
				return curr.getElement();	
			}
			
			curr = curr.getNext();			
			count++;
		}
		
		return curr.getElement();
	}

	@Override
	public E remove(int index) throws IndexOutOfBoundsException {
		if(index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException("The index is out of range");
		}
		
		E element = head.getElement();
		
		if(size() == 1) {			
			head = null; 
			tail = null;
			
			return element;
		}
		
		if(index == 0) {			
			head.getNext().setPrev(null);
			head = head.getNext();
		} else if(index == (size() - 1)) {
			element = tail.getElement();
			
			tail.getPrev().setNext(null); 
			tail = tail.getPrev();
		} else {			
			MyDLLNode<E> curr = head;
			Iterator<E> iterator = iterator();
			int count = 0;
			
			while(iterator.hasNext()) {
				if(count == index) {
					element = curr.getElement();
					
					curr.getPrev().setNext(curr.getNext());
					curr.getNext().setPrev(curr.getPrev());
					
					return element;	
				}
				
				curr = curr.getNext();			
				count++;
			}
		}
		
		return element;
	}

	@Override
	public E remove(E toRemove) throws NullPointerException {
		if(toRemove == null) {
			throw new NullPointerException("This element is null and "
					+ "the list implementation does not support having null elements");	
		}
		
		Iterator<E> iterator = iterator();
		int index = 0;
		
		while(iterator.hasNext()) {
			if(toRemove.equals(iterator.next())) {
				return remove(index);
			}
			
			index++;
		}
		
		return null;
	}

	@Override
	public E set(int index, E toChange) throws NullPointerException, IndexOutOfBoundsException {
		if(index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException("The index is out of range");
		}
		
		if(toChange == null) {
			throw new NullPointerException("This element is null and "
					+ "the list implementation does not support having null elements");	
		}

		MyDLLNode<E> curr = head;		
		Iterator<E> iterator = iterator();
		int count = 0;
		
		while(iterator.hasNext()) {
			if(count == index) {
				E element = curr.getElement();
				curr.setElement(toChange);
				
				return element;
			}
			
			curr = curr.getNext();		
			count++;
		}
		
		return curr.getElement();
	}

	@Override
	public boolean isEmpty() {
		return (size() == 0);
	}

	@Override
	public boolean contains(E toFind) throws NullPointerException {
		if(toFind == null) {
			throw new NullPointerException("This element is null and "
					+ "the list implementation does not support having null elements");	
		}
		
		Iterator<E> iterator = iterator();

		while(iterator.hasNext()) {
			if(toFind.equals(iterator.next())) {
				return true;
			}
		}
		
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E[] toArray(E[] toHold) throws NullPointerException {		
		if(toHold == null) {
			throw new NullPointerException("This array is null");
		}
		
		if(toHold.length < size()) {
			toHold = (E[]) java.lang.reflect.Array.newInstance(
					toHold.getClass().getComponentType(), size());
		}
		
		Object[] copy = toHold;
		MyDLLNode<E> curr = head;
		Iterator<E> iterator = iterator();
		int index = 0;
		
		while(iterator.hasNext()) {			
			copy[index] = curr.getElement();
			curr = curr.getNext();
			iterator.next();
			index++;
		}
		
		return toHold;
	}

	@Override
	public Object[] toArray() {
		Object[] array = new Object[size()];
		MyDLLNode<E> curr = head;
		Iterator<E> iterator = iterator();
		int index = 0;
		
		while(iterator.hasNext()) {			
			array[index] = curr.getElement();
			curr = curr.getNext();
			iterator.next();
			index++;
		}
		
		return array;
	}

	@Override
	public Iterator<E> iterator() {	
		return new Iterator<E>() {
			private MyDLLNode<E> curr = head;
			
			@Override
			public boolean hasNext() {				
				return (curr != null);
			}

			@Override
			public E next() throws NoSuchElementException {
				if(curr == null) {
					throw new NoSuchElementException("Current node is null");
				}
				
				E element = curr.getElement();
				curr = curr.getNext();
				
				return element;				
			}
		};
	}	
}