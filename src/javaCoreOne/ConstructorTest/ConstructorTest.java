package javaCoreOne.ConstructorTest;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

import javax.swing.plaf.synth.SynthScrollBarUI;

public class ConstructorTest {

	public static void main(String[] args) {
		
		//在初始化的时候，代码块中的所有打印都打印了，则说明初始化
		//静态代码块只初始化一次，其他代码块生命周期和对象相同
		//执行顺序和调用顺序无关
		Employee[] stuff=new Employee[3];
		stuff[0]=new Employee("Harry",3000);
		stuff[1]=new Employee(6000);
		stuff[2]=new Employee();
		for(Employee e:stuff) {
			System.out.println("name="+e.getName()+",id="+e.getID()+",salary="+e.getSalary());
		}
		//Arraylist
		ArrayList<Employee> stuff2=new ArrayList<>();
		stuff2.add(new Employee("Harry",3000));
		stuff2.add(new Employee(6000));
		stuff2.add(new Employee());
		for(Employee e:stuff2) {
			System.out.println("name="+e.getName()+",id="+e.getID()+",salary="+e.getSalary());
		}
		String classname=stuff2.get(0).getClass().getName();
		try {
			//Class对象实际是一种类型，未必是一种类。int不是类，但int.class是一个Class类型的对象。
			Class class1 =Class.forName(classname);
			class1.newInstance();
			Class class2=Random.class;
			Class class3=int.class;
			Class class4=Double.class;
			System.out.println(class4.getName());
			Class class5=Double[].class;
			System.out.println(class5.getName());
			
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		//子类
		Manager[] managers=new Manager[3];
		managers[0]=new Manager("Bob",3000,200);
		managers[1]=new Manager(6000,450);
		managers[2]=new Manager("Tom",4000,200);
		for(Manager e:managers) {
			System.out.println("name="+e.getName()+",id="+e.getID()+",salary="+e.getSalary()+",bonus="+e.getBonus());
		}
		
		if(stuff[0] instanceof Manager) {
			System.out.println("hhhyes");
		}
		if(managers[0] instanceof Employee) {
			System.out.println("yes");
		}
		Integer aInteger=new Integer(1999999);
		int[] a= {1,24,44};
		int[] b= {1,24,44};
		System.out.println(aInteger.hashCode());
		System.out.println(a.hashCode());
		System.out.println(b.hashCode());
	}

}
class Employee{
	private static int nextID;
	private int id;
	private String name;
	private double salary;
	
	public Employee() {
		
	}
	// static initialization block
	static
	{
		Random generator=new Random();
		nextID=generator.nextInt(10000);
		System.out.println("hey");

	}

	{
		id=nextID;
		nextID++;
	}
	public Employee(String n,double s) {
		name=n;
		salary=s;
	}
	{
		System.out.println("Employee(double s)");
	}
	public Employee(double s)
	{
		this("Employee"+nextID, s);
	}

	public String getName() {
		return name;
	}
	public double getSalary() {
		return salary;
	}
	public int getID() {
		return id;
	}
	//判断对象是否相等
	public boolean equals(Object obj) {
		if(this ==obj) return true;
		if(obj==null) return false;
		if(getClass()!=obj.getClass()) return false;
		Employee other=(Employee) obj;
		return Objects.equals(name, other.getName())&&salary==other.getSalary()&& id==other.getID();
	}
	public int hashCode() {
		return Objects.hash(name,salary,id);
	}
	public String toString() {
		return getClass().getName()+"[name="+name+",salary="+salary+",id="+id;
	}
}
