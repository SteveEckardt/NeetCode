/**
 * Pair.java
 * Author: Steve Eckardt
 * Revision Date: July 1, 2025
 *
 * A simple key-value pair class that supports comparison, equality checking,
 * hashing, and string representation. Useful for sorting or storing structured data.
 */

import java.util.Objects;

public class Pair implements Comparable<Pair> {
    public int key;         // Integer key used for sorting and comparison
    public String value;    // Associated string value

    // Constructor to initialize key and value
    public Pair(int key, String value) {
        this.key = key;
        this.value = value;
    }

    // Compare based on the key (natural ordering)
    @Override
    public int compareTo(Pair other) {
        return Integer.compare(this.key, other.key);
    }

    // Check for equality based on key and value
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // Same object reference
        if (obj == null || getClass() != obj.getClass()) return false; // Not the same class
        Pair other = (Pair) obj;
        return this.key == other.key &&
               Objects.equals(this.value, other.value);
    }

    // Compute hash code based on key and value
    @Override
    public int hashCode() {
        return Objects.hash(key, value);
    }

    // Return a readable string representation
    @Override
    public String toString() {
        return "(" + key + ", \"" + value + "\")";
    }
}
