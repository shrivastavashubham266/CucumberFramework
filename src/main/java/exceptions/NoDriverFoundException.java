package exceptions;

/**
 * @author Shubham Shrivastava
 * @since 04/12/2021
 */
public class NoDriverFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public NoDriverFoundException(String message) {
		super(message);
	}
	
	public NoDriverFoundException(){
		this("");
	}

}
