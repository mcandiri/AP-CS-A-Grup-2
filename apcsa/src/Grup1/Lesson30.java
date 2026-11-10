package Grup1;

public class Lesson30 {

	public static void main(String[] args) {
	
		
		// non static

		String str = "abc";
		
		str.length();
		
		
		
		
		// static
		
		Math.pow(2, 3);
		
		
		
		Height a = new Height(3,9);
		
		Height b = new Height(5,3);
		a.printHeight();
		b.printHeight();
		
		a = b ;
		
		a.printHeight();
		b.printHeight();
		
		
		b.add(2);
		
		a.printHeight();
		b.printHeight();
		
		
		a.add(3);
		
		a.printHeight();
		b.printHeight();
		
		
		Height c = a ;
		
		
		b.add(3);
		
		a.printHeight();
		b.printHeight();
		c.printHeight();
		
		
		a = new Height();
		int x = 8 ; 
		int y = 4 ; 
		
		x = y ;
		
		
		y = 9 ;
		
	}

}
