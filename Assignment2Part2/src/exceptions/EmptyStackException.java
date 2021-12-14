package exceptions;

/**
 * @author Bushra Osman, Jihoon Oh, Jonghan Park, Eunji Lee
 *
 */
public class EmptyStackException extends Exception{
	public EmptyStackException()
	{
		super();
	}

	/**
	 * @param message error message specific to cause of error.
	 */
	public EmptyStackException(String message)
	{
		super(message);
	}
}