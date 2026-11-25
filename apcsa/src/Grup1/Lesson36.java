package Grup1;

public class Lesson36 {

	public static boolean isIncreasing(int[] arr) {
		for(int i=0 ; i < arr.length-1 ; i++) {
			if(arr[i] >= arr[i+1] ) {
				return false;
			}
		}
		return true ;
	}
	// 5 9 11 13 15   i+1
	public static void main(String[] args) {
		int[] nums = { 6, 2, 9, 23, 5, 18, -7, 1, 4 };

		
		// for each - enhanced for loop  (READ ONLY)
		for(int value : nums) {
			System.out.print(value + " ");
		}
		System.out.println();
		for(int i=0 ; i < nums.length ; i++) {
			System.out.print(nums[i] + " ");
		}
		System.out.println();

		int[]arr = new int[4];
		Lesson34.printArr(arr);

//		for(int i = 0 ; i < arr.length ; i++) {
//			arr[i] = 99 ;
//		}
		for(int item : arr) {
			item = 99 ;
		}
		System.out.println();

		Lesson34.printArr(arr);
		// 99,99,99,99
		
		arr[0] = 5; 
		arr[1] = 9 ; 
		arr[2] = 11; 
		arr[3] = 14 ;
		
		System.out.println(isIncreasing(arr));
	}

}
