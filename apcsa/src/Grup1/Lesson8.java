package Grup1;

public class Lesson8 {

	public static void main(String[] args) {
		
		
		int sum = 0 ;
		
		for (int i = 1; i <= 10; i++) {
			sum = sum + i ; 
			System.out.println("i= " + i + " sum= " + sum);
		}
		System.out.println(sum);
		
		sum = 0 ; 
		
		for(int i= 3 ; i<= 35 ; i++) {
			if(i % 5 == 0) {
				sum = sum + i ; 
				System.out.println("i= " + i + " sum= " + sum);
			}
		}
		
		int factorial = 1 ;
		// 7! --> 7*6*5*4*3*2*1 
		for(int i=7 ; i> 0 ; i--) {
			factorial *= i ; 
		}
		System.out.println(factorial);
		
		
		int count = 0 ; 
		for(int i = 1 ; i < 35 ; i++) {
			if(i % 2 == 0) {
				count++; 
				System.out.println("i= " + i + " count= " + count);
			}
		}
		System.out.println(count);
	}

}
