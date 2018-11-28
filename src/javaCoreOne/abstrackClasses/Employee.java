package javaCoreOne.abstrackClasses;

import java.time.LocalDate;

import javax.swing.event.AncestorEvent;

public class Employee extends Person implements Comparable<Employee> {
	private double salary;
	private LocalDate hireDay;
	public Employee(String name,double salary,int year,int month,int day) {
		super(name);
		this.salary=salary;
		this.hireDay=LocalDate.of(year,month,day);
	}
	@Override
	public String getDescription() {
		return String.format("an employee with a salary of $%.2f", salary);
	}
	
	public void raiseSalary(double byPercent){
		double raise=salary*byPercent/100;
		salary+=raise;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public LocalDate getHireDay() {
		return hireDay;
	}
	public void setHireDay(LocalDate hireDay) {
		this.hireDay = hireDay;
	}
	/*
	 * 接口的实现
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Employee o) {
		return Double.compare(salary, o.getSalary());
	}
	
	

}
