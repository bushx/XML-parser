package exceptions;

/**
 * @author Bushra Osman, Jihoon Oh, Jonghan Park, Eunji Lee
 *
 */
@SuppressWarnings("serial")
public class EmptyQueueException extends Exception {
	public EmptyQueueException() {
		super();
	};
	
	public EmptyQueueException(String message) {
		
	}
}