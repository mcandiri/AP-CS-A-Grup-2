package Grup1;

public class Lesson15 {

	public static void main(String[] args) {

		for (int n = 2; n < 150000; n++) {
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
		
		// n: 2 c : 0  2
		// n: 3 c : 0
		
		// n:  16 c: 0  2 15 
		
		// 17 
	}

}
