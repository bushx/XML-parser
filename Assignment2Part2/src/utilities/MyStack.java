package utilities;

import java.util.EmptyStackException;

/**
 * <p>
 * The <code> MyStack<E></code> interface is designed to be used as a basis for all
 * the StackADT<E> data structures that will be developed in the CPRG 311 class from
 * Group in Wakka. The implementors of this interface will be required to add all the 
 * functionality.
 * </p>
 * @author Jonghan Park 
 * @param <E> The type of elements this list holds.
 */
public class MyStack<E> implements StackADT<E> {
	private int index = 0;

	MyArrayList<E> stack = new MyArrayList<>();


	@Override
	public void push(E toAdd) throws NullPointerException {
		if (toAdd == null) {
			System.out.println("Element is null. Please input valid data.");
			return;
		}

		if (index == 0) {
			stack.add(0, toAdd);
		} else {
			index++;
			stack.add(index, toAdd);
		}
	}

	@Override
	public E pop() throws EmptyStackException {
		if (stack.isEmpty()) {
			throw new EmptyStackException();
		}
		return (E) stack.remove(0);
	}

	@Override
	public E peek() throws EmptyStackException {
		if (stack.isEmpty()) {
			throw new EmptyStackException();
		}
		return (E) stack.get(0);
	}

	@Override
	public int search(E toFind) {

		for (int i = 0; i < stack.size(); i++) {
			if (stack.get(i).equals(toFind) || stack.get(i) == toFind) {
				return i + 1;
			}
		}
		return -1;
	}

	@Override
	public boolean contains(E toFind) throws NullPointerException {
		if (toFind == null) {
			throw new NullPointerException("Null cannot be accepted.");
		}
		for (int i = 0; i < stack.size(); i++) {
			if (stack.get(i).equals(toFind)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean equals(StackADT<E> that) {

		Iterator<E> stack2Iterator = (Iterator<E>) that.iterator();

		for (int i = 0; i < stack.size(); i++) {
			E e1 = stack.get(i);
			E e2 = stack2Iterator.next();
			if (!e1.equals(e2)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public int size() {
		return stack.size();
	}

	@Override
	public boolean isEmpty() {
		return stack.isEmpty();
	}

	@Override
	public void clear() {
		while (!stack.isEmpty()) {
			for (int i = 0; i < stack.size(); i++) {
				stack.remove(i);
			}
		}

	}

	@Override
	public E[] toArray(E[] holder) throws NullPointerException {
		if (holder == null) {
			throw new NullPointerException("Null cannot be accepted.");
		}
		for (int i = 0; i < stack.size(); i++) {
			holder[i] = (E) stack.get(i);
		}
		return holder;
	}

	@Override
	public Object[] toArray() {
		Object[] array = new Object[stack.size()];
		for (int i = 0; i < stack.size(); i++) {
			array[i] = stack.get(i);
		}
		return array;

	}

	@Override
	public Iterator<E> iterator() {
		return new Iterator<E>() {
			private int itrIndex = 0;

			@Override
			public boolean hasNext() {
				if (itrIndex < stack.size()) {
					return true;
				} else {

					return false;
				}
			}

			@Override
			public E next() {
				E element = stack.get(itrIndex);
				itrIndex++;
				return element;
			}
		};
	}
}