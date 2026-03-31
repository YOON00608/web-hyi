package ex1_overriding;

public class PrartTimeEmployee extends Employee {
	
	int hourly;
	int working;
	
	public PrartTimeEmployee(String name,int hourly, int working){
		super(name);
		this.hourly = hourly;
		this.working = working;
	}
	
	@Override
	public int getPay() {
		return hourly * working; 
	}
}
