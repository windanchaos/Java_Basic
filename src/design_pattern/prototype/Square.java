package design_pattern.prototype;

public class Square extends Proto_Shape{
	@Override
	public void draw(){
		System.out.println("Drwaing Square");
	}
//	构造函数
	public Square(){
		type="Square";
	}
}
