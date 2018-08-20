package cs111c;


/**An EmptyQueueException Class to throw EmptyQueueException
 * @author Jiadong Yu
 * @version 1.1
 * @since 10/04/2016
 */
public class EmptyQueueException extends Exception {

	public EmptyQueueException()
	{
		super("Queue is Empty.");
	}
	public EmptyQueueException(String message)
	{
		super(message);
	}	
}
