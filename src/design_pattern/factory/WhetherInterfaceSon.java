package design_pattern.factory;

public class WhetherInterfaceSon implements Shape,Color{

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.println("draw in color");
	}

	@Override
	public void fillColor() {
		// TODO Auto-generated method stub
		System.out.println("Fill color");
	}

}
