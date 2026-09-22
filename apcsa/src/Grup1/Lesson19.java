package Grup1;

public class Lesson19 {
	
	/*
	 * 		HEADER 
	 *      BODY 
	 * 		RETURN STATEMENT 
	 */
	
	//header
	// public static RETURNTYPE METHODSNAME(parameters) {
	//		body
	
	
	//		return 
	// }

	public static int sum(int a,int b) {
		int total = a + b ; 
		
		return total ;
	}
	/*
	public static boolean isEven(int number) {
		if(number % 2 == 0) {
			return true ;
		}
		
	}
	public static boolean isEven(int number) {
		if(number % 2 == 0) {
			return true ;
		}
		if(number % 2 != 0) {
			return false; 
		}
	}
	*/
	public static boolean isEven(int number) {
		if(number % 2 == 0) {
			return true ;
		}
		else {
			return false; 
		}
	}
	public static boolean isEven2(int number) {
		if(number % 2 == 0) {
			return true ;
		}
		return false; 
		
	}
	public static boolean isEven3(int number) {
		return number % 2 == 0 ;
	}
	
	public static int getNote(int note) {
		if( note > 80) {
			return 5 ;
		}
		if (note > 60) {
			return 4 ;
		}
		if (note > 40) {
			return 3 ;
		}
		return 0 ; 
	}
	public static void main(String[] args) {
		
		System.out.println(sum(2,3));
		System.out.println(sum(6,-3));
		System.out.println(sum(1232,4353));
		System.out.println(sum(0,0));

		System.out.println(isEven2(25));
		// Math.pow(base, expo) --->  value  
		
		// methods name -> pow 
		// parameters ,arguments   -> base , expo 
		// return ---> value 
		
	double answer = Math.pow(2, 3);
	System.out.println(answer);
	
		// f(x) = 2 *x + 3 
	
	
	
		

	}
	
	

}
