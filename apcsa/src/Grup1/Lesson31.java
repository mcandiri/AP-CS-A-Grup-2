package Grup1;

public class Lesson31 {

	/*
	 * 
	 * 			Passed by value 
	 * 			number = a ;
	 *          number++;
	 *          a??? 
	 * 
	 */
	public static void increment(int number ) {
		number++ ; // number = number + 1
		System.out.println("In method: " + number);
	}
	/**
	 * 
	 * 
	 * 		Passed by reference
	 * 		ht = h ; 
	 *      ht.add(1) 
	 * 
	 *
	 */
	
	public static void increment(Height ht) {
		ht.add(1);
	}
	
	/*
	 * 		passed by value 
	 * 
	 * 
	 */

	public static void increment2(Height ht) {
		int ft = ht.getFeet();
		int inc = ht.getInches();
		
		ht = new Height(ft, inc+1);
	}
	public static void main(String[] args) {
		
		
		// PASSED BY VALUE 
		int number = 9 ;
		System.out.println("Before method: " + number);

		increment(number);
		
		System.out.println("After method: " + number);
		
		int x = 5 ; 
		int y = 3 ;
		
		x = y ;
		
		y++ ;
		
		
		increment(5);
	
		
		Height h = new Height(4,2);
		
		increment(h);
		
		
		h.printHeight();
		
		increment2(h);		
		h.printHeight();

		System.out.println(h);
		
		Height h1 = h;
		
		
		System.out.println(h1 == h);

	}

}
