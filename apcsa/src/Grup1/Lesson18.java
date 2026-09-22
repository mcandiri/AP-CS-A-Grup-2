package Grup1;

public class Lesson18 {

	public static void main(String[] args) {
		
		int counter = 0;
		
		for(int i=0 ; i < 50 ; i++) {
			int n = (int)(Math.random() * 2) + 1 ; 
			if(n == 1) {
				System.out.println("TURA");
				counter++;
			}
		}
		
		System.out.println(counter);
		
		
		// 4 2 
		// 0.055555
		counter = 0 ;
		
		for(int i=0 ; i < 1000000 ; i++) {
			int n = (int)(Math.random() * 6) + 1 ; 
			int m = (int)(Math.random() * 6) + 1 ; 

			if((n == 2 && m == 4) || (n == 4 && m == 2) ) {
				System.out.println( m + " " + n);
				counter++;
			}
		}
		
		System.out.println(counter / 1000000.0);
		

	 //	Math.PI
		System.out.println(Math.PI);  // 3.141592653589793
	//	Math.PI ++; 
	//	Math.PI = 5 ; 
		
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);

	}

}
