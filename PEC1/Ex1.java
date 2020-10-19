
public class PAC1Ex1 {

	public static void main(String[] args) 
	{
		/* 96.8 ºF son 36 ºC */ 
		double fahrenheit = 100, celsius;

		celsius = f2c(fahrenheit);
		
		System.out.println(fahrenheit + "ºF = " + celsius +"ºC");
	}
	
	public static double f2c(double f) 
	{
		return (f - 32) * 5 / 9;
	}
}
