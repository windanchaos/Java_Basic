package design_pattern.builder;

public abstract class Burger implements FoodItem {

	public abstract String name();

	public abstract float price();
//汉堡的包装是确定的
	public Packing packing(){
		return new Wrapper();
	};
}
