/*<exercise chapter="1" type="programming-project" number="6">*/
package KW.CH01.Shapes;
import java.util.Scanner;

/**
 * Represents a square.
 * Extends AbstrtactShape.
 */
public class Square extends AbstrtactShape {
    // Data Fields

    /** The side length of the circle */
    private double side = 0;

    // Constructors
    /** Constructs a default Square */
    public Square() {
        super("Square");
    }

    /**
     * Constructs a sqyare of the specified size.
     * @param side the side length
     */
    public Square(double side) {
        super("Square");
        this.side = side;

		/*Your Code Here*/
    }

    // Methods
    /**
     * Get the side.
     * @return The radius
     */
    public double getSide() {
        return side;
    }
    
    /**
     * Set the radius
     * @param side The size of a side
     */
    public void setSide(double side) {
        this.side = side;
    }
    
    /**
     * Get the width of the square
     * @return The side length
     */
    @Override
    public double getWidth() {
        return side;
    }
    
    /**
     * Get the height of the square
     * @return The side length
     */
    @Override
    public double getHeight() {
        return side;
    }
    

    /**
     * Compute the area.
     * @return The area of the square
     */
    @Override
    public double computeArea() {
		/*Your Code Here*/
        return Math.pow(side, 2);
    }

    /**
     * Compute the perimeter.
     * @return The perimeter of the square
     */
    @Override
    public double computePerimeter() {
		/*Your Code Here*/
        return 4 * side;


    }

    /** Read the attributes of the circle. */
    @Override
    public void readShapeData() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the side length of the Square");
        side = in.nextDouble();
    }

    /**
     * Create a string representation of the circle.
     * @return A string representation of the circle
     */
    @Override
    public String toString() {
        return super.toString() + ": side length is " + side;
    }
}
/*</exercise>*/
