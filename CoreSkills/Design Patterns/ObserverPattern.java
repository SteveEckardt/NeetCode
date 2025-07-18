/**
 * Problem: Observer Pattern (NeetCode Design Patterns)
 * Author: Steve Eckardt
 * Revision Date: July 18, 2025
 *
 * Description: Implements the Observer Pattern to notify subscribed customers when an out-of-stock item becomes available.
 *
 * Time Complexity: O(n) for notifying n observers
 * Space Complexity: O(n) to store subscribed observers
 */

interface Observer {
    // Called when the item becomes available
    void notify(String itemName);
}

// Concrete implementation of an Observer
class Customer implements Observer {
    private String name;
    private int notifications;

    public Customer(String name) {
        this.name = name;
        this.notifications = 0;
    }

    // Receive a notification when item is restocked
    public void notify(String itemName) {
        this.notifications += 1;
    }

    public int countNotifications() {
        return this.notifications;
    }
}

// Observable item that notifies subscribers when restocked
class OnlineStoreItem {
    private String itemName;
    private int stock;
    private List<Observer> observers;

    public OnlineStoreItem(String itemName, int stock) {
        this.itemName = itemName;
        this.stock = stock;
        this.observers = new ArrayList<>();
    }

    // Subscribe a customer to this item's restock alerts
    public void subscribe(Observer observer) {
        observers.add(observer);
    }

    // Unsubscribe a customer
    public void unsubscribe(Observer observer) {
        observers.remove(observer);
    }

    // Update item stock; notify if it goes from 0 to >0
    public void updateStock(int newStock) {
        int oldStock = this.stock;
        this.stock = newStock;

        if (oldStock == 0 && newStock > 0) {
            notifyObservers();
        }
    }

    // Notify all subscribed observers
    private void notifyObservers() {
        for (Observer observer : observers) {
            observer.notify(itemName);
        }
    }
}
