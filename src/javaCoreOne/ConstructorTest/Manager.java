package javaCoreOne.ConstructorTest;

public class Manager extends Employee{
	private double bonus;
	public Manager(String n,double s,double bonus) {
		super(n, s);
		this.bonus=bonus;
	}
	public Manager(double s,double bonus) {
		super(s);
		this.bonus=bonus;
	}
	@Override
	public double getSalary() {
		double baseSalary=super.getSalary();
		return baseSalary+this.bonus;
	}
	public double getBonus() {
		return bonus;
	}
	public void setBonus(double bonus) {
		this.bonus = bonus;
	}
	//子类对象对比
	public boolean equals(Object obj) {
		if(!super.equals(obj)) return false;
		Manager other=(Manager) obj;
		return bonus==other.getBonus();
	}
	public int hashCode() {
		return super.hashCode()+17*new Double(bonus).hashCode();
	}
	
}
