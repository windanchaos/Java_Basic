package design_pattern.singleton;

public class SingleObject {
	
//	类加载时就初始化，浪费内存
	private static SingleObject singleton=new SingleObject();
	
//	构造函数一般不用加修饰符，这里使用private阻止了类对象生成，只能通过类静态方法调用
	private SingleObject(){
	}
	
	public static SingleObject getInstance(){
		return singleton;
	}
//	生成一个测试计数的方法
	private static Integer CallNumber=0;

	public static Integer getCallNumber() {
		CallNumber=CallNumber+1;
		return CallNumber;
	}
	
}
