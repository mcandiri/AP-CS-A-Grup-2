package Grup1;

public class Lesson24 {

	public static void main(String[] args) {
		// compareTo(other str) returns int
		
		String a = "A";
		String b = "C"; 
		String c = "E" ;
		String d = "a"; 
		String e = "C";
		
		
		System.out.println(a.compareTo(e)); // 1- 3 ---> -2 
		System.out.println(b.compareTo(e)); // 0
		System.out.println(a.compareTo(b)); // 1 - 3 -->  -2
		System.out.println(b.compareTo(a)); // 3 - 1 ---> 2
		System.out.println(c.compareTo(a)); // 5 - 1 ---> 4
		System.out.println(a.compareTo(d)); 
		// 1 A
		// 2 B
		// 3 C
		// 4 D
		// 5 E
		
		// Z
		//
		//
		//
		//
		// a
		// b
		// .
		
		
		String word1= "abchab";
		String word2 = "abcayg";
		String word3 = "abc";
		// h a 
		System.out.println(word1.compareTo(word2)); 
		System.out.println(word3.compareTo(word1)); 

		
		

	}

}
