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

		
		// Math.random  Math.pow(2,3)
		
//		System.out.println(BankAccount.bankName); // The field BankAccount.bankName is not visible
		
		BankAccount.printBankName();
	//	BankAccount.someFunction();
		BankAccount.printCount();
		
		
		
		BankAccount acc1 = new BankAccount("Selin Kavas", 5000);
		BankAccount.printCount();

	//	System.out.println(acc1.bankName); // The static field BankAccount.bankName should be accessed in a static way
		// The field BankAccount.bankName is not visible

		acc1.print();
		BankAccount acc2 = new BankAccount("Ceyda Yazıcı");
		System.out.println(acc2);
		BankAccount.printCount();

		acc2.print();
		acc2.resetPassword("1237");
		acc2.deposit(100);
		acc2.deposit(800);
		acc1.resetPassword("1905");
		
		acc2.withdrawal(1500);
		
		acc1.print();
		acc2.print();
		
		 acc1.transfer(acc2,200,"1905");
		 acc1.print();
		 acc2.print();
		 
		BankAccount acc3 = new BankAccount("Selin Kavas", 5000);
		BankAccount.printCount();
		BankAccount.printTotalFees();
		
		
/*		for(int i=0; i <100 ; i++) {
			acc2.fee(999999);
		}
		 
		BankAccount.printTotalFees();
		acc2.print();
		
*/		
		
		
		BankAccount acc4 =  acc1.merge(acc2);
		
		acc4.print();
		
		BankAccount.printCount();
		
		acc1.print();
		acc2.print();
	}

}
