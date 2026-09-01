package Grup1;

public class Lesson4 {

	public static void main(String[] args) {

		// variable -- değişken --- 
		
		int a = 3 ;    // type name = value ; 
		System.out.println("a: " + a);

		
		
		a = 5 ;		//   name = value ; 
		System.out.println("a: " + a);

		int b = 8 ; 
		
		b = 11 ; 
		
		a = b ;  // a = 11 
		System.out.println("a: " + a);
		a = b + 3 ; // a = 11 + 3 
		System.out.println("a: " + a);

		a = a + 5 ;   // a = 14 + 5 
		System.out.println("a: " + a);

		// Assignment Operators 
		
		a += 2 ; // a = a + 2
		System.out.println("a: " + a);

		
		a -= 3 ; 
		System.out.println("a: " + a);

		a *= 4 ; 
		System.out.println("a: " + a);

		a /= 2 ; 
		System.out.println("a: " + a);

		
		a %= 3 ;
		System.out.println("a: " + a);

		
		// final --
		
		final int x = 5 ; 
		
		
		// x  = 10 ;  // The final local variable x cannot be assigned
		
		final double PI = 3.14 ;
		final int MAX_VALUE = 2147483647 ;
		final int MIN_VALUE = -2147483648 ; 
		final double TAX_RATE=  0.2 ; 
		
		int num = 2147483647; 
		// --- ARITHMETIC OVERFLOW ---
		
		// --- unexpected value -- 
		System.out.println(num + 1);
		num *= 2;
		System.out.println(num );

		
		int y = 5 ; 
		
		
		y = 12 ;
		 
		
		y = 3 ;
		
		
		final int z = y ;
		
		
		
	}

}
