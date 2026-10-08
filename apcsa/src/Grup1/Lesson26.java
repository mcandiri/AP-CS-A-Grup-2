package Grup1;

public class Lesson26 {

	public static String randomWord(String word, int length) {
		String result = "";
		
		for(int i=0 ; i < length  ;i++) {
			int rnd = (int)(Math.random() * word.length());
			result += word.substring(rnd,rnd+1);
		}
		return result ;
		
	}
	public static boolean isValid(String password) {
		 String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	     String lower = "abcdefghijklmnopqrstuvwxyz";
	     String symbols = "!@#$%^&*";
	     int minLength = 6; 
	     int maxLength = 12 ; 
	     
	     
	     if(password.length() < 6 || password.length() > 12) {
	    	 return false;
	     }
	     int countUpper= 0; 
	     int countLower = 0 ;
	     int countSymbol = 0 ;
	     for(int i=0 ; i < password.length() ; i++) {
	    	 String ch = password.substring(i,i+1); 
	    	 if(upper.indexOf(ch) != -1) {
	    		 countUpper++;
	    	 }
	    	 if(lower.indexOf(ch) != -1) {
	    		 countLower++;
	    	 }
	    	 if(symbols.indexOf(ch) != -1) {
	    		 countSymbol++;
	    	 }
	     }
	     
	     if( countUpper > 0 && countLower > 0 && countSymbol > 0 
	    		 && (countUpper + countLower + countSymbol) == password.length())
	     {
	    	 return true ;
	     }
	     return false;
	     
	}
	
	public static String generatePassword() {
		 String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	     String lower = "abcdefghijklmnopqrstuvwxyz";
	     String symbols = "!@#$%^&*";
	     int minLength = 6; 
	     int maxLength = 12 ; 
	     String all = upper + lower + symbols ; // ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz!@#$%^&*
	     int length = (int)(Math.random()* (maxLength-minLength+1) + minLength);
	     String password = "";
	     
	     while(! isValid(password)) {
	    	 password = "";
	    	 
	     for(int i=0 ; i < length  ;i++) {
				int rnd = (int)(Math.random() * all.length());
				password += all.substring(rnd,rnd+1);
			}
	     
	     }
	     
	     return password;
	}
	
	public static void main(String[] args) {
		// apple
		
		String alphabet = "abcdefghjklmnopqrstuvwxyz"; 
	//	for(int i = 0 ; i < 50 ; i++)
	//		System.out.println(randomWord(alphabet, 5));
		
		// abc   --> 0,1,2
		String word = "door";
		String result = randomWord(alphabet, 4);
		int count = 0 ;
/*		while(! word.equals(result)) {
			 result = randomWord(alphabet, 4);
			 System.out.println(result);
			 count++;
		}
		System.out.println(count);
	*/	
		System.out.println(isValid("abcdef"));
		System.out.println(isValid("aB%cdef"));
		System.out.println(isValid("aB%asSDASDDSADSADasdad"));
		System.out.println(isValid("aBB123?cdef"));
		for(int i = 0 ; i < 50 ; i++)
			System.out.println(generatePassword());

	}

}
