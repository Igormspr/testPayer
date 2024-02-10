package entities;

public class Account extends Client{

	public double amount;
	
	public Account() {
		
	}

	public Account(Integer id, String name, String email, double amount) {
		super(id, name, email);
		this.amount = amount;
	}

	public double getAmount() {
		return amount;
	}

	
	public void withdraw (double value) {
		if (amount < value) {
			System.out.println("Amount is not enougth for a withdraw!");
		}
		else {
			amount -= value;
		}
	}
	
	public void deposit (double value) {
		amount += value;
	}
	
	@Override
	public String toString () {
		return "id: " + id + "\n" 
				+ "name: " + name + "\n"
				+ "email: "+ email + "\n"
				+amount;
	}		
}
