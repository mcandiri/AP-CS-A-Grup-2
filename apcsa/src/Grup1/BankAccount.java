package Grup1;

public class BankAccount {

	private String firstName; 
	private String lastName; 
	
	private String password ; 
	private double balance ; 
	
	//"firstname lastname"
	public BankAccount(String fullName, double balance)
	{
		int index = fullName.indexOf(" ");
		if(index != -1)
		{
			firstName = fullName.substring(0, index);
			lastName = fullName.substring(index+1);
		}
		else
		{
			System.out.println("Invalid name");
		}
		if(balance > 0)
		{
			this.balance = balance; 	
		}
		password = generatePassword();
	
	}
	public BankAccount(String fullName)
	{
		int index = fullName.indexOf(" ");
		if(index != -1)
		{
			firstName = fullName.substring(0, index);
			lastName = fullName.substring(index+1);
		}
		else
		{
			System.out.println("Invalid name");
		}
	//	balance = 0 ; (optional)
		password = generatePassword();

	}
	
	
	
	// firstname
	// surname 
	
	// password - 4digits number -- random 
	
	//  balance --
	
	
	
	// name, balance
	// name 
	
	
	
	// changepassword
	// deposit
	// withdraw
	// transfer
	public void deposit(double amount)
	{
		if(amount > 0) {
			balance += amount;
			System.out.println("Current balance: " + balance);
		}
		else {
			System.out.println("Amount must be positive!");
		}
	}
	public void withdrawal(double amount)
	{
		if(amount > 0 && amount <= balance) {
			balance -= amount;
			System.out.println("Current balance: " + balance);
		}
		else {
			System.out.println("Invalid amount!");
		}
	}
	
	public void transfer(BankAccount other, double amount, String password)
	{
			if(amount <= balance ) {
				
				if(amount > 1000 && this.password.equals(password)) {
					balance -= amount ;
					other.balance += amount;
				}
				if(amount > 1000 &&  !this.password.equals(password))
				{
					System.out.println("Incorrect password!");
				}
				if(amount <= 1000) {
					balance -= amount ;
					other.balance += amount;
				}
				
			} else {
				System.out.println("Invalid amount!");

			}
	}
	
	private String generatePassword()
	{
	//	int p = (int)(Math.random() * 9000) + 1000 ;
	//	return p + "" ; 
		
		String numbers = "0123456789";  // 0897
		String pw = "";
		for(int i=0; i < 4 ; i++) {
			int r = (int)(Math.random() * numbers.length());
			pw += numbers.substring(r,r+1);
		}
		return pw; 
		
	}
	public void resetPassword(String p) {

		if(isValid(p)) {
			password = p ;
		}
		else {
			System.out.println("Invalid Password");
		}
		
		
	}
	private boolean isValid(String p) {
		String numbers = "0123456789";
		if(p.length() != 4) {
			return false;
		}
		for(int i =0 ; i < p.length() ; i++) {
			if( numbers.indexOf(p.substring(i,i+1)) == -1 )
			{
				return false;
			}
		}
		return true;
	}
	
	public void print()
	{
		System.out.println("**************");
		System.out.println("Customer's name: " + (firstName + " " + lastName));
		System.out.println("Customer's password: " +password);
		System.out.println("Customer's balance: $" + balance);
		System.out.println("**************");

	}
	
	
	
}
