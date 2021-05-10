package edu.uoc.pac4;

/**
 * This Class Represents an Animal's Exception for the error messages
 * @author Guille
 * @version 1.0
 * PEC4 EX1
 */
public class AnimalException extends Exception
{
	/**
	 * SerialVersion assigned by default
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * MSG_ERR_YEAR_BIRTH when year is later than current year
	 */
	public static final String MSG_ERR_YEAR_BIRTH = "[ERROR] Animal's birth year cannot be later than current year";
	/**
	 * MSG_ERR_WEIGHT when animal weight is smaller
	 */
	public static final String MSG_ERR_WEIGHT = "[ERROR] Animal's weight cannot be smaller than 0.1 kg.";
	
	/**
	 * Constructor by default
	 */
	public AnimalException()
	{
		super();
	}
	
	/**
	 * Constructor by parameters
	 * @param msg
	 */
	public AnimalException(String msg)
	{
		super(msg);
	}
}
