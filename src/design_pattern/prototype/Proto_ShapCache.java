package design_pattern.prototype;

import java.util.Hashtable;

public class Proto_ShapCache {
	// Hashtable装对象的容器
	private static Hashtable<String, Proto_Shape> shapeMap = new Hashtable<String, Proto_Shape>();
	//	返回容器中的对象
	public static Proto_Shape getShape(String shapId) {
		Proto_Shape cacheShape = shapeMap.get(shapId);
		return (Proto_Shape) cacheShape;
	}

	// 产生对象后load进Hashtable
	   // 比如对每种形状都运行数据库查询，并创建该形状
	   // shapeMap.put(shapeKey, shape);
	   // 例如，我们要添加三种形状
	public static void loadCache() {
		Circle circle = new Circle();
		circle.setId("1");
		shapeMap.put(circle.getId(), circle);

		Square square = new Square();
		square.setId("2");
		shapeMap.put(square.getId(), square);

		Rectangle rectangle = new Rectangle();
		rectangle.setId("3");
		shapeMap.put(rectangle.getId(), rectangle);
	}
}
