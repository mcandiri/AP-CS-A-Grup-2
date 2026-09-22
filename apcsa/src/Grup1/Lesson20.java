package Grup1;

public class Lesson20 {

	
	public static void printPrimeNumbers(int end) {
		for (int n = 2; n < end; n++) {
			
			if (isPrime(n)) {
				System.out.print(n + " ");
			}
		}
		System.out.println();
	}
	// VOID   --> Void methods cannot return a value
	public static void greetings(String name) {
		System.out.println("Hi " + name);
		
	}
	
	
	public static void main(String[] args) {
		
		greetings("Mehmet");
		greetings("Asya");
		greetings("Mert");
		/*
		 * 
		 * 	for (int n = 2; n < 300000; n++) {
			int counter = 0;
			boolean isPrime = true ;
			for (int i = 2; i < n; i++) {
				if (n % i == 0) {
					counter++;
					isPrime = false;  // flag
				}
			}
			if (isPrime) {
				System.out.print(n + " ");
			}
		}
		
		 * 
		 * 
		 * 
		 */
		printPrimeNumbers(100);
		
		
	}
	public static boolean isPrime(int number) {
		for (int i = 2; i <= Math.sqrt(number); i++) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}
}
