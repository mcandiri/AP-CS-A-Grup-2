package Grup1;

public class Lesson29 {

	public static void main(String[] args) {
		
//		Height h1 = new Height(6,19);
//		
//		h1.printHeight();
//		
//		Height h2 = new Height(12);
//	
//		Height h4 = new Height();
//		
//		h4.printHeight();

		BankAccount acc1 = new BankAccount("Selin Kavas", 5000);
		
		acc1.print();
		BankAccount acc2 = new BankAccount("Ceyda Yazıcı");
		
		acc2.print();
		acc2.resetPassword("1237");
		acc2.deposit(100);
		acc2.deposit(800);
		acc1.resetPassword("1905");
		
		acc2.withdrawal(1500);
		
		acc1.print();
		acc2.print();
		
		 acc1.transfer(acc2,15000,"1905");
		 acc1.print();
		 acc2.print();
		 
	}

}
