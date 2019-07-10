/** 
* Project Name:Java_Basic 
* Package Name:faceObject 
* File Name:Student.java 
* Date:2018年9月10日下午9:52:17 
*/
package faceObject;

/**
 * ClassName: Student <br/>
 * Function: TODO 功能说明. <br/>
 * 
 * date: 2018年9月10日 下午9:52:17 <br/>
 * 
 * @author ChaosBom
 * @version
 * @since JDK 1.8
 * 
 * @modified By： <修改人> <br/>
 * @modified Date:<修改日期> <br/>
 * @desc：修改日志 <修改描述> <br/>
 */
public class Student
{
	int id;
	String name;
	short age;
	Computer computer;
	public void study()
	{
		System.out.println(this.name+"正在学习,使用的电脑品牌是："+this.computer.brand);
	}

	public void play()
	{
		System.out.println(this.name+"正在玩游戏,电脑品牌是："+this.computer.brand);
	} 

	/**
	 * 描述这个方法的作用
	 * 
	 * @author ChaosBom
	 * @param args
	 */
	public static void main(String[] args)
	{
		Student student=new Student();
		student.id=212;
		student.name="bobo";
		student.age=32;
		Computer computer=new Computer();
		computer.brand="DELL";
		student.computer=computer;
		student.study();
		student.play();
		int[] a={3,55,13,997,31,981};
		for( int i:a){
			System.out.print(i+" ");
		}
		Integer a1 =new Integer(21);
		System.out.println(Integer.MIN_VALUE);
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.toBinaryString(Integer.MAX_VALUE).length());
		System.out.println(Integer.toBinaryString(Integer.MIN_VALUE).length());
		System.out.println(Integer.reverseBytes(a1));
		Long long1=1233L;
		System.out.println("Long型长度："+long1.SIZE);
		System.out.println("Integer型长度："+a1.SIZE);
		System.out.println("byte长度："+Byte.SIZE);
		// -128到127会当作基本数据类型处理
		Integer d1=128;
		Integer d2=128;
		System.out.println(d1==d2);
		System.out.println(d1.equals(d2));
		
	}

}

class Computer
{
	String brand;
}