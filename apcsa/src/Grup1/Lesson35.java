package Grup1;

public class Lesson35 {

	public static void main(String[] args) {
		String[] arr = {"Ankara","Istanbul","Kahramanmaraş","Antalya","Van","Bolu","Samsun"};
		int maxLength = arr[0].length();
		int maxIndex = 0 ;
		for(int i=0 ; i < arr.length ; i++) {
			if(arr[i].length() > maxLength) {
				maxLength = arr[i].length();
			}
			
		}
		for(int i=0 ; i < arr.length ; i++) {
			if(arr[i].length() > arr[maxIndex].length()) {
				maxIndex = i;
			}
			
		}
		System.out.println(maxLength);
		System.out.println(arr[maxIndex]);
		
		
	}

}
