package Grup1;

public class Lessoon32 {

	
	
	public static void main(String[] args) {
		
		
		
		// --- Data Collections ---
		
		
		// 1. Arrays --- 
		
		// type[]   name = {value1, value2 .. . ..   } ;
		
		int[] numbers = { 1,3,5,7,9, 11}; 
		//  1 	3	5	7	9	11
		//  0   1   2   3   4    5
		
		// type[] name = new type[length];
		
		int[] nums = new int[5];   // 0,0,0,0,0
		// double --> 0.0 , 0.0 , 0.0
		// boolean -> false , false , false 
		// String, object --> null, null, null ,null
		
		System.out.println(numbers[2]);
		System.out.println(numbers[5]);
		System.out.println(numbers[0]);
		
		
		
		System.out.println(nums[0]);
		System.out.println(nums[1]);
		System.out.println(nums[2]);
		
		
		nums[4] = 12 ;   // 0,0,0,0,12
		
		nums[0] = 5;  	 // 5,0,0,0,12

		
		System.out.println(numbers.length);
		System.out.println(nums.length);

		for(int i=0 ; i < nums.length ; i++) {
			System.out.print(nums[i] + " ");
		}
		
	}

}
