package edu.uoc.pac4;


import java.time.LocalDate;
import java.util.Random;

/**
 * This Class represents a Komodo Dragon. Son of Carnivore and gets EggLayer
 * @author Guille
 * @version 1.0
 * PEC4 Ex2
 */
public class KomodoDragon extends Carnivore implements EggLayer
{
	/**
	 * Default Constructor
	 */
	public KomodoDragon()
	{
		super();
	}
	/**
	 * Constructor by params
	 * @param name
	 * @param yearBirth
	 * @param weight
	 * @param gender
	 * @throws AnimalException
	 */
	public KomodoDragon(String name, int yearBirth, double weight, Gender gender) throws AnimalException 
	{
		super(name, yearBirth, weight, gender);
	}

	/**
	 * Lay method
	 */
	@Override
	public boolean lay() 
	{
		Random rand = new Random();
		float random = rand.nextFloat();
		
		if(random > 0.8)
			return true;
		else
			return false;
	}
	
	/**
	 * Noise method
	 */
	@Override
	public void makeNoise() 
	{
		System.out.println("Grrrrr!!!");
	}
	
	/**
	 * toString Method. I try here again the String builder stuff
	 */
	@Override
	public String toString() 
	{
		StringBuilder sb = new StringBuilder();
				
		sb.append("My name is "+ this.getName() + " and I'm "+ String.valueOf(LocalDate.now().getYear() - this.getYearBirth())+ " years old.\n");
		if(this.getGender() == Gender.MALE)
		{
			sb.append("My gender is MALE and my weight is " + String.valueOf(this.getWeight()) + " "+ "kg.");
		}
		else if(this.getGender() == Gender.FEMALE)
		{
			sb.append("My gender is FEMALE and my weight is " + String.valueOf(this.getWeight()) + " "+ "kg.");
		}
		else if(this.getGender() == Gender.UNDEFINED)
		{
			sb.append("My gender is UNDEFINED and my weight is " + String.valueOf(this.getWeight()) + " "+ "kg.");
		}
		
		sb.append("\nI'm a Komodo dragon.");
		
		return sb.toString();
	}
}
