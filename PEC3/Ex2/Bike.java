package edu.uoc.pac3;

import java.time.*;

/**
 * This Class represents a Bike Class
 * @author gcheca
 * Version 1.0
 * PEC3 Ex2
 * Test to check everything's ok
 */

public class Bike 
{
	private int id;

	private static int nextId;

	private LocalDate lastReparation = null;

	Station station = null;
	
	public Bike() throws Exception
	{
		this.lastReparation = null;
		this.station = null;
		setId();
	}
	
	public Bike(LocalDate lastReparation, Station station) throws Exception
	{
		setLastReparation(lastReparation = null);
		setStation(station);
		setId();
	}
	
	public int getId()
	{
		return id;
	}
	
	public void setId()
	{
		this.id = getNextId();
		incNextId();
	}
	
	public static int getNextId()
	{
		return nextId;
	}
	
	//idk if this is setter is needed, or useful. Maybe it could be deleted
	/*public void setNextId(int nextId)
	{
		this.nextId = nextId;
	}*/
	
	private void incNextId()
	{
		nextId++;
	}
	
	public LocalDate getLastReparation()
	{
		return lastReparation;
	}
	
	public void setLastReparation(LocalDate lastReparation) throws Exception
	{
		if(lastReparation.isBefore(LocalDate.now()) || lastReparation.equals(LocalDate.now()))
		{
			this.lastReparation = lastReparation;
		}
		else
		{
			throw new Exception("[ERROR] Bike's reparation date cannot be greater than today");
		}	
	}
	
	public Station getStation()
	{
		return station;
	}
	
	public void setStation(Station station) throws Exception
	{
		if(station != null)
		{
			if(station.getParkingLotByBike(this) == -1)
			{
				station.addBike(this);
				this.station = station;
			}
			else
			{
				this.station = station;
			}
		}
		else if(this.station != null && this.station.getParkingLotByBike(this) != -1)
		{
			this.station.removeBike(this);
		}
		this.station = station;
	}
}
