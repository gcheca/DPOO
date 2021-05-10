package edu.uoc.pac4;

/**
 * This Super Class represents an Omnivore. Son of Animal
 * @author Guille
 * @version 1.0
 * PEC4 EX2
 */
public abstract class Omnivore extends Animal
{

	/**
	 * Constructor by default
	 */
	public Omnivore() throws AnimalException
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
	public Omnivore(String name, int yearBirth, double weight, Gender gender) throws AnimalException 
	{
		super(name, yearBirth, weight, gender);
	}

	
	/**
	 * Eat method
	 * Carnivores EATS MEAT, but herbivores not,  omnivores eats both...
	 * @throws AnimalException when they didn´t eat nothing or it gives no energy (the getkcal function)  (not joke here. Animals needs energy...)
	 */
	public void eat(Food food) throws AnimalException
	{
		double energy;
		if(food.getType() == FoodType.PLANT)
		{
			energy = food.getKcal() * 0.05;
			addEnergy(energy);
		}
		else if(food.getType() == FoodType.MEAT)
		{
			energy = food.getKcal() * 0.15;
			addEnergy(energy);
		}
	}
}
