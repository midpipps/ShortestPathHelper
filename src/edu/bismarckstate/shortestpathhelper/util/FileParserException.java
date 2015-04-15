package edu.bismarckstate.shortestpathhelper.util;

/**
 * Generic exception for the file parser
 * @author Lucas Pippenger
 * @version 1.0
 *
 */
public class FileParserException extends Exception {

	/**
	 * the message to display to the user
	 */
	private String message  = null;
	
	/**
	 * Generic Exception with no information
	 */
	public FileParserException(){
	}
	
	/**
	 * Exception with a message about what caused the exception
	 * @param message What caused the exception
	 */
	public FileParserException(String message){
		super(message);
		this.message = message;
	} 
	
	/**
	 * Exception with an actual cause to the exception
	 * @param cause the cause of the exception
	 */
	public FileParserException(Throwable cause){
		super(cause);
	}
	
	/**
	 * Exception with a message about the exception and a cause
	 * @param message string explaining the exception
	 * @param cause the actual cause of the exception
	 */
	public FileParserException(String message, Throwable cause){
		super(message, cause);
		this.message = message;
	}
	
	/**
	 * just the message that is stored in this exception class.
	 */
	@Override
	public String toString(){
		return message;
	}
	
	/**
	 * just returns the message stored in this exception class
	 */
	@Override
	public String getMessage(){
		return message;
	}
}
