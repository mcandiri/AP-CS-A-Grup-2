package Grup1;

public class Lesson11 {

	public static void main(String[] args) {
		
		
		int number = 1234056 ; 
		int sum = 0 ;
		int count = 0 ;
		while(number != 0) { // number > 0
			int digit = number % 10 ;
			System.out.println(digit);
			sum += digit ;
			count++; 
			number /= 10;
		}
		// 1,2,3,4 
		// 1 + 2  + 3 + 4 
		// 4 
		System.out.println(sum + " " + count );
		
		/*
		 * 	number % 10 ---> 4
		 * 
		 *  number / 10 ---> 123
		 *  
		 *  
		 *  number % 10 ---> 3
		 *  
		 *  number / 10 ---> 12
		 *  
		 *  number % 10 ---> 2
		 *  
		 *  number / 10 ----> 1
		 *  
		 *  number % 10 ----> 1
		 *  
		 *  number / 10 ---> 0
		 *  
		 * 	
		 *///  HOMEWORK
		 /// REVERSE THE NUMBER
		  
		 
		
		
		// 120 ---> 1,2,3,4,5,6,8,10,12,15,20,24,30,40,60,120 
		int n= 120 ; 
		int m = 160 ;
		sum = 0 ;
		int counter = 0 ;
		for(int i= n ; i > 0 ; i--) {
			if(n % i == 0 && m % i == 0) {
				System.out.print(i + " ");
				sum += i ;
				counter++;
			}
		}
		
		
		
		
	}

}
