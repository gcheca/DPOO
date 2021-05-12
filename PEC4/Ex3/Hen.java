package edu.uoc.pac4;

import java.util.Random;

/**
 * This class represents a hen. Son of herbivore and get egglayer
 * @author Guille
 * @version 1.0
 * PEC4 Ex2
 */
public class Hen extends Omnivore implements EggLayer
{
	/**
	 * Default Constructor
	 * @throws AnimalException
	 */
	public Hen() throws AnimalException
	{
		super();
	}

	//Parameters Constructor
	public Hen(String name, int yearBirth, double weight) throws AnimalException 
	{
		super(name, yearBirth, weight, Gender.FEMALE);
	}

	/**
	 * Gender Setter. Always Female
	 */
	@Override
	public void setGender(Gender gender) 
	{
		super.setGender(Gender.FEMALE);
	}

	/**
	 * Lay Method
	 */
	@Override
	public boolean lay() 
	{
		Random rand = new Random();
		float random = rand.nextFloat();
		
		if(random > 0.5)
			return true;
		else
			return false;
	}
	
	/**
	 * Noise Method
	 */
	@Override
	public void makeNoise() 
	{
		System.out.println("Co-co-co!!!");
	}
	
	/**
	 * To String method. No complications here
	 */
	@Override
	public String toString() 
	{
		return super.toString() + "\nI'm a hen."; 
	}
}
