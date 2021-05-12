package edu.uoc.pac4;

/**
 * This Interface represents a milkable
 * @author Guille
 * @version 1.0
 * PEC4 EX2
 */
public interface Milkable 
{
	/**
	 * Static MAX_DIM to 300
	 */
	public static int MAX_DIM = 300;
	/**
	 * MSG_ERR_NO_MILK when animal not pregnant
	 */
	public static final String MSG_ERR_NO_MILK = "[ERROR] This animal is not pregnant, so it cannot give milk.";
	/**
	 * MSG_ERR_DAYS_IN_MILK_NEGATIVE when days are in negative
	 */
	public static final String MSG_ERR_DAYS_IN_MILK_NEGATIVE = "[ERROR] Days in milk cannot be negative value!!";
	/**
	 * MSG_ERR_DAYS_IN_MILK_GREATER when days in milk greater than 300
	 */
	public static final String MSG_ERR_DAYS_IN_MILK_GREATER = "[ERROR] Days in milk cannot be greater than "+MAX_DIM+"!!";
	/**
	 * MSG_ERR_MAX_LITERS_PER_DAYS_NEGATIVE when max liters of milk are in negative
	 */
	public static final String MSG_ERR_MAX_LITERS_PER_DAYS_NEGATIVE = "[ERROR] Max. liters of milk per day cannot be a negative value!!";

	/**
	 * Abstract getter daysInMilk
	 * @return daysInMilk
	 */
	public abstract int getDaysInMilk();
	/**
	 * Abstract setter daysInMilk
	 * @param dim
	 */
	public abstract void setDaysInMilk(int dim);
	
	/**
	 * Abstract getter PeakMilk
	 * @return getPeakMilk
	 */
	public abstract int getPeakMilk();
	/**
	 * Abstract setter MaxMilkPerDay
	 * @param maxMilkPerDay
	 */
	public abstract void setMaxMilkPerDay(int maxMilkPerDay);
	/**
	 * Abstract getter MaxMilkPerDay
	 * @return MaxMilkPerDay
	 */
	public abstract int getMaxMilkPerDay();
	
	/**
	 * Default method Milk
	 * @return Milk Production
	 * @throws AnimalException when no milk can be given
	 */
	
	public default double milk() throws AnimalException
	{
		double milkProduction;
				
		if(getDaysInMilk() >= MAX_DIM)
		{
			throw new AnimalException(Milkable.MSG_ERR_NO_MILK);
		}
		else
		{
			if(getDaysInMilk() <= getPeakMilk())
			{
				
				milkProduction = (Math.random() * (getMaxMilkPerDay() - getMaxMilkPerDay() * 0.75)) + (getMaxMilkPerDay() * 0.75);
			}
			else
			{
				milkProduction = (Math.random() * (getMaxMilkPerDay() * 0.5));
	 		}
			
			setDaysInMilk(getDaysInMilk() + 1);
		}
		return milkProduction;
	}
	
	/**
	 * Default getter of DaysLeftInMilk
	 * @return Max_DIM less Days in Milk
	 */
	public default int getDaysLeftInMilk()
	{
		return MAX_DIM - getDaysInMilk();
	}
}