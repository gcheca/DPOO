package edu.uoc.pac4;

//
import java.time.*;

/***
 * This Class Represents an Animal
 * @author Guillermo Checa
 * @version 1.0
 * PEC4 EX1
 */
public class Animal
{
	/**
	 * Animal's id
	 */
	private int id;
	/**
	 * Animal's next ID. Useful to create uniques ids
	 */
	public static int nextId  = 0;
	/**
	 * Animal's name. Assigned by default to Foo. To set it to a different value later
	 */
	private String name = "Foo";
	/**
	 * Animal's weight. Assigned by default to 0.1. To set it to a different value later
	 */
	private double weight = 0.1;
	/**
	 * Animal's gender. Assigned by default to UNDEFINED. To set it to a different value later
	 */
	private Gender gender = Gender.UNDEFINED;
	/**
	 * Animal's year birth. Assigned by default to 2000. To set it to a different value later
	 */
	private int yearBirth = 2000;
	
	
	/**
	 * Default constructor
	 * Id = getId
	 * gender = UNDEFINED by default
	 * @throws AnimalException
	 */
	public Animal() throws AnimalException
	{
		this.id = this.getId();
		this.setId();
		this.gender = Gender.UNDEFINED;
	}
	
	/**
	 * Parameters Constructor. I try to not call setters here...
	 * @param name
	 * @param yearBirth
	 * @param weight
	 * @param gender
	 * @throws AnimalException
	 */
	public Animal(String name, int yearBirth, double weight, Gender gender) throws AnimalException
	{
		this.name = name;
		
		if(yearBirth <= LocalDate.now().getYear())
		{
			this.yearBirth = yearBirth;
		}
		else
		{
			throw new AnimalException(AnimalException.MSG_ERR_YEAR_BIRTH);
		}
		
		if(weight >= 0.1)
		{
			this.weight = weight;
		}
		else
		{
			throw new AnimalException(AnimalException.MSG_ERR_WEIGHT);
		}
		
		this.gender = Gender.UNDEFINED;
	}
	
	/**
	 * Getter of "id"
	 * @return Value of the field "id"
	 */
	public int getId() 
	{
		return id;
	}
	
	/**
	 * Setter of "id". It assigns "nextId" value to "id" and increases it
	 */
	private void setId() 
	{
		this.id = nextId;
		nextId++;
	}
	
	/**
	 * Getter of "name"
	 * @return Animal's name
	 */
	public String getName() 
	{
		return this.name;
	}
	
	/**
	 * Setter of name
	 * @param name
	 */
	public void setName(String name)
	{
		this.name = name;
	}
	
	/**
	 * Getter of Yearbirth
	 * @return Animal's Yearbirth
	 */
	public int getYearBirth()
	{
		return this.yearBirth;
	}
	
	/**
	 * Getter of Yearbirth 
	 * @param yearBirth
	 * @throws AnimalException if year is later than this year
	 */
	public void setYearBirth(int yearBirth) throws AnimalException
	{
		int currentYear = LocalDate.now().getYear();
		
		if(yearBirth <= currentYear)
		{
			this.yearBirth = yearBirth;
		}
		else
		{
			throw new AnimalException(AnimalException.MSG_ERR_YEAR_BIRTH);
		}
	}
	
	/**
	 * getter of Weight
	 * @return weight
	 */
	public double getWeight()
	{
		return this.weight;	
	}
	
	/**
	 * setter of weight
	 * @param weight
	 * @throws AnimalException
	 */
	public void setWeight(double weight) throws AnimalException
	{
		if(weight >= 0.1 || weight  == 0.1)
		{
			this.weight = weight;
		}
		else
		{
			throw new AnimalException(AnimalException.MSG_ERR_WEIGHT);
		}
	}
	
	/**
	 * getter of gender
	 * @return gender
	 */
	public Gender getGender()
	{
		return this.gender;
	}
	
	public void setGender(Gender gender)
	{
		this.gender = gender;
	}
	
	/**
	 * Method to check if an animal is the same that other
	 */
	@Override
	public boolean equals(Object object)
	{
		if(object != null)
		{
			Animal animal = (Animal) object;
			
			if(this == animal || this.name.contains(animal.getName()) &&
					this.yearBirth == animal.getYearBirth() &&
					this.weight == animal.getWeight() &&
					this.gender == animal.getGender())
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		else
		{
			return false;
		}
	}
	
	
	/**
	 * toString method. It give us a toString. I try on this class an alternative, StringBuilder... It works!
	 */
	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		
		sb.append("My name is "+ this.name + " and I'm "+ String.valueOf(LocalDate.now().getYear() - this.getYearBirth())+ " years old.\n");
		
		if(this.getGender() == Gender.MALE)
		{
			sb.append("My gender is MALE and my weight is " + String.valueOf(this.weight) + " "+ "kg.");
		}
		else if(this.getGender() == Gender.FEMALE)
		{
			sb.append("My gender is FEMALE and my weight is " + String.valueOf(this.weight) + " "+ "kg.");
		}
		else
		{
			sb.append("My gender is UNDEFINED and my weight is " + String.valueOf(this.weight) + " "+ "kg.");
		}		
		return sb.toString();
	}
}
