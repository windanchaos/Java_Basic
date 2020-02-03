package design_pattern.builder;

//通过工厂提供的构建方法来构建已经存在的类

public class MealBuilder {
	public MealBuilder(){
		
	}
	
	public Meal VegBurger_DrinkPepsi(){
		Meal meal=new Meal();
		//直接添加需要构建的类
		//可以被添加的类是实现了接口的类
		meal.addFoodIteme(new VegBurger());
		meal.addFoodIteme(new Pepsi());
		return meal;
		
	}
	public Meal VegBurger_DrinkCoke(){
		Meal meal=new Meal();
		//直接添加需要构建的类
		//可以被添加的类是实现了接口的类
		meal.addFoodIteme(new VegBurger());
		meal.addFoodIteme(new Coke());
		return meal;
		
	}
	
	public Meal ChickenBurger_DrinkCoke(){
		Meal meal=new Meal();
		//直接添加需要构建的类
		//可以被添加的类是实现了接口的类
		meal.addFoodIteme(new ChickenBurger());
		meal.addFoodIteme(new Coke());
		return meal;
		
	}
	public Meal ChickenBurger_DrinkPepsi(){
		Meal meal=new Meal();
		//直接添加需要构建的类
		//可以被添加的类是实现了接口的类
		meal.addFoodIteme(new Pepsi());
		meal.addFoodIteme(new ChickenBurger());
		return meal;
		
	}
	
	public Meal DrinkCokePepsi(){
		Meal meal=new Meal();
		//直接添加需要构建的类
		//可以被添加的类是实现了接口的类
		meal.addFoodIteme(new Pepsi());
		meal.addFoodIteme(new Coke());
		return meal;
		
	}
}
