package Grup1;

public class Lesson28 {
	public static void main(String[] args) {
		
		Height h1 = new Height(); // h1 -> this 
		h1.setFeet(6);
		h1.setInches(9);
		h1.printHeight();
		
		Height h2 = new Height(); // h2 -> this 
		h2.setFeet(6);
		h2.setInches(15);
		h2.printHeight();
		
		Height h3 = new Height();
		h3.setFeet(17);
		h3.setInches(123);
		h3.printHeight();
		
		h2.add(35);
		h2.printHeight();
		
		
	//	h2.simplify(); //The method simplify() from the type Height is not visible
		h1.printHeight();
		h2.printHeight();
		
		h1.addHeight(h2); // h1 -> 16ft 11inc
		// h1.feet
		// h2.inches 
		
		h1.printHeight();
		
		
		
	
	}

}
