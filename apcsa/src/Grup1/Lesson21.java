package Grup1;

public class Lesson21 {

	public static void main(String[] args) {
		
		
		String word = "computere";
		
		// c o m p u t e r
		// 0 1 2 3 4 5 6 7
		
		System.out.println(word.length());

		//indexOf(String part)   [ 0,length )      ----     -1
		
		System.out.println(word.indexOf("p"));  // 3
		System.out.println(word.indexOf("o"));  // 1
		System.out.println(word.indexOf("c"));  // 0 
		System.out.println(word.indexOf("r"));  // 7
		System.out.println(word.indexOf("t"));  // 5
		
		System.out.println(word.indexOf("mpu"));  // 2
		System.out.println(word.indexOf("ter"));  // 5
		System.out.println(word.indexOf("co"));   // 0
		
		System.out.println(word.indexOf("e")); // 6
		
		
		System.out.println(word.indexOf("C")); // -1
		
		System.out.println(word.indexOf("x"));  // -1  
		System.out.println(word.indexOf("computers"));  // -1 

		String letter = "e"; 
		
		if(word.indexOf(letter) == 0) {
			// word starts with letter
		}
		
		if( word.indexOf(letter) == -1) {
			// 
		}
		
//		if( word.indexOf(letter) == word.length()-1) {
//			
//		}
		
		
		

	}

}
