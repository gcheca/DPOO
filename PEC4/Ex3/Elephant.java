package edu.uoc.pac4;

/**
 * This class represents an Elephant son of herbivore
 * @author Guille
 *
 */
public class Elephant extends Herbivore
{
	/**
	 *  default Constructor
	 */
	public Elephant() 
	{
		super();
	}

	/**
	 * Parameters Constructor
	 * @param name
	 * @param yearBirth
	 * @param weight
	 * @param gender
	 * @throws AnimalException
	 */
	public Elephant(String name, int yearBirth, double weight, Gender gender) throws AnimalException 
	{
		super(name, yearBirth, weight, gender);
	}
	
	/**
	 * Noise method
	 */
	@Override
	public void makeNoise() 
	{
		System.out.println("Brrrrr!!!");
	}

	/**
	 * toString method
	 */
	@Override
	public String toString() 
	{
		return super.toString() + "\nI'm an elephant.";
	}
}