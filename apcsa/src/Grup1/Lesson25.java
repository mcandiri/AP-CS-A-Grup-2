package Grup1;

public class Lesson25 {

	public static void main(String[] args) {
		
		
		//       \
		
		
		// escape sequences
		
		// \n  ---> new line 
		// \t  ---> tab
		// \"abc\" ---> "abc"
		// D:\\Program Files\\ ---> D\Program Files\
		System.out.println("W\nelcome\nto my\nworld!");
		System.out.println("Welc\tome \to my wo\trld!");
		
		for(int i=1 ; i <= 10 ;i++) {
			for(int j=1 ; j<= 10; j++) {
				System.out.print(i*j + "\t");
			}
			System.out.println();
		}
		System.out.println("Welcome \"to\" my wo\"rld");
		System.out.println("Welco\\me \\to my wo\\\\\\rld!");
		
		
		// NULL keyword
		
		String a = ""; // empty string length = 0 
		
		System.out.println(a.length());
		System.out.println(a.indexOf("dsa"));
				
		//  NullPointerException
		String b = null ; 
		System.out.println(b.length());

		
	}

}
