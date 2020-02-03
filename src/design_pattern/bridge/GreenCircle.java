package design_pattern.bridge;

public class GreenCircle implements DrawAPI {
	@Override
	public void drawCircle(int radius, int x, int y){
	      System.out.println("Drawing Circle[ color: Green, radius: "
	    	         + radius +", x: " +x+", "+ y +"]");
	}
}
