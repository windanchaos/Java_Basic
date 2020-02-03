package design_pattern.prototype;

public class PrototypePatternDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//加载和初始化对象
		Proto_ShapCache.loadCache();
		//使用对象
		Proto_Shape cloneShape_circle=(Proto_Shape) Proto_ShapCache.getShape("1");
		System.out.println("Clone :"+cloneShape_circle.getType());
		cloneShape_circle.draw();
		
		Proto_Shape cloneShape_square=(Proto_Shape) Proto_ShapCache.getShape("2");
		System.out.println("Clone :"+cloneShape_square.getType());
		cloneShape_square.draw();		

		Proto_Shape cloneShape_rectangle=(Proto_Shape) Proto_ShapCache.getShape("3");
		System.out.println("Clone :"+cloneShape_rectangle.getType());
		cloneShape_rectangle.draw();	

	}

}
