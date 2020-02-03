package design_pattern.prototype;

public class Circle extends Proto_Shape {
	@Override
	public void draw(){
		System.out.println("Drwaing Circle");
	}
//	构造函数
	public Circle(){
		type="Circle";
	}

}
