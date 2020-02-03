package design_pattern.prototype;

public class Rectangle extends Proto_Shape{
	@Override
	public void draw(){
		System.out.println("Drwaing Rectangle");
	}
//	构造函数
	public Rectangle(){
		type="Rectangle";
	}
}
