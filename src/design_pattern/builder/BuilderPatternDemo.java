package design_pattern.builder;

public class BuilderPatternDemo {

	public static void main(String[] args) {
	      MealBuilder mealBuilder = new MealBuilder();

	      Meal vegMeal = mealBuilder.VegBurger_DrinkPepsi();
	      System.out.println("VegBurger_DrinkPepsi");
	      vegMeal.showFoodItems();
	      System.out.println("Total Cost: " +vegMeal.getCost());

	      Meal nonVegMeal = mealBuilder.VegBurger_DrinkPepsi();
	      System.out.println("\n\nVegBurger_DrinkPepsi");
	      nonVegMeal.showFoodItems();
	      System.out.println("Total Cost: " +nonVegMeal.getCost());
	   }
	}
