/**
 * Problem: NeetCode - Builder Pattern  
 * Author: Steve Eckardt  
 * Revision Date: July 5, 2025  
 *
 * Demonstrates the Builder Pattern for constructing complex Meal objects using method chaining.
 */

class Meal {

    private double cost;
    private boolean takeOut;
    private String main;
    private String drink;

    // Getters
    double getCost() {
        return this.cost;
    }

    boolean getTakeOut() {
        return this.takeOut;
    }

    String getMain() {
        return this.main;
    }

    String getDrink() {
        return this.drink;
    }

    // Setters (only accessible to the builder)
    void setCost(double cost) {
        this.cost = cost;
    }

    void setTakeOut(boolean takeOut) {
        this.takeOut = takeOut;
    }

    void setMain(String main) {
        this.main = main;
    }

    void setDrink(String drink) {
        this.drink = drink;
    }
}

class MealBuilder {
    private Meal meal;

    // Initializes a fresh Meal object
    public MealBuilder() {
        meal = new Meal();
    }

    // Add cost to the meal
    public MealBuilder addCost(double cost) {
        meal.setCost(cost);
        return this;
    }

    // Specify whether it’s takeout or dine-in
    public MealBuilder addTakeOut(boolean takeOut) {
        meal.setTakeOut(takeOut);
        return this;
    }

    // Set the main course
    public MealBuilder addMainCourse(String main) {
        meal.setMain(main);
        return this;
    }

    // Add a drink option
    public MealBuilder addDrink(String drink) {
        meal.setDrink(drink);
        return this;
    }

    // Final step: return the fully-built Meal
    Meal build() {
        return meal;
    }
}
