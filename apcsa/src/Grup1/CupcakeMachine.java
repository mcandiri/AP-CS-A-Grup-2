package Grup1;

public class CupcakeMachine {

	
	private int numCakes;
	private double price;
	private int orderNum; 
	
	public CupcakeMachine(int c,double p) {
		numCakes  = c; 
		price  = p ;
	}
	
	public String takeOrder(int amount)
	{
		if(amount > numCakes) {
			return "Order cannot be filled";
		}
		double cost = amount * price;
		numCakes -= amount;
		orderNum++;
		return "Order number " + orderNum + ", cost $" + cost;
	}
}
