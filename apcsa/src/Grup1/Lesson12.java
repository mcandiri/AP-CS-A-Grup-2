package Grup1;

public class Lesson12 {

	public static void main(String[] args) {
	int number = 5 ;
		/*	
		int k = 0 ; 
		while( k < 3)
		{
			///////
			k++;
		}
		System.out.println("End of the while loop, k= " + k );
	*/
		int i ;  // int i = 0 
		for(i=0 ; i < 3 ; i++) 
			System.out.println("i= " + i);
		
		 System.out.println("End of the for loop, i= " + i ); // i cannot be resolved to a variable


		
		int  j = 5 ;
		while( j < 10 )
		{
			int p = 3 ;
			
			j++;
		}

		// FIBONACCI SEQUENCES(15 terms) --- 1 1 2 3 5 8 13 21 34 .... 
		int first = 1 ; 
		int second  = 1 ;
		System.out.print(first + " " + second + " ");
		for(int k = 1 ; k <= 13 ; k++) {
			int third = first + second ; 
			System.out.print(third + " ");	
			first = second ; 
			second = third; 
		}
		
		/*
		 * 
		 * 	F = 1		F = 1	F = 2   
		 *  S = 1       S = 2   S = 3 
		 *  T = 2		T = 3   T = 5
		 * 
		 * 
		 * 
		 */
		
		
	}

}
