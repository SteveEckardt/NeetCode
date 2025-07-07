/**
 * Problem: NeetCode - Adapter Pattern  
 * Author: Steve Eckardt  
 * Revision Date: July 7, 2025  
 *
 * Demonstrates the Adapter Pattern by allowing a Circle object to be used where a Square is expected.
 *
 * Time Complexity: O(1) — constant-time conversion and comparison
 * Space Complexity: O(1) — stores a single reference to the Circle
 */

class SquareHole {
    private double sideLength;

    public SquareHole(double sideLength) {
        this.sideLength = sideLength;
    }

    // Accepts any square with a side length that fits
    public boolean canFit(Square square) {
        return this.sideLength >= square.getSideLength();
    }
}

// Target interface (expected shape)
class Square {
    protected double sideLength;

    public Square() {}

    public Square(double sideLength) {
        this.sideLength = sideLength;
    }

    public double getSideLength() {
        return this.sideLength;
    }
}

// Incompatible class (to be adapted)
class Circle {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return this.radius;
    }
}

// Adapter that wraps a Circle and exposes it as a Square
class CircleToSquareAdapter extends Square {
    private Circle circle;

    public CircleToSquareAdapter(Circle circle) {
        this.circle = circle;
        // Adapts the circle by computing the diameter as the square's side
        this.sideLength = 2 * circle.getRadius();
    }

    // Optional: override getSideLength() if dynamic value is preferred
    /*
    @Override
    public double getSideLength() {
        return 2 * circle.getRadius();
    }
    */
}
