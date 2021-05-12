package edu.uoc.pac4;

import java.util.Set;
import java.util.TreeSet;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

public class Enclosure 
{
	private String name;
	private int size;
	private Set<Animal> animals;
	
	public Enclosure(String name, int size)
	{
		this.animals = new TreeSet <Animal>();
		setName(name);
		setSize(size);
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public int getSize()
	{
		return size;
	}
	
	public void setSize(int size) throws IllegalArgumentException
	{
		if (size <= 0) {
			throw new IllegalArgumentException("[ERROR] Enclosure's size cannot be 0 or a negative value!!");
		}else if ( size > 0 && size < animals.size()) {
			throw new IllegalArgumentException("[ERROR] Enclosure's size ("+size+") cannot be less than the number of animals ("+animals.size()+") that are in the enclosure!!");
		}
		this.size = size;
	}
	
	public boolean add(Animal animal) throws NullPointerException 
	{
		boolean isAdded = false;
		if (animal != null) 
		{
			if (animals.size() < size) 
			{
				if (!exists(animal)) 
				{
					 if (animal.getEnclosure()!= null) 
					 {
						animal.getEnclosure().remove(animal);
					 }
					animals.add(animal);
					animal.setEnclosure(this);
					isAdded = true;
				}
			}
		} 
		else 
		{
			throw new NullPointerException("[ERROR] Animal object cannot be null!!");
		}
			return isAdded;
	}
	
	public boolean remove (Animal animal) 
	{
		boolean remove = false;
			animals.remove(animal);
			remove = true;
			animal.setEnclosure(null);
		
		return remove;
	}
	
	public void remove() 
	{
		Iterator<Animal> iterator = this.animals.iterator();
		while (iterator.hasNext())
		{
			remove((Animal)iterator);
		}
		animals.clear();
	}

	public boolean exists (Animal animal) 
	{
		boolean exists;
		exists = animals.contains(animal);
		return exists;
	}
	
	public List<Animal> getAnimals()
	{
		ArrayList<Animal> list = new ArrayList<Animal> ();
		list.addAll(animals);
		return list;
	}
	
	public boolean isEmpty() 
	{
		boolean empty = false;
		if(animals.isEmpty()==true) {
			empty = true;
		}
		return empty;
	}

	@Override
	public String toString() 
	{
		return "Enclosure "+getName()+" with"+getSize()+" m2";
	}	
}
