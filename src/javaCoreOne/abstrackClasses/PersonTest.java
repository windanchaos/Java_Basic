package javaCoreOne.abstrackClasses;

import java.util.Arrays;

public class PersonTest {

	public static void main(String[] args) {
		Person[] people=new Person[2];
		people[0]=new Employee("HarryBoT", 12000, 2005, 4, 1);
		people[1]=new Student("BgoR", "AoSeC");
		for(Person p:people) {
			System.out.println(p.getName()+","+p.getDescription());
		}
		/*
		 * 接口实现的测试
		 */
		Employee[] staff=new Employee[3];
		staff[0]=new Employee("Harryhacker", 35000, 2015, 12, 22);
		staff[1]=new Employee("CarlCracker", 65000, 2015, 12, 22);
		staff[2]=new Employee("TonyTest", 55000, 2015, 12, 22);
		Arrays.sort(staff);
		for(Employee e:staff) {
			System.out.println("name="+e.getName()+",salary="+e.getSalary());
		}
	}

}
