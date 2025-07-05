/**
 * Problem: NeetCode - Singleton Pattern  
 * Author: Steve Eckardt  
 * Revision Date: July 4, 2025  
 *
 * Demonstrates lazy-initialized, thread-safe singleton using double-checked locking 
 * — a classic example of controlled global state in object-oriented design.
 *
 */

static class Singleton {

    // Volatile ensures visibility and ordering in multithreaded access
    private static volatile Singleton instance = null;

    private String value = null;

    // Private constructor prevents external instantiation
    private Singleton() {
        this.value = "Singleton";
    }

    // Thread-safe, lazy-loaded singleton using double-checked locking
    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null)
                    instance = new Singleton();
            }
        }
        return instance;
    }

    // Accessor for value
    public String getValue() {
        return this.value;
    }

    // Mutator for value
    public void setValue(String value) {
        this.value = value;
    }
}
