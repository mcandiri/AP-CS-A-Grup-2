package Grup1;

public class Lesson2 {

	public static void main(String[] args) {
		
		
		// OPERATORS 
		
	// 1. Arithmetic Operators 
		
		// + - * /  %(mod - modulus)
		
		String a = "A" ;
		String b = "B" ;
		
		System.out.println(a + b);
		
		
		// 1. paranthesis -- 
		// 2. * , / , % 
		// 3. + , - 
		
		System.out.println(15 % 4 );
		System.out.println(14 % 2 );
		System.out.println(7 % 3 );
		System.out.println(5 % 12 );

		int x = 17 ;   
		int y = 5 ; 
		double answer = x / y ; // double answer = 3 ; --> 3.0 
		System.out.println(x / y );
		System.out.println(answer);
		
		
		// 
		
		// -- CASTING ---
		
		System.out.println((double) x / y); // 17.0 / 5 --> 3.4
		System.out.println(x / (double) y); // 17 / 5.0 --> 3.4
		System.out.println((double) x / (double) y); // 17.0 / 5.0 --> 3.4
		System.out.println((double) (x / y));  // (double) 3
		
		double value = 3.89 ;
		double value2 = 3.19 ; 
		System.out.println((int)value);  // 3
		System.out.println((int)value2); // 3
		//  ArithmeticException (run time error)  int / 0  --- int % 0 
		int number1 = 12 ;
		int number2 = 0  ;
	//	System.out.println(number1 / number2) ; 
		System.out.println((double) x / y); // 17.0 / 5 --> 3.4
		System.out.println(x / (double) y); // 17 / 5.0 --> 3.4
		System.out.println((double) x / (double) y); // 17.0 / 5.0 --> 3.4
		System.out.println((double) (x / y));  // (double) 3
		
		
		// RELATIONAL OPERATORS ---  true - false 
		// (int double)
		//   > >= < <= 
		// (int)
		//   ==  ,   != 
		int c = 3 ;
		int d = 5 ; 
		System.out.println(c < d);
		System.out.println(d <= c);
		System.out.println(c == d);
		System.out.println(c != d);

		// -- ROUND OFF ERROR ---
		double val1 = 0.6 ; 
		double val2 = 0.8 ; 
		double val3 = val1 + 0.1 ;  // 0.7
		double val4 = val2 - 0.1 ;  // 0.7000000000000001
		
		System.out.println(val3 == val4);  // false
		System.out.println(val3);
		System.out.println(val4);
		
		double val5 = 23435.6765765 ;
		double val6 = 23435.6765765 ;
		System.out.println(val5 == val6);  // true

		/// İki double değeri doğru bir şekilde kontrol eden kodu yazın!!!
		
		
		String s1 = "A" ;
		String s2 = "B" ;
		String s3 = "AB" ;
		// Never use == to compare 2 strings!!!!
		System.out.println(s1 + s2);
		System.out.println(s3);
		System.out.println((s1+s2) == s3);
	}

}
