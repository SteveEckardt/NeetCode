/**
 * Problem: Facade Pattern (NeetCode Design Patterns)
 * Author: Steve Eckardt
 * Revision Date: July 16, 2025
 *
 * Description: Implements the Facade Design Pattern to simplify a multi-step food ordering system
 *              by abstracting the roles of cashier, chef, and packaging staff behind a single interface.
 *
 * Time Complexity: O(1) — all operations are constant time object creation or string manipulation
 * Space Complexity: O(1) — no dynamic collections or recursion; memory usage is fixed per order
 */

class Order {
    private String contents;
    private boolean takeOut;

    public Order(String contents, boolean takeOut) {
        this.contents = contents;
        this.takeOut = takeOut;
    }

    public String getOrder() {
        return contents;
    }

    public boolean isTakeOut() {
        return takeOut;
    }
}

class Cashier {
    // Creates and returns a new order
    public Order takeOrder(String contents, boolean takeOut) {
        return new Order(contents, takeOut);
    }
}

class Food {
    private String contents;

    public Food(String order) {
        this.contents = order;
    }

    public String getFood() {
        return contents;
    }
}

class Chef {
    // Prepares food based on the order
    public Food prepareFood(Order order) {
        return new Food(order.getOrder());
    }
}

class PackagedFood extends Food {
    // Adds packaging to the food item
    public PackagedFood(Food food) {
        super(food.getFood() + " in a bag");
    }
}

class KitchenStaff {
    // Packages the prepared food
    public PackagedFood packageOrder(Food food) {
        return new PackagedFood(food);
    }
}

class DriveThruFacade {
    // Facade provides a simplified interface for placing and fulfilling an order
    private Cashier cashier = new Cashier();
    private Chef chef = new Chef();
    private KitchenStaff kitchenStaff = new KitchenStaff();

    public Food takeOrder(String orderContents, boolean takeOut) {
        // Step 1: Take the order (delegated to Cashier)
        Order order = cashier.takeOrder(orderContents, takeOut);

        // Step 2: Prepare the food (delegated to Chef)
        Food food = chef.prepareFood(order);

        // Step 3: If takeout, package the food (delegated to KitchenStaff)
        return takeOut ? kitchenStaff.packageOrder(food) : food;
    }
}
