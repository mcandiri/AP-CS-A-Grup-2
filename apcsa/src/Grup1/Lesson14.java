package Grup1;

public class Lesson14 {

	public static void main(String[] args) {
		int n = 1 ;
		for (int i = 1; i <= 5; i++) {  // rows
			for (int j = 1; j <= n; j++) {  // column
				System.out.print("*");
			}
			n++ ;
			System.out.println();
		}

		for (int i = 1; i <= 5; i++) {  // rows
			for (int j = 1; j <= 6-i; j++) {  // column
				System.out.print("*");
			}
			System.out.println();
		}
		/*
		 * 
		 * 	*
		 *  **
		 *  ***
		 *  ****
		 *  *****
		 *  
		 *  *****
		 *  ****
		 *  ***
		 *  **
		 *  *
		 * 
		 * 
		 *      *	1.  4 [ ]   1 *
		 *     **   2.  3 [ ]   2 *
		 *    ***   3.  2 [ ]   3 *
		 *   ****   4.  1 [ ]   4 * 
		 *  *****   5.  0 [ ]   5 *
		 * 
		 * 
		 *      *	    1.  4 [ ]   1 *
		 *     ***      2.  3 [ ]   3 *
		 *    *****     3.  2 [ ]   5 *
		 *   *******    4.  1 [ ]   7 * 
		 *  *********   5.  0 [ ]   9 *
		 */
		
		for (int i = 1; i <= 5; i++) { 
			for(int k= 0 ; k < 5 - i ; k++ )  {
				System.out.print(" ");
			}
			for (int j = 1; j <= i; j++) {  
				System.out.print("*");
			}
			System.out.println();
		}
		
	//	n = 1 ;
		for (int i = 1; i <= 10; i++) { 
			for(int k= 0 ; k < 10 - i ; k++ )  {
				System.out.print(" ");
			}
			for (int j = 1; j <= 2*i - 1; j++) {  
				System.out.print("*");
			}
	//		n += 2;
			System.out.println();
		}
	}

}
