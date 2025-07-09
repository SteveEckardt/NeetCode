/**
 * Problem: Decorator Pattern  
 * Author: Steve Eckardt  
 * Revision Date: July 9, 2025  
 *
 * Adds optional features (milk, sugar, cream) to a base coffee dynamically using the decorator pattern.
 *
 * Time Complexity: O(n) — where n is the number of decorators applied  
 * Space Complexity: O(n) — due to nested decorator wrapping
 */

abstract class Coffee {
    // Every coffee must report its cost
    public abstract double getCost();
}

// Base black coffee
class SimpleCoffee extends Coffee {
    @Override
    public double getCost() {
        return 1.1;
    }
}

// Abstract decorator to allow layering
abstract class CoffeeDecorator extends Coffee {
    protected Coffee decoratedCoffee;

    public CoffeeDecorator(Coffee coffee) {
        this.decoratedCoffee = coffee;
    }

    @Override
    public double getCost() {
        return decoratedCoffee.getCost(); // Base pass-through
    }
}

// Adds milk to the coffee
class MilkDecorator extends CoffeeDecorator {
    public MilkDecorator(Coffee coffee){
        super(coffee);
    }

    @Override
    public double getCost() {
        return 0.5 + decoratedCoffee.getCost();
    }
}

// Adds sugar to the coffee
class SugarDecorator extends CoffeeDecorator {
    public SugarDecorator(Coffee coffee){
        super(coffee);
    }

    @Override
    public double getCost() {
        return 0.2 + decoratedCoffee.getCost();
    }	
}

// Adds cream to the coffee
class CreamDecorator extends CoffeeDecorator {
    public CreamDecorator(Coffee coffee){
        super(coffee);
    }

    @Override
    public double getCost() {
        return 0.7 + decoratedCoffee.getCost();
    }	
}
