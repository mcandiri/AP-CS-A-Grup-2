package Grup1;

public class Lesson5 {

	public static void main(String[] args) {

		// ---- CONTROL STRUCTURES ----  (if) 
		
		/*
		 * 			if (condition (-boolean-))
		 * 			{
		 * 						action 
		 *          }
		 *          else if(condition2)
		 *          {
		 *          			action2
		 *          }
		 * 			else
		 * 			{
		 * 						action3 
		 * 			}
		 * 
		 * 
		 * 
		 * 
		 */
		int number = 6 ;
		
		if(number % 2 == 0) 
		{
			System.out.println("Even number!");
		}
		else
		{
			System.out.println("Odd number!");
		}
		
		
		if(number > 0) 
			System.out.println("Positive");
			System.out.println("Positive!"); ///
		
		if(number > 0) 
		{
			System.out.println("Positive");
			System.out.println("Positive!"); 
		}
		
		
		if(number > 0) {
			System.out.println("Positive");
		}
		else {
			System.out.println("Not Positive");
		}
		
		number = 1 ;
		if(number > 0) {
			System.out.println("Positive");
		}
		else {
			if(number < 0) {
				System.out.println("Negative");
			}
			else {
				System.out.println("Zero");
			}
		}
	
		if(number > 0) {
			System.out.println("Positive");
		}
		else if(number < 0) {
			System.out.println("Negative");
		}
		else {
			System.out.println("Zero");
		}
		
	}

}
