package edu.uoc.pac4;

/**
 * This Class represents a cow, son of herbivore and gets milkable
 * @author Guille
 * @version 1.0
 * PEC4 Ex2
 */
public class Cow extends Herbivore implements Milkable
{
	/**
	 * Static PEAK MILK to 90
	 */
	private static int PEAK_MILK = 90;
	
	/**
	 * Cow's Days in Milk to 0
	 */
	private int dim = 0;
	
	/**
	 * Cow's MaxMilkPerDay to 35
	 */
	private int maxMilkPerDay = 35;

	/**
	 * COnstructor by default
	 * @param name
	 * @param yearBirth
	 * @param weight
	 * @throws AnimalException
	 */
	public Cow(String name, int yearBirth, double weight) throws AnimalException 
	{
		super(name, yearBirth, weight, Gender.FEMALE);
		this.dim = 0;
		this.maxMilkPerDay = 35;
	}

	/**
	 * Constructor by parameters
	 * @param name
	 * @param yearBirth
	 * @param weight
	 * @param gender
	 * @param dim
	 * @param maxMilkPerDay
	 * @throws AnimalException
	 */
	public Cow(String name, int yearBirth, double weight, Gender gender, int dim, int maxMilkPerDay) throws AnimalException 
	{
		super(name, yearBirth, weight, Gender.FEMALE);
		setDaysInMilk(dim);
		this.maxMilkPerDay = maxMilkPerDay;
	}
	
	/**
	 * PeakMilk getter
	 */
	@Override
	public int getPeakMilk() 
	{
		return PEAK_MILK;
	}
	
	/**
	 * days in milk getter
	 */
	@Override
	public int getDaysInMilk() 
	{
		return dim;
	}

	/**
	 * days in milk setter
	 */
	//@Override
	public void setDaysInMilk(int dim) 
	{
		if(dim < 0)
		{
			throw new IllegalArgumentException(Milkable.MSG_ERR_DAYS_IN_MILK_NEGATIVE);
		}
		else if(dim > Milkable.MAX_DIM)
		{
			throw new IllegalArgumentException(Milkable.MSG_ERR_DAYS_IN_MILK_GREATER);
		}
		else 
		{
			this.dim = dim;
		}
	}
	
	/**
	 * maxmilkperday getter
	 */
	@Override
	public int getMaxMilkPerDay() 
	{
		return maxMilkPerDay;
	}

	/**
	 * maxmilkperday setter
	 */
	@Override
	public void setMaxMilkPerDay(int maxMilkPerDay) 
	{
		if(maxMilkPerDay < 0)
		{
			throw new IllegalArgumentException(Milkable.MSG_ERR_MAX_LITERS_PER_DAYS_NEGATIVE);
		}
		this.maxMilkPerDay = maxMilkPerDay;
	}
	
	/**
	 * Noise method
	 */
	@Override
	public void makeNoise()
	{
		System.out.println("Muuuuuu!!!");
	}

	/**
	 * OTHER noise method
	 * @param times
	 */
	public void makeNoise(int times)
	{
		for(int i = 0; i < times;i++)
		{
			System.out.println("Muuuuuu!!!");
		}
	}
	
	/**
	 * Gender Setter. Cow's always female. Cows != Bulls
	 */
	@Override
	public void setGender(Gender gender) 
	{
		super.setGender(Gender.FEMALE);
	}

	/**
	 * toString Method
	 */
	@Override
	public String toString() 
	{
		return super.toString() + "\nI'm a cow.";
	}
}
