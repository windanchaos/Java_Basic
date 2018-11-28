package javaCoreOne.ParamTest;

import java.util.function.DoubleToLongFunction;


/*
 * 值传递和参数传递
 * call by value and call by reference
 */
public class ParameTest {

	public static void main(String[] args) {
		/*
		 * test 1:Methods can't modify numeric parameters
		 * 方法不能定义数字的参数
		 */
		System.out.println("Testing tripleValue");
		double percent=10;
		System.out.println("After tripleValue: ");
		tripleValue(percent);
		System.out.println("tripleValue: "+percent);
		
		/*
		 * Test 2: Methods can change the state of object parameters
		 * 方法可以改变类参数的状态（值）
		 */
		Employ harry=new Employ("Harry",5000);
		System.out.println("Before:salary="+harry.getSalary());
		tripleSalary(harry);
		System.out.println("After:salary="+harry.getSalary());
		
		//下面使用harry.getSalary()取得值后，再用tripleValue(double x)
		tripleValue(harry.getSalary());
		System.out.println("After:salary="+harry.getSalary());
		/*
		 * Test3 Methods can't attach new objects to object parameters
		 */
		Employ bob=new Employ("Bob", 10000);
		swap(harry, bob);
		System.out.println("After swap:harry ="+harry.getName());
		System.out.println("After swap:bob ="+bob.getName());
	}
	public static void tripleValue(double x) {
		//传入的参数x，是传入值的一个拷贝。并不是原来的值（内存地址和值），由java堆栈定义的。基本数据类型在栈中。
		x=3*x;
		System.out.println("In the mothod:x is："+x);
	}
	public static void tripleSalary(Employ employ) {
		employ.raiseSalar(200);
		System.out.println("End of method:salary:"+employ.getSalary());
	}
	
	public static void swap(Employ x,Employ y) {
		//对象类型传递的是引用，传入方法区的是引用的拷贝，所以对拷贝进行交换并不会影响原来参数指向。
		Employ tmp=x;
		x=y;
		y=tmp;
		System.out.println("in swap mothod:x="+x.getName());
		System.out.println("in swap mothod:y="+y.getName());
	}
}

class Employ{
	private String name;
	private double salary;
	public String getName() {
		return name;
	}
	public double getSalary() {
		return salary;
	}
	/**
	 * @param name
	 * @param salary
	 */
	public Employ(String name, double salary) {
		super();
		this.name = name;
		this.salary = salary;
	}
	
	public void raiseSalar(double byPercent) {
		double raise=this.salary*byPercent/100;
		salary=salary+raise;
	}
}