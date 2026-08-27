package Grup1;

public class Lesson3 {

	public static void main(String[] args) {
		// LOGICAL OPERATORS
		
		///   AND - OR - NOT  
		///   &&    ||    !

		
		
		//  AND 
		
		//	T	&&	T ---> T
		//  T	&&  F ---> F
		//  F   &&  T ---> F
		//  F	&&	F ---> F
		
		
		// OR
		
		//	T	||	T ---> T
		//  T	||  F ---> T
		//  F   ||  T ---> T
		//  F	||	F ---> F
		
		// NOT
		// !T --> F
		// !F --> T
		
		
		System.out.println(5 < 3 || !(2 < 5));
		int a = 3;
		int b = 5 ;
		int c = 0 ; 
		int d = -3 ;
	//	System.out.println(a > b && b / c == d);  // FALSE && error  ---> FALSE
	//	System.out.println(a < b && b / c == d);  // TRUE && error  --> error
	//	System.out.println(a < b || b / c == d);  // TRUE || error --> TRUE 
	//	System.out.println(a > b || b / c == d);  // FALSE || error --> error
		
		
		// DE MORGAN LAW 
		
		//   ! ( a < b && c == d) 
		
		//    a >= b  ||  c != d
		
		

	}

}
