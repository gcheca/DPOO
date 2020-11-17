package edu.uoc.pac3.enums;
/**
 * This Class represents a Direction class
 * @author gcheca
 * Version 1.0
 * PEC3 Ex3
 * Test to check everything's ok
 */
public enum Direction 
{

	RIGHT(0),
	UP(90),
	LEFT(180),
	DOWN(270);

	private int angle;

	private Direction(int angle) 
	{
		this.angle = angle;
	}
	
	public int getAngle() 
	{
		return angle;
	}
	
	@Override
	public String toString() 
	{
		return "You are moving " + this.name();
	}

	public static Direction getDirection(int angle) 
	{   	 
		Direction modRest = null;
		int aux = angle % 360;
		
		if(angle < 0)
		{
			modRest = null;
		}
		else if(aux<=45 || aux > 315)
		{
			modRest = Direction.RIGHT;
		}
		else if(aux <=135)
		{
			modRest = Direction.UP;
		}
		else if(aux <= 255)
		{
			modRest = Direction.LEFT;
		}
		else
		{
			modRest = Direction.DOWN;
		}
		return modRest;		
	}
}
