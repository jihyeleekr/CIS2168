/*<exercise chapter="1" type="programming-exercise" number="6">*/
package KW.CH01.Shapes;

import java.util.Scanner;

/**
 * Represents an Equilateral Triangle. Extends AbstrtactShape.
 */
public class EQTriangle extends AbstrtactShape {
    // Data Fields
    
    /** The cosine of 60 degrees */
    private static final double SIN_60 = Math.sin(Math.PI/3.0);

    /** The side length of thee RtTriangle. */
    private double side = 0;

    // Constructors
    /** Constructs a default RtTriangle */
    public EQTriangle() {
        super("Equiliteral Triangle");
    }

    /**
     * Constructs a Right Triangle of the specified size.
     * @param side the side
     */
    public EQTriangle(double side) {
        /*Your code here */
        super("Equiliteral Triangle");
        this.side = side;
    }

    // Methods
    /**
     * Get the side.
     *
     * @return The side
     */
    public double getSide() {
        return side;
    }

    /**
     * Get the height.
     *
     * @return The height
     */
    @Override
    public double getHeight() {
        return SIN_60 * side;
    }
    
    
    /**
     * Get the width
     * @return base is the same as width
     */
    @Override
    public double getWidth() {
        return side;
    }

    /**
     * Compute the area.
     *
     * @return The area of the RtTriangle
     */
    @Override
    public double computeArea() {
        /*Your Code Here*/
        return Math.sqrt(3) /4  * Math.pow(side, 2);
    }

    /**
     * Compute the perimeter.
     *
     * @return The perimeter of the RtTriangle
     */
    @Override
    public double computePerimeter() {
        	/*Your Code Here*/
            return 3 * side;
    }

    /**
     * Read the attributes of the Right Triangle.
     */
    @Override
    public void readShapeData() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the side of the Equilateral Triangle");
        side = in.nextDouble();
    }

    /**
     * Create a string representation of the RtTriangle.
     *
     * @return A string representation of the RtTriangle
     */
    @Override
    public String toString() {
        return super.toString() + ": side is " + side;
    }
    
}
/*</exercise>*/
