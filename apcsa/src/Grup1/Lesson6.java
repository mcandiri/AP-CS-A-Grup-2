package Grup1;

public class Lesson6 {
	public static void main(String[] args) {

		int note = -243 ; 
		
		if(note < 0 || note > 100) {
			System.out.println("INVALID NOTE!!");
		}
		else if(note >= 80) {
			System.out.println("5");
		}
		else if(note >= 60 ) {
			System.out.println("4");
		}
		else if(note >= 40) {
			System.out.println("3");
		}
		else if(note >= 20) {
			System.out.println("2");
		}
		else {
			System.out.println("1");
		}
		
		
		// --- DANGLING ELSE ---  if if else
		
		int number = -3 ;
		
		if(number > 0)
			if(number % 2 == 0)
				System.out.println("even number");
		else
			System.out.println("number is negative!");
		
		

		if(number > 0) 
			if(number % 2 == 0)
				System.out.println("even number");
			else
				System.out.println("number is negative!");
		
		
		if(number > 0) 
			if(number % 2 == 0)
				System.out.println("positive even number");
			else
				System.out.println("positive odd number");
		else
			System.out.println("number is negative!");

		
		
	}
}
