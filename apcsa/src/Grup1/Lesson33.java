package Grup1;

public class Lesson33 {

	public static void main(String[] args) {
		
		int[] numbers = { 1,4,7,8,12, 13, 15, 18, 20, 21, 24}; 

		for(int i=0 ; i < numbers.length ; i++) {
			System.out.print(numbers[i] + " ");
		}
		System.out.println();
		// System.out.println(numbers); [I@7ea987ac

		int total = 0 ;
		for(int i=0 ; i < numbers.length ; i++) {
			total += numbers[i] ;
		}
		
		System.out.println(total);
		total = 0;
		int count = 0 ;
		for(int i=0 ; i < numbers.length ; i++) {
			if(numbers[i] % 2 == 0) {
				total += numbers[i] ;
				count++;
			}
		}
		
		System.out.println(total);
		System.out.println(count);

		
		for(int i=numbers.length-1  ; i >= 0 ; i--) {
			System.out.print(numbers[i] + " ");
		}
		System.out.println();
		
		// ArrayIndexOutOfBoundsException
		// index < 0 , >= length
		System.out.println(numbers.length);
	//	System.out.println(numbers[11]);
	//	System.out.println(numbers[-3]);
		for(int i=numbers.length-1  ; i > 0 ; i--) {
			System.out.println(numbers[i-1] + " " + numbers[i]);
		}
		System.out.println();
		
		// arr[0] ---> first 
		
		// arr[length-1] --> last 
		
		String[] arr = {"Istanbul" ,"Ankara" ,"Izmir" };
		double[] arr2 = { 4.312 , 1 , 5.2 , 3.45 }  ;
		boolean[] arr3  = { true, false, true } ; 
		
		

	}

}
