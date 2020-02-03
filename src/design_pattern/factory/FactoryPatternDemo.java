package design_pattern.factory;

public class FactoryPatternDemo {

	public static void main(String[] args) {
		// 用户只需要知道工厂类中提供哪些名称的类名，直接调用即可得到自己需要的类
		ShapeFactory shapeFactory=new ShapeFactory();
		Shape shape1=shapeFactory.getShape("Circle");
		shape1.draw();
		
		//实现类当儿子用，但是不是自己基因的调用不了
		Color color1=shapeFactory.getColor("color");
		color1.fillColor();
		((Shape) color1).draw();
	}

}
