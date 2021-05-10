package edu.uoc.pac4;

/**
 * This Class Represents an Animal's Exception for the error messages
 * @author Guille
 * @version 1.1
 * PEC4 EX2
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
	public static final String MSG_ERR_YEAR_BIRTH = "[ERROR] Animal's birth year cannot be later than current year.";
	/**
	 * MSG_ERR_WEIGHT when animal weight is smaller
	 */
	public static final String MSG_ERR_WEIGHT = "[ERROR] Animal's weight cannot be smaller than 0.1 kg.";
	/**
	 * MSG_ERR_ENERGY when Energy has a negative value
	 */
	public static final String MSG_ERR_ENERGY = "[ERROR] Animal's energy cannot be a negative value.";
	/**
	 * MSG_ERR_HERBIVORE_FOOD when gives meat to herbivores
	 */
	public static final String MSG_ERR_HERBIVORE_FOOD = "[ERROR] An herbivore animal cannot eat any food which is not a plant.";
	/**
	 * MSG_ERR_CARNIVORE_FOOD when gives plants to carnivores
	 */
	public static final String MSG_ERR_CARNIVORE_FOOD = "[ERROR] A carnivore animal cannot eat any food which is not meat";
	
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
