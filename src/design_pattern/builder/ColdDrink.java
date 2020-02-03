package design_pattern.builder;

public abstract class ColdDrink implements FoodItem {
	public abstract String name();

	public abstract float price();

	public Packing packing() {
		return new Bottle();
	}
}
