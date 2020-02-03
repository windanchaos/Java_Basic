package design_pattern.bridge;

public abstract class Shape{

	protected DrawAPI drawAPI;
	protected Shape(DrawAPI drawAPI){
		 this.drawAPI = drawAPI;
	}
	public abstract void draw();    
	
//	public DrawAPI drawAPI=new DrawAPI() {
//		
//		@Override
//		public void drawCircle() {
//			// TODO Auto-generated method stub
//			
//		}
//	};
//	public Shape() {
//	}
//	public abstract String draw();
}
