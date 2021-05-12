package edu.uoc.pac4;

/**
 * This Class represents Food
 * @author Guille
 * @version 1.0
 * PEC4 Ex2
 */
public class Food 
{
	/**
	 * MSG_ERR_FOOD when food does not give Kcal's
	 */
	private static final String MSG_ERR_FOOD = "[ERROR] Food's kcal cannot be negative!!";
	
	/**
	 * Food's type
	 */
	private FoodType foodType;

	/**
	 * Food's name
	 */
	private String name;
	
	/**
	 * Foods energy. Measured by kcals
	 */
	private int kcal = 0;
	
	/**
	 * Default constructor
	 * @throws IllegalArgumentException
	 */
	public Food() throws IllegalArgumentException
	{
		this.kcal = 0;
	}
	
	/**
	 * Params Constructor
	 * @param name
	 * @param kcal
	 * @param foodType
	 * @throws IllegalArgumentException
	 */
	public Food(String name, int kcal,FoodType foodType) throws IllegalArgumentException
	{
		this.name = name;
		if(kcal < 0)
		{
			throw new IllegalArgumentException(MSG_ERR_FOOD);
		}
		else
		{
			this.kcal = kcal;
		}
		this.foodType = foodType;
	}
	
	/**
	 * Food's name getter
	 * @return name
	 */
	public String getName() 
	{
		return name;
	}
	
	/**
	 * Food's name setter
	 * @param name
	 */
	public void setName(String name) 
	{
		this.name = name;
	}
	
	/**
	 * Food's getter kcal
	 * @return kcal
	 */
	public int getKcal() 
	{
		return kcal;
	}
	
	/**
	 * Food's setter kcal
	 * @param kcal
	 * @throws IllegalArgumentException
	 */
	public void setKcal(int kcal) throws IllegalArgumentException
	{
		if(kcal < 0)
		{
			throw new IllegalArgumentException(MSG_ERR_FOOD);
		}
		else
		{
			this.kcal = kcal;
		}
	}
	
	/**
	 * Food's type getter
	 * @return type
	 */
	public FoodType getType() 
	{
		return foodType;
	}
	
	/**
	 * Food's type setter
	 * @param foodType
	 */
	public void setType(FoodType foodType) 
	{
		this.foodType = foodType;
	}
	
	/**
	 * toString Method
	 */
	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		
		if(this.foodType == FoodType.PLANT)
		{
			sb.append(this.name+" (PLANT): "+this.kcal+" kcal");
		}
		else
		{
			sb.append(this.name+" (MEAT): "+this.kcal+" kcal");
		}
		return sb.toString();
	}
}
