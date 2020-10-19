package edu.uoc.pac1.ex3;

import java.util.Arrays;

public class PAC1Ex3 {

	public static void main(String[] args) 
	{
		int[] vector = {1,2,3,4,5,6};
		
		System.out.println(Arrays.toString(subVector(vector)));
	}
	
	public static int[] subVector(int[] vector) {		
		//TODO
		int[] auxVector;
		//I don´t like to declare here even as false, but it´s the only way to avoid errors at line 42...
		boolean even = false;
		
		//First of all Discard null arrays
		if (vector == null)
		{
			System.out.println("[ERROR] Vector is null!!");
			auxVector = null;
		}
		//Second Discard empty arrays
		else
		{
			if (vector.length == 0)
			{
				auxVector = new int[0];
				return auxVector;
			}
			else
			{
				//Check if 1st position value is even or odd and then initialize the variable auxVector and j as position of the auxiliary array inside of the for´s iterations
				if (vector[0] % 2 == 0)
					even = true;
				else if (vector[0] % 2 != 0)
					even = false;
				
				auxVector = new int[lengthSubVector(vector, even)];
				int j = 0;
				
				if (even == true)
				{
					//Now we add to the new auxiliary array the even values of of other array
					for (int i = 0; i < vector.length;i++)
					{
						if (vector[i] % 2 == 0)
						{
							auxVector[j] = vector[i];
							j++;
						}
					}
				}
				//odd first value, same process than before
				else if (even == false)
				{
					for (int i = 0; i < vector.length;i++)
					{
						if (vector[i] % 2 != 0)
						{
							auxVector[j] = vector[i];
							j++;
						}
					}
				}
			}
		}
		return auxVector;
	}
				
	
	public static int lengthSubVector(int[] vector, boolean even) 
	{
		//TODO
		
		int counter = 0;
		
		//First of all Discard null vectors
		if (vector == null)
		{
			System.out.println("[ERROR] Vector is null!!");
			return counter;
		}
		else
		{	
			//Second discard, if vector have not zero positions
			if (vector.length == 0)
				return counter;
			else
			{
				//See all positions to check if numbers are even or odd
				for (int i = 0;i < vector.length;i++)
				{
					if (even)
					{
						if (vector[i] % 2 == 0)
						{
							counter++;
						}
					}
					else
					{
						if(vector[i] % 2 != 0)
						{
							counter++;
						}
					}
				}
			}
		}
		return counter;	
	}
}
