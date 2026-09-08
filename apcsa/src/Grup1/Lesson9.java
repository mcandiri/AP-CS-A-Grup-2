package Grup1;

public class Lesson9 {

	public static void main(String[] args) {
		// WHILE LOOP
		
		/*
		 * 
		// 		for(start ;stop ;step)
		// 		{
		//			ACTION **
		// 		}
		
				for(int i=1 ; i <= 10; i++) 
				{
					System.out.println("Hello");
					
				}
		 * 
		 * 
		 * 		start
		 * 		while(stop)
		 *      {
		 *      	--
		 *      	ACTION **
		 *      	step 
		 *      }
		 * 
		 */
			int i = 1 ;
			while( i <= 10)
			{
				System.out.println("Hello");
				i++;
			}
			
			
			int sum = 0 ;
			int j = 3 ;
			while(j <= 35)
			{
				if(j % 5 == 0) {
					sum = sum + j ; 
					System.out.println("j= " + j + " sum= " + sum);
				}
				j++;
			}
			
			int k = 0 ; 
			while(k < 10) {
				System.out.println(k);
				k++;
			}
	}

}
