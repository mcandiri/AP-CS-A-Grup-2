package Grup1;

public class Lesson23 {

	public static void main(String[] args) {
		// equals(another string)  true / false
		
		String x = "A";
		String y = "B" ;
		String z = "A" ;
		
		System.out.println(x.equals(y));
		System.out.println(x.equals(z));
		System.out.println(z.equals(y));
		
		
		int count = 0 ;
		String word = "ap of compofuter of ofscience of a";
		for(int i=0 ; i < word.length() ; i++) {
			String c = word.substring(i,i+1);
			if( c.equals("e")) {
				count++;
			}
		}
		
		
		System.out.println(count);
		
		count = 0 ;
		for(int i=0 ; i < word.length()-1 ; i++) {
			String c = word.substring(i,i+2);
			if( c.equals("of")) {
				count++;
			}
		}
		System.out.println(count);

	}

}
