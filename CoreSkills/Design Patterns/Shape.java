/**
 * Problem: NeetCode - Prototype Pattern  
 * Author: Steve Eckardt  
 * Revision Date: July 6, 2025  
 *
 * Demonstrates the Prototype Pattern by cloning shape objects through a common interface.
 *
 * Time Complexity:
 * - clone() for each shape => O(1)
 * - cloneShapes(List)     => O(n)
 *
 * Space Complexity:
 * - O(n) for storing new cloned shape objects
 */

// Common interface for all shapes with a clone method
interface Shape {
    Shape clone();
}

// Rectangle implementation of Shape
class Rectangle implements Shape {
    private int width;
    private int height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    // Clone by creating a new instance with same properties
    @Override
    public Shape clone() {
        return new Rectangle(this.width, this.height);
    }
}

// Square implementation of Shape
class Square implements Shape {
    private int length;

    public Square(int length) {
        this.length = length;
    }

    public int getLength() {
        return this.length;
    }

    // Clone by creating a new instance with same property
    @Override
    public Shape clone() {
        return new Square(this.length);
    }
}

// Client code that clones a list of shapes
class Test {
    public List<Shape> cloneShapes(List<Shape> shapes) {
        List<Shape> result = new ArrayList<>();
        for (Shape s : shapes) {
            result.add(s.clone());
        }
        return result;
    }
}
