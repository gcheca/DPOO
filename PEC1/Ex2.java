package edu.uoc.pac1.ex2;

import java.util.Scanner;

public class PAC1Ex2 {

	public static void main(String[] args) {
		double income, incomeTax, pensionContribution;
		
		System.out.print("Write your annual income: ");
		Scanner input = new Scanner(System.in);
		
		income = input.nextDouble();
		
		incomeTax = incomeTaxPayable(income);
		pensionContribution = pensionContribution(income/14);
		
		System.out.printf("\nThe income tax payable is: %.2f €",incomeTax);
		System.out.printf("\nThe pension contribution is: %f €",pensionContribution);
		
		input.close();
	}
	
	public static double incomeTaxPayable(double income)
	{	//TODO
		
		double taxPayable;

		if (income < 20000) taxPayable = 0;
		else if (income >= 20000 && income < 40000) 
		{
			//If more than 20K but less than 40K, wage is 10percent
			income = income - 20000;
			taxPayable = (income * 10) / 100;
		}
		else if (income >= 40000 && income < 60000) 
		{
			//The same but resting the first 40k and adding the maximum taxes for that section
			income = income - 40000;
			taxPayable = ( ((20000 * 10)/100) + ((income * 20) /100) );
		}
		else
		{
			//last section. Resting the first 60k and after adding the maximum taxes for 1st'n'2nd sections
			income = income - 60000;
			taxPayable = ( ((20000 * 10)/100) + ((20000 * 20)/100) + ((income * 30) /100) );
		}
		return taxPayable;
	}
	
	public static double pensionContribution(double salary) 
	{				
		double pension,tax,contribution,n;
		int forN;
		
		contribution = 0;
		pension = 0;
		tax = 0;
		
		//forN is truncated N. It´s the times we repeat the iteration to get n value
		forN = 0;
		n = salary/200;
		forN = (int)n;
		
		//Repeat it forN times and cumulative contribution and taxes
		for (int i = 0; i < forN; i++)
		{
			pension = salary * tax;
			contribution = contribution + pension;
			tax = (tax + 0.01);
		}
		return contribution;
	}
}
