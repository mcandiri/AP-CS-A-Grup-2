package Grup1;

public class Lesson22 {

	public static void main(String[] args) {
		String word = "computer";
		
		// c o m p u t e r
		// 0 1 2 3 4 5 6 7
		
		
		// SUBSTRING(int start,int end)   [start end)
		
		System.out.println(word.substring(2,5));  // mpu
		System.out.println(word.substring(0,4));  // comp
		System.out.println(word.substring(3,7));  // pute
		System.out.println(word.substring(2,8));  // mputer
		System.out.println(word.substring(0,8));  // computer
		System.out.println(word.substring(4,5));  // u


		System.out.println(word.substring(0,1)); // first character
		System.out.println(word.substring(word.length()-1,word.length())); // last character
 
//		
//		System.out.println(word.substring(0,1));
//		System.out.println(word.substring(1,2));
//		System.out.println(word.substring(2,3));
//		System.out.println(word.substring(3,4));
//		System.out.println(word.substring(4,5));
//		System.out.println(word.substring(5,6));
//		System.out.println(word.substring(6,7));
//		System.out.println(word.substring(7,8));
//		
		
		// 0 1 2 3 4 5  6 7 
		for(int i=0 ; i < word.length() ; i++) {
			System.out.println(word.substring(i,i+1));
		}
		
		// StringIndexOutOfBoundsException
		// endindex > length
		// startindex < 0
		// startindex > endindex 
	//	System.out.println(word.substring(3, 9));
	//	System.out.println(word.substring(-1, 7));
	//	System.out.println(word.substring(5, 2));
		System.out.println(word.substring(0, 0)); // "" empty string
		System.out.println(word.substring(5, 5)); // ""
		System.out.println(word.substring(8, 8)); // ""
		
		
		for(int i= word.length()-1  ; i >= 0; i--) {
			System.out.println(word.substring(i,i+1));
		}
		
		
		for(int i=0 ; i < word.length()-1 ; i++) {
			System.out.println(word.substring(i,i+2));
		}
		
		for(int i=0 ; i < word.length()-2 ; i++) {
			System.out.println(word.substring(i,i+3));
		}
		
		
		// substring(int start)   ---> substring(start , length)
		System.out.println(word.substring(2));  // mputer
		System.out.println(word.substring(0));  // computer
		System.out.println(word.substring(3));  // puter
		System.out.println(word.substring(4));  // uter

		
		System.out.println(word.substring(word.length()-1)); // last character
		
		
		String fullName = "das sdas";
		int index = fullName.indexOf(" ");
		if(index != -1) {
			System.out.println(fullName.substring(0,index));
			System.out.println(fullName.substring(index+1));
		}
		else {
			System.out.println(fullName);
		}
	
	}

}
