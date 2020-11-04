package edu.uoc.pac2.strings;

public class PAC2Ex4 {

	public String reverseText(String text) 
	{
		// If no text, return nothing. If text, reverse it and tostring
		if (text == null)
			return null;
		String reverseText = new StringBuffer(text).reverse().toString();
		return reverseText;
	}
	
	public int countM(String text) 
	{
		// Counter as aux variable and integer for the while
		int counter = 0;
		int i = 0;
		
		// If no text, return nothing. If text, count m and M characters
		if (text != null)
		{
			while (i < text.length())
			{
				if(text.charAt(i) == 'm' || text.charAt(i) == 'M')
					counter++; i++;
			}
		}
		return counter;
	}
	
	public String capitalize(String text, int index) 
	{		
		// If no text return nothing. If text, return it with mods depends of index
		if (text != null)
		{
			if (index <= 0)
				return text;
			
			// If index greater, text to upper
			else if (index >= text.length())
				return text.toUpperCase();
			
			else
			{
				//declare new char variables and return modified text
				String charsUpper = text.substring(0, index);
				String charOriginal = text.substring(index, text.length());
				String textOut = charsUpper.toUpperCase();
				return textOut+charOriginal;
			}
		} else 
		{
			return null;
		}
	}
}
