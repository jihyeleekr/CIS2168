/*<exercise chapter="1" section="8" type="programming" number="1">*/
package KW.CH01.Shapes;

import java.util.Scanner;

/**
 * Represents a circle.
 * Extends AbstrtactShape.
 */
public class Circle extends AbstrtactShape {
    // Data Fields

    /** The radius of the circle */
    private double radius = 0;

    // Constructors
    /** Constructs a default Circle */
    public Circle() {
        super("Circle");
    }

    /**
     * Constructs a circle of the specified size.
     * @param radius the radius
     */
    public Circle(double radius) {
        super("Circle");
        this.radius = radius;
    }

    // Methods
    /**
     * Get the radius.
     * @return The radius
     */
    public double getRadius() {
        return radius;
    }
    
    /**
     * Set the radius
     * @param radius the new value of the radius
     */
    public void setRadius(double radius) {
        this.radius = radius;
    }
    
    /**
     * Get the width of the circle
     * @return Two times the radius
     */
    @Override
    public double getWidth() {
        return 2 * radius;
    }
    
    /**
     * Get the height of the circle
     * @return Two times the radius
     */
    @Override
    public double getHeight() {
        return 2 * radius;
    }
    

    /**
     * Compute the area.
     * @return The area of the circle
     */
    @Override
    public double computeArea() {
        return Math.PI * radius * radius;
    }

    /**
     * Compute the perimeter.
     * @return The perimeter of the circle
     */
    @Override
    public double computePerimeter() {
        return 2 * Math.PI * radius;
    }

    /** Read the attributes of the circle. */
    @Override
    public void readShapeData() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the radius of the Circle");
        radius = in.nextDouble();
    }

    /**
     * Create a string representation of the circle.
     * @return A string representation of the circle
     */
    @Override
    public String toString() {
        return super.toString() + ": radius is " + radius;
    }
}
/*</exercise>*/
