package edu.uoc.pac4;

/**
 * This Super Class represents an Carnivore. Son of Animal
 * @author Guille
 * @version 1.0
 * PEC4 EX2
 */
public abstract class Carnivore extends Animal
{

	/**
	 * Constructor by default
	 */
	public Carnivore() 
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
	public Carnivore(String name, int yearBirth, double weight, Gender gender) throws AnimalException 
	{
		super(name, yearBirth, weight, gender);
	}


	/**
	 * Eat method
	 * Carnivores EATS MEAT
	 * @throws AnimalException when vegans try to rule the world   (just a joke)
	 */
	public void eat(Food food) throws AnimalException
	{
		double energy;
		if(food.getType() == FoodType.MEAT)
		{
			energy = food.getKcal() * 0.2;
			addEnergy(energy);
		}
		else
		{
			throw new AnimalException(AnimalException.MSG_ERR_CARNIVORE_FOOD);
		}
	}

}
