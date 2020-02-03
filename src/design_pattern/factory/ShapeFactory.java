package design_pattern.factory;

/**
 * @author ChaosBom
 * ShapeFactory 接受传递的消息，反馈具体的类
 */

public class ShapeFactory {
//	这里使用Shape作为方法返回类型是因为什么？实现类实现了接口，相当了接口的实现类是接口的儿子.
//	尝试使用Object作为返回类型，在具体使用的时候，需要强制类型转换.所有用半个儿子坐返回类型没有问题。
	public Shape getShape(String shapeType){
		if (shapeType.isEmpty()){
			return null;
		}
		if (shapeType.equalsIgnoreCase("CIRCLE")){
			return new Circle();
		}
		if (shapeType.equalsIgnoreCase("RECTANGLE")){
			return new Rectangle();
		}
		if (shapeType.equalsIgnoreCase("SQUARE")){
			return new Square();
		}
//		实现类当了儿子
		if(shapeType.equalsIgnoreCase("COLOR")){
			return new WhetherInterfaceSon();
		}
		return null;
	}
//	实现类当了儿子
	public Color getColor(String color){
		
		if (color.equalsIgnoreCase("color")){
			return new WhetherInterfaceSon();
		}
		return null;
	}
}
