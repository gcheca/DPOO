package edu.uoc.pac2;

public class Station 
{
	private int id;
	static int nextId; 	
	private String name;
	private String street;
	private double latitude;
	private double longitude;
	private int capacity;
	
	//Default constuctor
	public Station()
	{
		this("Default","Sesame Street",0,0,24);
		//setId(id);
	}

	//Args constructor 1
	public Station(String name, String street, double latitude, double longitude, int capacity)
	{
		setName(name);
		setStreet(street);
		setLatitude(latitude);
		setLongitude(longitude);
		setCapacity(capacity);
		setId(nextId);
	}

	//Getters´&´Setters

	public int getId() 
	{
		return id;
	}

	public void setId(int id) 
	{
		this.id = Station.nextId;
		incNextId();
	}

	private void incNextId()
	{
		nextId++;
	}

	public static int getNextId()
	{
		return nextId;
	}

	public void setNextId(int nexId)
	{
		Station.nextId = nextId;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name) 
	{
		if (name.length() > 50)
		{
			System.out.println("[ERROR] Station's name cannot be longer than 50 characters");
		} else
		{
			this.name = name;
		}
	}

	public String getStreet() 
	{
		return street;
	}

	public void setStreet(String street) 
	{
		this.street = street;
	}

	public double getLatitude() 
	{
		return latitude;
	}

	public void setLatitude(double latitude) 
	{
		if (latitude < -90 || latitude > 90)
		{
			System.out.println("[ERROR] Station's latitude must be in range [-90,+90]");
		} else
			this.latitude = latitude;		
	}

	public double getLongitude() 
	{
		return longitude;
	}

	public void setLongitude(double longitude) 
	{
		if (longitude < -180 || longitude > 180 )
		{
			System.out.println("[ERROR] Station's longitude must be in range [-180,+180]");
		}
		else
		{
				this.longitude = longitude;
		}
	}

	public int getCapacity() 
	{
		return capacity;
	}

	public void setCapacity(int capacity) 
	{
		if (capacity <= 0 )
		{
			System.out.println("[ERROR] Station's capacity must be greater than 0");
		}
		else
		{
			this.capacity = capacity;
		}
	}
}
