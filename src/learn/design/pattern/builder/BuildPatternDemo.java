package learn.design.pattern.builder;

public class BuildPatternDemo {

	public static void main(String[] args) {
		MealBuilder mealBuilder = new MealBuilder();
		
		Meal vegMeal = mealBuilder.prepareVegMeal();
		System.out.println("Veg Meal:");
		vegMeal.showItems();
		System.out.println("Total Cost:"+vegMeal.getCost());
		
		Meal nonVegMeal = mealBuilder.prepareNonVegMeal();
		System.out.println("NonVeg Meal Meal:");
		nonVegMeal.showItems();
		System.out.println("Total Cost:"+vegMeal.getCost());
		
	}
}
