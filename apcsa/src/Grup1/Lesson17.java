package Grup1;

public class Lesson17 {

	public static void main(String[] args) {
		
		
		//  Math.random()    [0.0    1.0) 
		for(int i=0 ; i< 10 ;i++)
			System.out.println(Math.random());

		System.out.println("===========");
		
		//  Math.random() * 5   [0.0    5.0) 
		for(int i=0 ; i< 10 ;i++)
			System.out.println(Math.random() * 5);
		
		System.out.println("===========");
		
		//(int) ( Math.random() * 5)   [0   5)   --->  0 1 2 3 4
		for(int i=0 ; i< 10 ;i++)
			System.out.println((int)(Math.random() * 5));
		
		System.out.println("===========");
		
		//(int) ( Math.random() * 6) + 1   [1   7)   ---> 1 2 3 4 5 6
		for(int i=0 ; i< 10 ;i++)
			System.out.println((int)(Math.random() * 6) + 1);
		
		 // !!!!!!!!!!!!!!!!!!!!!!
		// (int) (Math.random() * A + B )   --->  [B  A+B-1]
		// (int) (Math.random() * 12 + 9 )  --->  [9  20]
		
		
		// min = 5   max  = 24   [min , max ] 
		// (int) (Math.random() * (max-min+1)  + min) --->  [5  24]
		
		
		// 1 2 3 4 5   < 3 -->  
		
		// (int)Math.random() * 5 + 4
		// 0   * 5  + 4 
		// 4
		for(int i=0 ; i < 100 ; i++) {
			System.out.println((int)(Math.random() * 5) + 4);
		}
	}
}
