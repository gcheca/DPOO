package edu.uoc.pac3;

/**
 * This Class represents a Station Class
 * @author gcheca
 * @version 1.1
 * PAC3 Ex1
 * Test to check everything's ok
 */
public class Station 
{
	private Address address;

	private int id;
  
	private static int nextId  = 0;
  
	private String name;
  
	private int capacity;
	
	public Station() throws Exception
	{
		this("Default","Sesame Street",0,0,24);
	}

	public Station(String name, String street, double latitude, double longitude,  int capacity) throws Exception
	{
		setName(name);
		setAddress(street,latitude,longitude);
		//setStreet(street);
		//setLatitude(latitude);
		//setLongitude(longitude);
		setCapacity(capacity);
		setId();
	}

	public int getId() 
	{
		return id;
	}

	private void setId() 
	{
		this.id = getNextId();
		incNextId();
	}

	public static int getNextId() 
	{
		return nextId;
	}
	
	private void incNextId()
	{
		nextId++;
	}

	public String getName() 
	{
		return name;
	}

	public void setName(String name) throws Exception
	{
		if(name.length()>50) 
		{
			throw new Exception("[ERROR] Station's name cannot be longer than 50 characters");
		}else 
		{
			this.name = name;
		}
	}
	
	public Address getAddress()
	{
		return address;
	}

	public void setAddress(String street, double latitude, double longitude) throws Exception
	{
		address = new Address(street, latitude, longitude);
	}
	
	
	public int getCapacity() 
	{
		return capacity;
	}
  
	public void setCapacity(int capacity) throws Exception
	{
		if(capacity<1) 
		{
			throw new Exception("[ERROR] Station's capacity must be greater than 0");
		}else 
		{
			this.capacity = capacity;
		}
	}
}
