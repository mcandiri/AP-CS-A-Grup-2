package Grup1;

public class Lesson13 {

	public static void main(String[] args) {

		/*
		 * j = 1 i = 1 i = 2 3 4 5 
		 * j = 2 i = 1 2 3 4 5 
		 * j = 3 i = 1 2 3 4 5
		 */

		// outer loop
		for (int j = 1; j <= 3; j++) {
			for (int i = 1; i <= 5; i++) { // inner loop
				System.out.println("j= " + j + " i= " + i); // 5 x
			}
			System.out.println(); // 3 x
		}

		for (int i = 1; i <= 5; i++) {  // rows
			for (int j = 1; j <= 20; j++) {  // column
				System.out.print("*");
			}
			System.out.println();
		}

	}

}
