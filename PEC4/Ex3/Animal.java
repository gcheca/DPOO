package edu.uoc.pac4;

import java.time.*; 
import java.util.Set;
import java.util.TreeSet;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;


/***
 * This Class Represents an Abstract Super Class Animal
 * @author Guillermo Checa
 * @version 1.2
 * PEC4 EX3
 */
public abstract class Animal implements Comparable<Animal>// extends Enclosure<Animal>

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
	 * Animal's Energy. Assigned by default to 2000
	 */
	private double energy = 80;

	//private Enclosure[] enclosure;
	
	/**
	 * Default constructor
	 * Id = getId
	 * gender = UNDEFINED by default
	 * @throws AnimalException
	 */
	public Animal()
	{
		this.id = this.getId();
		this.setId();
		this.gender = Gender.UNDEFINED;
	}
	
	/**
	 * Parameters Constructor. I try to not call setters here...
	 * @param id
	 * @param name
	 * @param yearBirth
	 * @param weight
	 * @param gender
	 * @throws AnimalException
	 */
	public Animal(String name, int yearBirth, double weight, Gender gender) throws AnimalException
	{
		this.setId();
		
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
		
		//this.gender = Gender.UNDEFINED;
		setGender(gender);
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
		if(yearBirth <= LocalDate.now().getYear())
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
	 * @throws AnimalException when weight is too small
	 */
	public void setWeight(double weight) throws AnimalException
	{
		if(weight >= 0.1)
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
	
	/**
	 * setter of gender
	 * @param gender
	 */
	public void setGender(Gender gender)
	{
		this.gender = gender;
	}
	
	protected void addEnergy(double energy) throws AnimalException
	{
		 if(energy < 0 || energy > 100)
		 {
			 throw new AnimalException(AnimalException.MSG_ERR_ENERGY);
		 }
		 else
		 {
			 if((this.energy + energy) > 100)
			 {
				 this.energy = 100;
			 }
			 else
			 {
				 this.energy  = this.energy + energy;
			 }
		 }
	}
	
	public double getEnergy()
	{
		return this.energy;
	}
	
	public abstract void makeNoise();
	
	public abstract void eat(Food food) throws AnimalException;
		
	/**
	 * Method to check if an animal is the same that other
	 */
	@Override
	public boolean equals(Object object)
	{
		if(object != null)
		{
			Animal animal = (Animal) object;
			
			if(this.name.contains(animal.getName()) &&
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

	@Override
	public int compareTo(Animal animal)
	{
		int aux = 0;
		
		if(this.yearBirth < animal.yearBirth)
		{
			aux = 1;
		}
		else if(this.yearBirth > animal.yearBirth)
		{
			aux = -1;
		}
		else if(this.weight < animal.weight)
		{
			aux = 1;
		}
		else if(this.weight > animal.weight)
		{
			aux = -1;
		}
		return aux;
	}
	
	
	ArrayList<Enclosure> enclosure = new ArrayList<>();

}
