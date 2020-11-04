package edu.uoc.pac2;
/**
 * This Class represents a Station Class
 * @author Guille Checa
 * @version 1.0
 */
public class Station 
{
	/**
	 * Station class
	 */
	
	/**
	 * Station's id, e.g. 14
	 */
	private int id;
	/**
	 * Station's nextId, e.g. 15
	 */
	static int nextId; 	
	/**
	 * Station's name, e.g. Default
	 */
	private String name;
	/**
	 * Station's street, e.g. Sesame Street
	 */
	private String street;
	/**
	 * Station's latitude, e.g. 0
	 */
	private double latitude;	
	/**
	 * Station's longitude, e.g. 0
	 */
	private double longitude;
	/**
	 * Station's capacity, e.g. 24
	 */
	private int capacity;
	
	/**
	 * 
	 * @throws Exception When default, Sesame, 0, 0, 24
	 */
	//Default constuctor
	public Station() throws Exception
	{
		this("Default","Sesame Street",0,0,24);
		//setId(id);
	}

	/**
	 * @param name Station's name
	 * @param street Station's street
	 * @param latitude Station's latitude
	 * @param longitude Station's longitude
	 * @param capacity Station's capacity
	 * @throws Exception When name, street, latitude, longitude, capacity
	 */
	//Args constructor 1
	public Station(String name, String street, double latitude, double longitude, int capacity) throws Exception
	{
		setName(name);
		setStreet(street);
		setLatitude(latitude);
		setLongitude(longitude);
		setCapacity(capacity);
		setId(nextId);
	}

	//Getters´&´Setters

	/**
	 * 
	 * @return id
	 */
	public int getId() 
	{
		return id;
	}

	/**
	 * 
	 * @param id Station's id
	 */
	public void setId(int id) 
	{
		this.id = Station.nextId;
		incNextId();
	}

	/**
	 * nextId = nextId + 1
	 */
	private void incNextId()
	{
		nextId++;
	}

	/**
	 * 
	 * @return nextId
	 */
	public static int getNextId()
	{
		return nextId;
	}
	
	/**
	 * @param nextId Station's id++ or nextId
	 */
	public void setNextId(int nextId)
	{
		Station.nextId = nextId;
	}
	
	/**
	 * @return name
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * @param name Station's name
	 * @throws Exception When param "name" is longer than 50 characters
	 */
	public void setName(String name) throws Exception
	{
		if (name.length() > 50) 
		{
			throw new Exception("[ERROR] Station's name cannot be longer than 50 characters");
		} else
		{
			this.name = name;
		}
	}
	
	/**
	 * 
	 * @return street
	 */
	public String getStreet() 
	{
		return street;
	}

	/**
	 * 
	 * @param street Station's street
	 */
	public void setStreet(String street) 
	{
		this.street = street;
	}

	/**
	 * 
	 * @return latitude
	 */
	public double getLatitude() 
	{
		return latitude;
	}

	/**
	 * 
	 * @param latitude Station's latitude
	 * @throws Exception When Station's latitude not in range [-90,+90]
	 */
	public void setLatitude(double latitude) throws Exception
	{
		if (latitude < -90 || latitude > 90) 
		{
			throw new Exception("[ERROR] Station's latitude must be in range [-90,+90]");
		} else
			this.latitude = latitude;		
	}

	/**
	 * 
	 * @return longitude
	 */
	public double getLongitude() 
	{
		return longitude;
	}

	/**
	 * 
	 * @param longitude Station's longitude
	 * @throws Exception When Station's longitude not in range [-180,+180]
	 */
	public void setLongitude(double longitude) throws Exception
	{
		if (longitude < -180 || longitude > 180 )
		{
			throw new Exception("[ERROR] Station's longitude must be in range [-180,+180]");
		}
		else
		{
				this.longitude = longitude;
		}
	}

	/**
	 * 
	 * @return capacity
	 */
	public int getCapacity() 
	{
		return capacity;
	}

	/**
	 * 
	 * @param capacity Station's 
	 * @throws Exception When Station's capacity less than 1
	 */
	public void setCapacity(int capacity) throws Exception
	{
		if (capacity < 1 )
		{
			throw new Exception("[ERROR] Station's capacity must be greater than 0");
		}
		else
		{
			this.capacity = capacity;
		}
	}
}
