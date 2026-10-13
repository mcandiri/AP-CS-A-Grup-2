package Grup1;

// 1 feet = 12 inches 
public class Height {

	private int feet ;
	private int inches ;
	
	// this keyword
	
	public void setFeet(int feet) {
		if(feet > 0) {
			this.feet = feet;
		}
	}
	public void setInches(int inches) {
		if(inches > 0) {
		//	inches = inches; // The assignment to variable inches has no effect
			this.inches = inches;
		}
		simplify();
	}
	
	public int getFeet() {
		return feet;
	}
	public int getInches() {
		return this.inches;
	}
	
	public void printHeight() {
		System.out.println(this.feet + " ft. " + inches + " inc." );
	}
	
	private void simplify() {
		//feet +  inc / 12 
		// inc = inc % 12
		feet += inches / 12 ;
		inches = this.inches % 12;
		
		// 
		while(inches >= 12) {
			feet++;
			inches -=12 ;
		}
	}
	
	public void add(int inc)
	{
		inches += inc;
		this.simplify();
	}
	
	// h1.addHeight(h2);
	public void addHeight(Height other) {
		this.feet += other.feet;
		inches += other.inches;
	}
}
