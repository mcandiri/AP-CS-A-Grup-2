package Grup1;

public class Lesson34 {

	public static void printArr(int[] arr) {
		System.out.print("{");
		for(int i=0 ; i < arr.length ; i++) {
			if(i < arr.length-1)
				System.out.print(arr[i] + ", ") ;
			else
				System.out.print(arr[i]);
		}
		System.out.println("}");

		
	}
	
	public static void main(String[] args) {
		
		int[] arr = new int[5]; // 0,0,0,0,0
		
		
		arr[0] = 9 ; 
		arr[1] = 7 ;
		arr[2] = 5 ;
		arr[3] = 3 ; 
		arr[4] = 1 ;
		// 9,7,5,3,1
		
		
		int total = 0 ;
		// {9, 7, 5, 3, 1} 
		System.out.print("{");
		for(int i=0 ; i < arr.length ; i++) {
			if(i < arr.length-1)
				System.out.print(arr[i] + ", ") ;
			else
				System.out.print(arr[i]);
		}
		System.out.println("}");

		
		// 9 7 5 3 1   ----->   1 3 5 7 9 
		for(int i= arr.length-1 ; i >= 0 ; i--) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
//		
//		// SWAP ALGORITHM
//		int a = 3 ;
//		int b = 5 ; 
//		
//		int temp = a ; // temp = 3 
//		a= b ; // a = 5	
//		b = temp ; // b = 3 
//		
		// 9 7 5 3 1    
		// 0 1 2 3 4      
		
		// 0 -4   1- 3 .. . .    i  -  length-1-i
		// 9 <=> 1
		// 7 <=> 3
		// 
		
		// 1 2 3 4 5 6 7 8 9 10 
		// 1 2 3 4 5 6 7 8 9 10
		
		printArr(arr);
		for(int i=0 ; i < arr.length/2; i++) {
			int temp = arr[i];
			arr[i] = arr[arr.length-1-i];
			arr[arr.length-1-i] = temp;
		}
		
		printArr(arr);

		int[] nums = { 6, 2, 9, 23, 5, 18, -7, 1, 4 };
//		int max = nums[0];  
//		int min = nums[0];
		int maxIndex=  0;
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE; 
		for(int i=0; i < nums.length ; i++) {
			if(nums[i] > max) {
				max = nums[i];
				maxIndex = i ;
			}
			if(nums[i] < min) {
				min = nums[i];
			}
		}
		
		System.out.println(max + " " + min);
		
	}

}
