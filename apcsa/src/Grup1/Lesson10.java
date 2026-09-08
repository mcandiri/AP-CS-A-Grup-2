package Grup1;

public class Lesson10 {

	public static void main(String[] args) {
		//  HAILSTONE SEQUENCES -- COLLATZ 
		
		
		// even ?   /2
		// odd  ?   * 3 + 1 
		
		int count = 0 ;  // 1
		int n = 5; 
		while(n != 1)
		{
			System.out.print(" N: " + n);
			if(n % 2 == 0) {
				n /= 2; 
			} else {
				n = n * 3 + 1 ;
			}
			count++;
		}
		System.out.print(" N: " + n);
		System.out.println();
		System.out.println(count + 1);
		
		
		// LEAP YEAR --- 
		
		// % 4 == 0 +
		// % 400 == 0 +
		// % 100 != 0 
		
		int startYear = 1897; 
		int endYear = 2029 ; 
		int counter = 0 ; 
		for(int i = startYear ; i <= endYear ; i++ )
		{
			 if( (i % 400 == 0) || ( i % 4 == 0 && i % 100 != 0))
			 {
				 System.out.println(i);
				 counter++;
			 }
		}
		System.out.println(counter);
		
		
		

	}

}
