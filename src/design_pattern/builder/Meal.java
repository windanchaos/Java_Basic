package design_pattern.builder;

import java.util.ArrayList;
import java.util.List;
//实现建造模式的核心机制
public class Meal {
	private List<FoodItem> foodItems=new ArrayList<FoodItem>();
	public void addFoodIteme(FoodItem foodItem) {
		foodItems.add(foodItem);
	}
	
	public float getCost(){
		float cost=0f;
		for(FoodItem foodItem:foodItems){
			cost+=foodItem.price();
		}
		return cost;
	}
	
	public void showFoodItems(){
		for(FoodItem foodItem:foodItems){
			System.out.println("Food:"+foodItem.name()+"   Price:"+foodItem.price()+"   Packing use:" + foodItem.packing().pack());
		}
	}
}
