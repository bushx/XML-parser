package utilities;

import java.util.NoSuchElementException;

/**
 * <p>
 * The <code> MyArrayList<E></code> interface is designed to be used as a basis for all
 * the ListADT<E> data structures that will be developed in the CPRG 311 class from
 * Group in Wakka. The implementors of this interface will be required to add all the 
 * functionality.
 * </p>
 * @author Jihoon Oh 
 * @param <E> The type of elements this list holds.
 */
public class MyArrayList<E> implements ListADT<E> {
	private final int capacity=1;
	private Object[] MyArray = new Object[capacity]  ;
	private  int count =0;
	
	@Override
	public int size() {
		return count;
	}

	@Override
	public void clear() {		
		MyArray = new Object[capacity];
		count =0;
	}

	@Override
	public boolean add(int index, E toAdd) throws NullPointerException, IndexOutOfBoundsException {		
		if(toAdd == null){
			 throw new NullPointerException("This element is null and "
					+ "the list implementation does not support having null elements");
		}
		
		if(index < 0 || index > size()) {
			throw new IndexOutOfBoundsException("The index is out of range");
		}
		
		if(count == MyArray.length){
	        Object[] newArray = new Object[2 * MyArray.length];
	        for (int i = 0; i < MyArray.length; i++) { 
	        	newArray[i] = MyArray[i]; 
	        }
	        MyArray = newArray;
	    }

		for(int i = size(); i > index; i--) {
			MyArray[i] = MyArray[i - 1];
		}

		MyArray[index] = toAdd;
		count++;
	    return true;
	}

	@Override
	public boolean add(E toAdd) throws NullPointerException {
		if(toAdd == null){
			 throw new NullPointerException("This element is null and "
					+ "the list implementation does not support having null elements");
		}
				
		if(count == MyArray.length){
	        Object[] newArray = new Object[2 * MyArray.length];
	        for (int i = 0; i < MyArray.length; i++) { 
	        	newArray[i] = MyArray[i]; 
	        }
	        MyArray = newArray;
	    }
		
		count++;
	      
		MyArray[count - 1] = toAdd;
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
		  if (index < 0 ||index >= size()) {			  
			  throw new IndexOutOfBoundsException("The index is out of range");
		  }
		
		return  (E) MyArray[index];
	}

	@Override
	public E remove(int index) throws IndexOutOfBoundsException {
		if(index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException("The index is out of range");
		}

		E removed = (E) MyArray[index];

		 for(int i= index+1; i < size(); i++) {
			 MyArray[i-1] = MyArray[i];	
			 MyArray[i] = null;		 
		 }
		 count--;

		if(size() < (MyArray.length / 2)) {
			Object[] temp = new Object[count];

		  	for(int i =0; i < temp.length; i++) {
				temp[i] = MyArray[i];
			}

			MyArray = new Object[count];
			MyArray = temp;
		}

		return  removed;
	}

	@Override
	public E remove(E toRemove) throws NullPointerException {
		int position =0;
		E removed = null;

		if(toRemove == null) {			  
			throw new NullPointerException("This element is null and "
				+ "the list implementation does not support having null elements");
		}

		for(int i= 0; i < size(); i++) {			 
			if(MyArray[i] == toRemove) {
				position = i;
				removed = (E) MyArray[i];
				break;
			}
		}

		for(int i = position + 1; i < size(); i++) {
			MyArray[i-1] = MyArray[i];	
			MyArray[i] = null;		 
		}
		count--;

		if(size() < (MyArray.length / 2)) {
			Object[] temp = new Object[count];

		  	for(int i =0; i < temp.length; i++) {
				temp[i] = MyArray[i];
			}

			MyArray = new Object[count];
			MyArray = temp;
		}	 
		 		 
		return removed;
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
				
		return (E) (MyArray[index] = toChange);
	}

	@Override
	public boolean isEmpty() {		      
		if(count == 0) {
		   	return true;		    	
		}
		else {
		    return false;
		}
	}

	@Override
	public boolean contains(E toFind) throws NullPointerException {
		if(toFind == null) {
			throw new NullPointerException("This element is null and "
					+ "the list implementation does not support having null elements");	
		}
		
		for(int i= 0; i < size(); i++) {
			if(MyArray[i] == toFind) {
				return true;
			}
		}
		
		return false;
	}

	@Override
	public E[] toArray(E[] toHold) throws NullPointerException {	
		if(toHold == null) {
			throw new NullPointerException("This array is null");
		}
  
		if(toHold.length < size()) {
			toHold = (E[]) java.lang.reflect.Array.newInstance(
					toHold.getClass().getComponentType(), size());
		}
	      
	 	for(int i = 0; i < size(); i++) {			 
	 		toHold[i] = (E) MyArray[i];
		 }
		 
		return toHold;
	}

	@Override
	public Object[] toArray() {
		Object[] temp = new Object[count];

		for(int i =0; i < temp.length; i++) {
			temp[i] = MyArray[i];
		}
	   
		return temp;
	}

	@Override
	public Iterator<E> iterator() {	
		return new Iterator<E>() {
			private int index=0;			
			
			@Override
			public boolean hasNext() {				
				return (MyArray[index] !=null);
			}

			@Override
			public E next() throws NoSuchElementException {
				if(MyArray[index] == null) {
					throw new NoSuchElementException("Current element is null");
				}
				
				E element = (E)MyArray[index];
			    index++;
				
				return element;		  		
			}
		};
	}	
}