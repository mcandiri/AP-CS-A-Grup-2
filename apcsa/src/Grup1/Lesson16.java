package Grup1;

public class Lesson16 {

	public static void main(String[] args) {
		
		// functions -- methods 
		
		
		// BUILT IN FUNCTIONS 
		
		// math functions ---
		
		// absolute value 
		// power
		// square root
		// random number generator 
		
		
	
		// 1. Math.abs(value) -->   |value|
		         // int
		System.out.println(Math.abs(-3));
		System.out.println(Math.abs(3));
				// double
		System.out.println(Math.abs(-3.2));
		System.out.println(Math.abs(3.2));
		

		double val1 = 0.6 ; 
		double val2 = 0.8 ; 
		double val3 = val1 + 0.1 ;  // 0.7
		double val4 = val2 - 0.1 ;  // 0.7000000000000001
		
		System.out.println(val3 == val4);  // false
		System.out.println(val3);
		System.out.println(val4);
		double tolerance = 0.000001 ; 
		
		System.out.println(Math.abs(val3 - val4) <= tolerance); //--- close enough ---
		
		
		// 2. Math.pow(double base, double exponent)
		
		System.out.println(Math.pow(2, 3));    // 2.0, 3.0
		System.out.println((int)Math.pow(2, 3));
		System.out.println(Math.pow(2.56, 3.21)); 
		System.out.println(Math.pow(16, 0.25));
		System.out.println(Math.pow(16, 1/4)); 

		System.out.println(Math.pow(2, 0)); 
		System.out.println(Math.pow(-2, 5)); 
		System.out.println(Math.pow( 127, -3)); 
		
		
		// 3. Math.sqrt(double value)
		
		System.out.println(Math.sqrt(16));
		System.out.println((int)Math.sqrt(16));
		System.out.println(Math.sqrt(19.6546));
		System.out.println(Math.sqrt(4353.664));
		System.out.println(Math.sqrt(-25)); // NaN  ---  not a number ---
		
	}

}
