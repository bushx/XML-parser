package utilities;

/**
 * <p>
 * The <code>  MyDLLNode<E></code>  is designed to be used as a basis for all
 * the data structures that will be developed in the CPRG 311 class from
 * Group in Wakka. The implementors of this methods will be required to add all the 
 * functionality.
 * </p>
 * @author Eunji Lee
 * @param <E> The type of elements this list holds.
 */
public class MyDLLNode<E> {
	private E element;
	private MyDLLNode<E> prev;
	private MyDLLNode<E> next;
	
	public MyDLLNode() {
		super();
	}
	
	public MyDLLNode(E element, MyDLLNode<E> prev, MyDLLNode<E> next) {
		super();
		this.element = element;
		this.prev = prev;
		this.next = next;
	}

	public E getElement() {
		return element;
	}

	public void setElement(E element) {
		this.element = element;
	}

	public MyDLLNode<E> getPrev() {
		return prev;
	}

	public void setPrev(MyDLLNode<E> prev) {
		this.prev = prev;
	}

	public MyDLLNode<E> getNext() {
		return next;
	}

	public void setNext(MyDLLNode<E> next) {
		this.next = next;
	}
}