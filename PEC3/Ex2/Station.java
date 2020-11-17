package edu.uoc.pac3;

/**
 * This Class represents a Station Class
 * @author gcheca
 * @version 1.1
 * PAC3 Ex2
 * Test to check everything's ok
 */
public class Station 
{
	private int id;

	private static int nextId  = 0;

	private String name;

	private int capacity;

	private Address address;

	private Bike[]bikes;
	
	public Station() throws Exception
	{
		this("Default","Sesame Street",0,0,24);
		bikes = new Bike[24];
	}

	public Station(String name, String street, double latitude, double longitude,  int capacity) throws Exception
	{
		setName(name);
		setAddress(street,latitude,longitude);
		bikes = new Bike[capacity];
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
	
	public Bike[]getBikes()
	{
		return bikes;
	}
	
	public boolean isFull()
	{
		int i;
		for(i = 0; i < bikes.length; i++)
		{
			if(bikes[i] == null)
			{
				return false;
			}
		}
		return true;
	}

	public boolean isEmpty()
	{
		int i;
		for(i = 0; i < bikes.length; i++)
		{
			if(bikes[i] != null)
			{
				return false;
			}
		}
		return true;
	}
	
	public int getFirstFreeParkingLot()
	{
		int i;
		int aux = -1;
		
		if(!isFull())
		{
			for(i = 0; i < bikes.length;i++)
			{
				if(bikes[i] == null)
				{
					aux = i;
					break;
				}
			}
		}
		return aux;
	}
	
	public int getNumFreeParkingLots()
	{
		int i;
		int aux = 0;
		
		for(i = 0; i < bikes.length; i++)
		{
			if(bikes[i] == null)
			{
				aux++;
			}
		}
		return aux;
	}
	
	public int getParkingLotByBike(Bike bike) 
	{
		int i;
		int position = -1;
		for (i = 0; i < bikes.length; i++) 
		{
			if (bikes[i]==bike)
			{
				position=i;
				break;
			}
		}
		return position;
	}
	
	public void addBike(Bike bike) throws Exception
	{
		if(bike != null)
		{
			if(getParkingLotByBike(bike) == -1 )
			{
				if(!isFull())
				{
					if(bike.station != null)
					{
						bike.getStation().removeBike(bike);
						bikes[getFirstFreeParkingLot()] = bike;
					}
					else
					{
						bikes[getFirstFreeParkingLot()] = bike;
					}
				}
				else
				{
					throw new Exception ("[ERROR] This station is full");
				}
			}
			else 
			{
				throw new Exception ("[ERROR] This bike is already in this station");
			}
		}
		else
		{
			throw new Exception("[ERROR] The bike cannot be null");
		}
		bike.setStation(this);
	}

	public void removeBike(Bike bike) throws Exception
	{
		if(getParkingLotByBike(bike) != -1)
		{
			bikes[getParkingLotByBike(bike)] = null;
			bike.setStation(null);
		}
		else
		{
			throw new Exception ("[ERROR] This bike does not exist in this station");
		}
	}
}
