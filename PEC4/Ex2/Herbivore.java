package edu.uoc.pac4;

/**
 * This Super Class represents an Herbivore. Son of Animal
 * @author Guille
 * @version 1.0
 * PEC4 EX2
 */
public abstract class Herbivore extends Animal
{
	/**
	 * Constructor by default
	 */
	public Herbivore() 
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
	public Herbivore(String name, int yearBirth, double weight, Gender gender) throws AnimalException 
	{
		super(name, yearBirth, weight, gender);
	}
	
	/**
	 * Eat method
	 * Carnivores EATS MEAT, but herbivores not...
	 * @throws AnimalException when vegans say everyone that they are vegans  (another joke)
	 */
	public void eat(Food food) throws AnimalException
	{
		double energy;
		if(food.getType() == FoodType.PLANT)
		{
			energy = food.getKcal() * 0.1;
			addEnergy(energy);
		}
		else
		{
			throw new AnimalException(AnimalException.MSG_ERR_HERBIVORE_FOOD);
		}
	}
}
